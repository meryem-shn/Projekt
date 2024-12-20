import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;

public class Patientenverwaltung {
    private List<Patient> patientenListe;

    public Patientenverwaltung(List<Patient> patientenListe) {
        this.patientenListe = patientenListe;
    }

    public void patientHinzufuegen(Patient patient) {
        patientenListe.add(patient);
    }

    // Patient suchen
    public Patient suchePatient(String vorname, String nachname, LocalDate geburtsdatum) {
        for (Patient patient : patientenListe) {
            if (patient.getVorname().equalsIgnoreCase(vorname) &&
                    patient.getNachname().equalsIgnoreCase(nachname) &&
                    patient.getGeburtsdatum().equals(geburtsdatum)) {

                System.out.println("Patient gefunden!");
                System.out.println("Vorname: " + patient.getVorname());
                System.out.println("Nachname: " + patient.getNachname());
                System.out.println("Geburtsdatum: " + patient.getGeburtsdatum());
                System.out.println("Anamnese: " + patient.getAnamnese());
                System.out.println("Versichertennummer: " + patient.getVerischertennr());
            }
            return patient; // Patient gefunden
        }
        System.out.println("Es wurde kein Patient mit den angegeben Daten gefunden");
        return null;// Patient nicht gefunden

    }

    public static void main(String[] args) {
         Patientenverwaltung verwaltung = new Patientenverwaltung();
         // Beispiel-Patienten hinzufügen
        verwaltung.patientenListe.add(new Patient("Meryem", "Sahin", LocalDate.of(1999, 7, 15),true,"Diagnostizierte Lunatumnekrose",108310400));
        verwaltung.patientenListe.add(new Patient("Georgina", "Diem",LocalDate.of(2002,10,13),true,"Bänderriss am linken Wadenbereich",108310600));
        verwaltung.patientenListe.add(new Patient("Lien","Awaza", LocalDate.of(2007,1,20),true,"Magenschleimhautentzündung"));
                

    }


}