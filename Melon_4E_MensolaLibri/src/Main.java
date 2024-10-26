import static frontScreen.FrontEnd.*;
import static utility.Tools.*;

import mensola.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        final int MAX_LIBRI = 2;  // massimo numero di libri consentiti
        final String[] elenco = {
                "Inserisci Libro",
                "Visualizza tutti i libri inseriti",
                "Modifica pagine libro",
                "Cancella libro",
                "Visualizza libri di un autore",
                "Esci"
        };
        ArrayList<Libro> scaffale = new ArrayList<>();
        boolean fine = true;

        do {
            int scelta = frontScreen.FrontEnd.Menu(elenco, keyboard); // specifica la classe

            switch (scelta) {
                case 1:  // Inserisci Libro
                    try {
                        controllaSpazio(scaffale, MAX_LIBRI);
                        Libro momentaneo = LeggiLibro(keyboard, scaffale);
                        if (indexOf(momentaneo, scaffale) != -1) {
                            throw new Exception("Il libro è già presente");
                        } else {
                            scaffale.add(momentaneo);  // Aggiunge il libro nello scaffale
                            System.out.println("Libro aggiunto con successo!");  // Messaggio di conferma
                        }
                        System.out.println("Numero di libri nello scaffale: " + scaffale.size());  // Debug
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:  // Visualizza tutti i libri inseriti
                    try {
                        controllaSeVuoto(scaffale);
                        visualizza(scaffale);  // Visualizza tutti i libri inseriti
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:  // Modifica numero di pagine
                    try {
                        modificaNumPagine(keyboard, scaffale);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:  // Cancella libro
                    try {
                        cancellaLibro(keyboard, scaffale);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:  // Visualizza libri di un autore
                    try {
                        visualizzaPerAutore(scaffale, keyboard);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:  // Esci
                    fine = false;
                    System.out.println("Chiusura programma.");
                    break;

                default:
                    System.out.println("Selezione non valida.");
            }
        } while (fine);

        keyboard.close();
    }

    private static void modificaNumPagine(Scanner keyboard, ArrayList<Libro> scaffale) throws Exception {
        controllaSeVuoto(scaffale);

        System.out.println("Inserire il titolo del libro che si vuole modificare");
        String titoloDaTrovare = keyboard.nextLine();

        int pos = cercaLibro(titoloDaTrovare, scaffale);

        System.out.println("Inserisci il nuovo numero di pagine:\n(vecchio numero: " + scaffale.get(pos).numeroPagine + ")");
        int nPagine = Integer.parseInt(keyboard.nextLine());

        if (nPagine < 0) {
            throw new Exception("Non puoi inserire un numero negativo di pagine");
        } else {
            scaffale.get(pos).numeroPagine = nPagine;
        }
    }

    private static int cercaLibro(String titolo, ArrayList<Libro> scaffale) throws Exception {
        controllaSeVuoto(scaffale);
        for (int i = 0; i < scaffale.size(); i++) {
            if (scaffale.get(i).titolo.equals(titolo))
                return i;
        }
        throw new Exception("Libro non trovato");
    }

    private static int indexOf(Libro book, ArrayList<Libro> scaffale) {
        for (int i = 0; i < scaffale.size(); i++) {
            if (scaffale.get(i).autore.equals(book.autore) && scaffale.get(i).titolo.equals(book.titolo))
                return i;
        }
        return -1;
    }

    private static void controllaSpazio(ArrayList<Libro> scaffale, int maxLibri) throws Exception {
        if (scaffale.size() >= maxLibri) {
            throw new Exception("Scaffale pieno");
        }
    }

    private static void visualizzaPerAutore(ArrayList<Libro> scaffale, Scanner keyboard) throws Exception {
        controllaSeVuoto(scaffale);

        System.out.println("Inserisci il nome dell'autore: ");
        String autore = keyboard.nextLine();
        boolean trovato = false;

        for (Libro libro : scaffale) {
            if (libro.autore.equals(autore)) {
                System.out.println(libro.toString());
                trovato = true;
            }
        }

        if (!trovato) {
            throw new Exception("Non è stato trovato nessun autore con quel nome");
        }
    }

    private static void cancellaLibro(Scanner keyboard, ArrayList<Libro> scaffale) throws Exception {
        controllaSeVuoto(scaffale);

        System.out.println("Inserire il titolo del libro che si vuole cancellare");
        String titoloDaTrovare = keyboard.nextLine();

        int pos = cercaLibro(titoloDaTrovare, scaffale);
        scaffale.remove(pos);  // Rimuove il libro dalla posizione trovata
        System.out.println("Libro rimosso con successo!");
    }
}
