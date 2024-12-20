public class Patient {
    //Attribute
    public String vorname;
    public String nachname;
    public String geburtsdatum;
    public boolean registriert;
    public String krankengeschichte;
    public int verischertennr;

    //Konstruktor
    public Patient(String vorname, String nachname, String geburtsdatum, boolean registriert, String krankengeschichte, int versichertennr) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.registriert = registriert;
        this.krankengeschichte = krankengeschichte;
        this.verischertennr = versichertennr;


    }
    public String getVorname() {
        return vorname;
    }
    public String getNachname() {

        return nachname;
    }
    public String getGeburtsdatum () {
        return geburtsdatum;
    }
    public boolean getRegistriert () {
        return true;
    }
    public String getKrankengeschichte () {
        return krankengeschichte;
    }
    public int getVerischertennr () {
        return verischertennr;
    }

}
