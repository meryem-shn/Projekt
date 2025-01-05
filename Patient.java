import java.time.LocalDate;

public class Patient {
    //Attribute
    private String vorname;
    private String nachname;
    private LocalDate geburtsdatum;
    private boolean registriert;
    private String anamnese;
    private int versichertennr;

    //Konstruktor
    public Patient(String vorname, String nachname, LocalDate geburtsdatum, boolean registriert, String anamnese, int versichertennr) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.registriert = registriert;
        this.anamnese = anamnese;
        this.versichertennr = versichertennr;


    }
    public String getVorname() {
        return vorname;
    }
    public String getNachname() {
        return nachname;
    }
    public LocalDate getGeburtsdatum () {
        return geburtsdatum;
    }
    public boolean getRegistriert () {
        return true;
    }
    public String getAnamnese () {
        return anamnese;
    }
    public void setAnamnese (String anamnese) {
        this.anamnese = anamnese;
    }
    public void setVersichertennr(int versichertennr) {
        this.versichertennr = versichertennr;
    }

    public int getVersichertennr () {
        return versichertennr;
    }
    //Setter Methoden
    public void setVorname(String vorname) {
            this.vorname = vorname;
    }
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    public void setGeburtsdatum ( LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }
    //to-String Methode um die Patientendaten lesbar zu machen in einen text
    @Override
    public String toString() {
        return "Patient: " + vorname + " " + nachname + ", Geburtsdatum: " + geburtsdatum;
    }
}


