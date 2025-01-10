import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Verwaltung extends JFrame {
    private JPanel myPanel;
    private JLabel LabelName;
    private JTextField textFieldName;
    private JLabel LabelNachname;
    private JTextField textFieldNachname;
    private JLabel LabelGeburtsdatum;
    private JTextField textFieldGeburtsdatum;
    private JComboBox<String> comboBoxVersicherungPrivat;
    private JComboBox<String> comboBoxVersicherungGesetz;
    private JLabel Labelnummer;
    private JTextField textFieldnummer;
    private JRadioButton radioButtongesetz;
    private JRadioButton radioButtonprivat;
    private JButton buttonSpeichern;
    private JTextArea textAreaAusgabe;
    private JLabel LabelAnamnese;
    private JTextField textFieldAnamnese;
    private JButton buttonAbschicken;
    private JButton buttonfiltern;
    private ButtonGroup versicherungGroup;
    private List<Patient> patientenListe;

    public Verwaltung() {
        patientenListe = new ArrayList<>();
        initPatienten();
        initVersicherungen();


        myPanel.setBackground(new Color(232,242,255));

        setContentPane(myPanel);
        setTitle("Patienten Aktenverwaltung");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

        textAreaAusgabe.setEditable(false);

        versicherungGroup = new ButtonGroup();
        versicherungGroup.add(radioButtongesetz);
        versicherungGroup.add(radioButtonprivat);

        radioButtongesetz.addActionListener(e -> {
            comboBoxVersicherungGesetz.setEnabled(true);
            comboBoxVersicherungPrivat.setEnabled(false);
        });

        radioButtonprivat.addActionListener(e -> {
            comboBoxVersicherungGesetz.setEnabled(false);
            comboBoxVersicherungPrivat.setEnabled(true);
        });

        // Button "Speichern" Logik
        buttonSpeichern.addActionListener(e -> {
            try {
                String vorname = textFieldName.getText().trim();
                String nachname = textFieldNachname.getText().trim();
                LocalDate geburtsdatum;

                try {
                    geburtsdatum = LocalDate.parse(textFieldGeburtsdatum.getText().trim());
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(myPanel, "Ungültiges Geburtsdatum! Bitte im Format YYYY-MM-DD eingeben.",
                            "Fehler", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int versichertennr = Integer.parseInt(textFieldnummer.getText().trim());

                for (int i = 0; i < patientenListe.size(); i++) {
                    if (versichertennr == patientenListe.get(i).getVerischertennr()) {
                        JOptionPane.showMessageDialog(myPanel, "Der Patient mit eingegebener Versichertennummer existiert bereits",
                                "Fehler", JOptionPane.ERROR_MESSAGE);
                    }
                }

                //int versichertennr = Integer.parseInt(textFieldnummer.getText().trim());
                String anamnese = textFieldAnamnese.getText().trim();

                boolean istPrivat = radioButtonprivat.isSelected();
                String versicherung = istPrivat ? (String) comboBoxVersicherungPrivat.getSelectedItem() : (String) comboBoxVersicherungGesetz.getSelectedItem();

                Patient neuerPatient = new Patient(vorname, nachname, geburtsdatum, true, anamnese, versichertennr);
                patientenListe.add(neuerPatient);


                StringBuilder output = new StringBuilder("Gespeicherte Patienten:\n");
                for (Patient patient : patientenListe) {
                    output.append(patient).append("\n");
                }
                textAreaAusgabe.setText(output.toString());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(myPanel, "Ungültige Eingabe bei der Versicherungsnummer!",
                        "Fehler", JOptionPane.ERROR_MESSAGE);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(myPanel, "Ein unbekannter Fehler ist aufgetreten!",
                        "Fehler", JOptionPane.ERROR_MESSAGE);
                exception.printStackTrace();
            }
        });

        // Button "Abschicken" Logik
        buttonAbschicken.addActionListener(e -> {

            textAreaAusgabe.setText("");
            textFieldGeburtsdatum.setText("");
            textFieldName.setText("");
            textFieldAnamnese.setText("");
            textFieldnummer.setText("");
            textFieldNachname.setText("");

            //Radibutton zurück seztzen
            versicherungGroup.clearSelection();
            comboBoxVersicherungPrivat.setEnabled(false);
            comboBoxVersicherungGesetz.setEnabled(false);
            comboBoxVersicherungGesetz.setSelectedIndex(0);
            comboBoxVersicherungPrivat.setSelectedIndex(0);
            // Alle hinzugefügten Patienten löschen
            //patientenListe.clear();
            //initPatienten(); // Initiale Patienten wieder herstellen

            // Nachricht anzeigen
            JOptionPane.showMessageDialog(myPanel, "Überweisung weitergegeben!");

            // Fenster schließen
            dispose();
        });

        buttonfiltern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Sortieren Patienten nach Alphabet
                Collections.sort(patientenListe, (p1, p2) -> p1.getNachname().compareTo(p2.getNachname()));

                //Ausgabe der sortierten Liste
                StringBuilder ausgabe = new StringBuilder("Patientenliste sortiert nach Nachname: \n");
                for (Patient p : patientenListe) {
                    ausgabe.append(p.getNachname()).append(", ").append(p.getVorname()).append(",").append(p.getGeburtsdatum()).append(",").append(p.getVerischertennr()).append(",").append(p.getAnamnese()).append("\n");
                }
                textAreaAusgabe.setText(ausgabe.toString());
            }
        });
    }


    private void initVersicherungen() {
        comboBoxVersicherungPrivat.addItem("Allianz Private Krankenversicherung (APKV)");
        comboBoxVersicherungPrivat.addItem("Debeka Krankenversicherung");
        comboBoxVersicherungPrivat.addItem("Signal Iduna Krankenversicherung");
        comboBoxVersicherungPrivat.addItem("AXA Krankenversicherung");
        comboBoxVersicherungPrivat.addItem("DKV (Deutsche Krankenversicherung)");
        comboBoxVersicherungPrivat.addItem("HanseMerkur Krankenversicherung");
        comboBoxVersicherungPrivat.addItem("HUK-COBURG Krankenversicherung");
        comboBoxVersicherungPrivat.addItem("R+V Krankenversicherung");
        comboBoxVersicherungPrivat.addItem("Continentale Krankenversicherung");
        comboBoxVersicherungPrivat.addItem("Barmenia Krankenversicherung");
        comboBoxVersicherungPrivat.addItem("Sonstige");

        comboBoxVersicherungGesetz.addItem("AOK");
        comboBoxVersicherungGesetz.addItem("Barmer Krankenkasse");
        comboBoxVersicherungGesetz.addItem("Techniker Krankenkasse (TK)");
        comboBoxVersicherungGesetz.addItem("DAK-Gesundheit");
        comboBoxVersicherungGesetz.addItem("BKK");
        comboBoxVersicherungGesetz.addItem("IKK (Innungskrankenkassen)");
        comboBoxVersicherungGesetz.addItem("Knappschaft");
        comboBoxVersicherungGesetz.addItem("SBK (Siemens-Betriebskrankenkasse)");
        comboBoxVersicherungGesetz.addItem("hkk Krankenkasse");
        comboBoxVersicherungGesetz.addItem("KKH (Kaufmännische Krankenkasse)");
        comboBoxVersicherungGesetz.addItem("Sonstige");
    }

    private void initPatienten() {
        patientenListe.add(new Patient("Meryem", "Sahin", LocalDate.of(1999, 7, 15), true, "Lunatumnekrose", 108310400));
        patientenListe.add(new Patient("Georgina", "Diem", LocalDate.of(2002, 10, 13), false, "Bänderriss", 108310600));
        patientenListe.add(new Patient("Lien", "Awaza", LocalDate.of(2007, 1, 20), true, "Magenschleimhautentzündung", 109560955));

        // Initiale Patienten direkt in der TextArea anzeigen
        StringBuilder output = new StringBuilder("Gespeicherte Patienten:\n");
        for (Patient patient : patientenListe) {
            output.append(patient).append("\n");
        }
        textAreaAusgabe.setText(output.toString());
    }

    public static void main(String[] args) {
        new Verwaltung();
    }
}