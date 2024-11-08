// File: Main.java
import utility.Tools;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LunaPark lunaPark = new LunaPark(100); // Imposta una capacità massima di 100 persone
        String[] opzioni = {
                "Gestione Luna Park",
                "Entrata Persona",
                "Uscita Persona",
                "Visualizza Giostre Provate",
                "Visualizza Tempo di Permanenza",
                "Esci"
        };

        boolean fine = false;
        while (!fine) {
            switch (Tools.Menu(opzioni, scanner)) {
                case 1 -> {
                    if (lunaPark.entraPersona()) {
                        System.out.println("Persona entrata con successo.");
                    }
                    Tools.Wait(2000);
                }
                case 2 -> {
                    System.out.println("Inserisci il numero del biglietto della persona che esce:");
                    int biglietto = Integer.parseInt(scanner.nextLine());
                    if (lunaPark.esciPersona(biglietto)) {
                        System.out.println("Persona uscita e dati cancellati.");
                    } else {
                        System.out.println("Persona non trovata.");
                    }
                    Tools.Wait(2000);
                }
                case 3 -> {
                    System.out.println("Inserisci il numero del biglietto:");
                    int biglietto = Integer.parseInt(scanner.nextLine());
                    lunaPark.trovaPersona(biglietto).ifPresentOrElse(
                            persona -> {
                                System.out.println("Giostre provate:");
                                persona.getGiostreProvate().forEach(giostra ->
                                        System.out.println(giostra.getNome() + " - Data: " + giostra.getDataOraAccesso())
                                );
                            },
                            () -> System.out.println("Persona non trovata.")
                    );
                    Tools.Wait(2000);
                }
                case 4 -> {
                    System.out.println("Inserisci il numero del biglietto:");
                    int biglietto = Integer.parseInt(scanner.nextLine());
                    lunaPark.trovaPersona(biglietto).ifPresentOrElse(
                            persona -> System.out.println("Tempo di permanenza: " + persona.calcolaTempoDiPermanenza() + " minuti"),
                            () -> System.out.println("Persona non trovata.")
                    );
                    Tools.Wait(2000);
                }
                case 5 -> fine = true;
            }
        }
        scanner.close();
    }
}
