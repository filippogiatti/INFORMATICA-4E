import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            // Creazione di piloti
            Pilota pilota1 = new Pilota("Lewis", "Hamilton", "UK", 38);
            Pilota pilota2 = new Pilota("Max", "Verstappen", "Netherlands", 26);

            // Prova a creare un pilota duplicato
            Pilota pilotaDuplicato = new Pilota("Lewis", "Hamilton", "UK", 38);

            // Set per verificare unicità dei piloti
            Set<Pilota> piloti = new HashSet<>();
            piloti.add(pilota1);
            piloti.add(pilota2);
            if (!piloti.add(pilotaDuplicato)) {
                System.out.println("Pilota duplicato non aggiunto: " + pilotaDuplicato);
            }

            // Creazione di auto
            Auto auto1 = new Auto("Mercedes", pilota1, 1600.0);
            Auto auto2 = new Auto("Red Bull", pilota2, 1600.0);

            // Stampa
            System.out.println(auto1);
            System.out.println(auto2);

        } catch (IllegalArgumentException e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }
}
