import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
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
    private ButtonGroup versicherungGroup;
    private List<Patient> patientenListe;

    public Verwaltung() {
        // Initialisierung der Patientenliste und GUI
        patientenListe = new ArrayList<>();
        initPatienten(); // Beispiel-Patienten hinzufügen

        setContentPane(myPanel);
        setTitle("Überweisungsbericht");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

        // TextArea nicht bearbeitbar machen
        textAreaAusgabe.setEditable(false);

        // Radiobuttons in einer Gruppe zusammenfassen
        versicherungGroup = new ButtonGroup();
        versicherungGroup.add(radioButtongesetz);
        versicherungGroup.add(radioButtonprivat);

        // ActionListener für Radiobuttons
        radioButtongesetz.addActionListener(e -> {
            comboBoxVersicherungGesetz.setEnabled(true);
            comboBoxVersicherungPrivat.setEnabled(false);
        });

        radioButtonprivat.addActionListener(e -> {
            comboBoxVersicherungGesetz.setEnabled(false);
            comboBoxVersicherungPrivat.setEnabled(true);
        });

        // ActionListener für den Überprüfen-Button
        buttonSpeichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Eingaben aus den Textfeldern auslesen
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

                    // Patient in der Liste suchen
                    Patient gefundenerPatient = suchePatient(vorname, nachname, geburtsdatum);

                    if (gefundenerPatient != null) {
                        textAreaAusgabe.setText("Gefundener Patient:\n" + gefundenerPatient);
                    } else {
                        textAreaAusgabe.setText("Kein Patient mit den angegebenen Daten gefunden.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(myPanel, "Ungültige Versicherungsnummer! Bitte nur Zahlen eingeben.",
                            "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Beispiel-Patienten hinzufügen
    private void initPatienten() {
        patientenListe.add(new Patient("Meryem", "Sahin", LocalDate.of(1999, 7, 15), true, "Lunatumnekrose", 108310400));
        patientenListe.add(new Patient("Georgina", "Diem", LocalDate.of(2002, 10, 13), true, "Bänderriss", 108310600));
        patientenListe.add(new Patient("Lien", "Awaza", LocalDate.of(2007, 1, 20), true, "Magenschleimhautentzündung", 109560955));
    }

    // Patient suchen
    private Patient suchePatient(String vorname, String nachname, LocalDate geburtsdatum) {
        for (Patient patient : patientenListe) {
            if (patient.getVorname().equalsIgnoreCase(vorname) &&
                    patient.getNachname().equalsIgnoreCase(nachname) &&
                    patient.getGeburtsdatum().equals(geburtsdatum)) {
                return patient;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new Verwaltung();
    }
}
