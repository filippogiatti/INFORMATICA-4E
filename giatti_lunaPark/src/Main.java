import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import utility.Tools;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LunaPark lunaPark = new LunaPark(100); // Capacità massima del parco

        String[] opzioni = {
                "Gestione Luna Park",
                "Entrata persona",
                "Uscita persona",
                "Prova giostra",
                "Visualizza giostre provate",
                "Esci"
        };

        boolean continua = true;
        while (continua) {
            int scelta = Tools.Menu(opzioni, scanner);
            switch (scelta) {
                case 1:
                    lunaPark.entraPersona();
                    break;
                case 2:
                    try {
                        System.out.print("Inserisci il numero del biglietto della persona che esce: ");
                        int bigliettoUscita = Integer.parseInt(scanner.nextLine());
                        lunaPark.esciPersona(bigliettoUscita);
                    } catch (NumberFormatException e) {
                        System.out.println("Errore: Inserisci un numero valido per il biglietto.");
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Inserisci il numero del biglietto della persona: ");
                        int biglietto = Integer.parseInt(scanner.nextLine());

                        System.out.print("Inserisci il nome della giostra (Ruota Panoramica, Autoscontro, Ottovolante, Tagadà): ");
                        String giostra = scanner.nextLine();

                        // Richiede l’orario in un formato valido "HH:mm"
                        String orario;
                        while (true) {
                            System.out.print("Inserisci l'orario in cui è stata provata (formato HH:mm): ");
                            orario = scanner.nextLine();
                            if (isValidTime(orario)) {
                                break;
                            } else {
                                System.out.println("Orario non valido. Riprova.");
                            }
                        }

                        lunaPark.personaProvaGiostra(biglietto, giostra, orario);
                    } catch (NumberFormatException e) {
                        System.out.println("Errore: Inserisci un numero valido per il biglietto.");
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Inserisci il numero del biglietto della persona: ");
                        int bigliettoVisualizza = Integer.parseInt(scanner.nextLine());
                        lunaPark.visualizzaGiostreProvate(bigliettoVisualizza);
                    } catch (NumberFormatException e) {
                        System.out.println("Errore: Inserisci un numero valido per il biglietto.");
                    }
                    break;
                case 5:
                    continua = false;
                    break;
            }
        }

        scanner.close();
    }

    // Metodo per verificare se una stringa rappresenta un orario valido nel formato "HH:mm"
    private static boolean isValidTime(String orario) {
        try {
            LocalTime.parse(orario, DateTimeFormatter.ofPattern("HH:mm"));
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Errore: formato dell'orario non valido. Usa il formato HH:mm.");
            return false;
        }
    }
}
