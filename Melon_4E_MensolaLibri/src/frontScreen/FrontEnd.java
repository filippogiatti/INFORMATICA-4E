package frontScreen;

import mensola.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FrontEnd {
    public static int Menu(String[] opzioni, Scanner keyboard) {
        for (int i = 0; i < opzioni.length; i++) {
            System.out.println((i + 1) + ". " + opzioni[i]);
        }
        System.out.print("Seleziona un'opzione: ");
        return Integer.parseInt(keyboard.nextLine());
    }

    public static void controllaSeVuoto(ArrayList<Libro> scaffale) throws Exception {
        if (scaffale.isEmpty()) {
            throw new Exception("Scaffale vuoto");
        }
    }

    public static void visualizza(ArrayList<Libro> scaffale) {
        for (Libro libro : scaffale) {
            System.out.println(libro.toString());  // Stampa i dettagli di ogni libro
        }
    }

    public static Libro LeggiLibro(Scanner keyboard, ArrayList<Libro> scaffale) {
        System.out.print("Inserisci il titolo del libro: ");
        String titolo = keyboard.nextLine();
        System.out.print("Inserisci il nome dell'autore: ");
        String autore = keyboard.nextLine();
        System.out.print("Inserisci il numero di pagine: ");
        int numeroPagine = Integer.parseInt(keyboard.nextLine());

        // Esempio di come impostare un genere (devi sostituire con la tua logica)
        Genere tipologia = Genere.ROMANZO; // Sostituisci con il genere desiderato

        // Crea il libro
        Libro nuovoLibro = new Libro();
        nuovoLibro.titolo = titolo;
        nuovoLibro.autore = autore;
        nuovoLibro.numeroPagine = numeroPagine;
        nuovoLibro.tipologia = tipologia; // Imposta il genere
        nuovoLibro.dataPubblicazione = LocalDate.now(); // Imposta una data di pubblicazione di esempio

        return nuovoLibro;
    }
}
