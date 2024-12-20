import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Verwaltung extends JFrame {
    private JPanel myPanel;
    private JLabel LabelName;
    private JTextField textFieldName;
    private JLabel LabelNachname;
    private JTextField textFieldNachname;
    private JLabel LabelGeburtsdatum;
    private JTextField textFieldGeburtsdatum;
    private JComboBox comboBoxVersicherungPrivat;
    private JComboBox comboBoxVersicherungGesetz;
    private JLabel Labelnummer;
    private JTextField textFieldnummer;
    private JRadioButton radioButtongesetz;
    private JRadioButton radioButtonprivat;
    private JButton buttonÜberprüfen;
    private JTextArea textAreaAusgabe;

    public Verwaltung () {
        setContentPane(myPanel);
        setTitle ("Patientenprofil");
        setSize(750,1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(myPanel);
        setVisible(true);
        setResizable(false);


        radioButtongesetz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        radioButtonprivat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        comboBoxVersicherungPrivat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        comboBoxVersicherungGesetz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        textFieldName.addKeyListener(new KeyAdapter() {
            //@Override
            public void keyreleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });


        textFieldNachname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });

        textFieldGeburtsdatum.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
        textFieldnummer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });

        buttonÜberprüfen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }



    public static void main(String[] args) {
        new Verwaltung();
        }
    }