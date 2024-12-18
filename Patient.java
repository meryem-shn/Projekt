public class Patient {
    public String vorname;
    public String nachname;
    public String geburtsdatum;
    public boolean registriert;
    public String krankengeschichte;

    public Patient(String vorname, String nachname, String geburtsdatum, boolean registriert, String krankengeschichte) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.registriert = registriert;
        this.krankengeschichte = krankengeschichte;
    }
}
