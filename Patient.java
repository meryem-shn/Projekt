import java.time.LocalDate;

public class Patient {
    //Attribute
    public String vorname;
    public String nachname;
    public LocalDate geburtsdatum;
    public boolean registriert;
    public String anamnese;
    public int verischertennr;

    //Konstruktor
    public Patient(String vorname, String nachname, LocalDate geburtsdatum, boolean registriert, String anamnese, int versichertennr) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.registriert = registriert;
        this.anamnese = anamnese;
        this.verischertennr = versichertennr;


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
    public void setAnamnese () {
        this.anamnese;
    }
    public void setVersichertennummer(int versichertennr) {
        this.verischertennr () = versichertennr;
    }
    public int getVerischertennr () {
        return verischertennr;
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


