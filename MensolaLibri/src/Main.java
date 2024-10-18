import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import mensola.Libro;
import mensola.Genere;

public class Main {
    private static final int MAX_LIBRI = 20;
    private static Libro[] mensola = new Libro[MAX_LIBRI];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroLibriInseriti = 0;
        boolean continuaInserimento = true;

        // Ciclo per inserire i libri fino a quando l'utente decide di fermarsi
        while (continuaInserimento && numeroLibriInseriti < MAX_LIBRI) {
            Libro nuovoLibro = new Libro();

            // Inserimento del titolo
            System.out.println("Inserisci il titolo del libro: ");
            nuovoLibro.setTitolo(scanner.nextLine());

            // Inserimento dell'autore
            System.out.println("Inserisci l'autore del libro: ");
            nuovoLibro.setAutore(scanner.nextLine());

            // Controllo duplicati
            if (esisteLibro(nuovoLibro)) {
                System.out.println("Errore: esiste già un libro con lo stesso titolo e autore.");
                continue;
            }

            // Inserimento del numero di pagine con gestione delle eccezioni
            boolean pagineValide = false;
            while (!pagineValide) {
                try {
                    System.out.println("Inserisci il numero di pagine: ");
                    nuovoLibro.numeroPagine = scanner.nextInt();
                    scanner.nextLine(); // Consuma newline
                    if (nuovoLibro.numeroPagine <= 0) {
                        throw new IllegalArgumentException("Il numero di pagine deve essere maggiore di zero.");
                    }
                    pagineValide = true;
                } catch (InputMismatchException e) {
                    System.out.println("Errore: devi inserire un numero intero.");
                    scanner.nextLine(); // Consuma l'input errato
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            // Inserimento del genere
            boolean genereValido = false;
            while (!genereValido) {
                System.out.println("Scegli il genere del libro: (ROMANZO, MANUALE, THRILLER)");
                try {
                    String genereInput = scanner.nextLine().toUpperCase();
                    nuovoLibro.tipologia = Genere.valueOf(genereInput); // Converte l'input a enum
                    genereValido = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Genere non valido. Riprova.");
                }
            }

            // Inserimento della data di pubblicazione con gestione delle eccezioni
            boolean dataValida = false;
            while (!dataValida) {
                System.out.println("Inserisci la data di pubblicazione (dd/MM/yyyy): ");
                String dataInput = scanner.nextLine();
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    nuovoLibro.dataPubblicazione = LocalDate.parse(dataInput, formatter); // Converte la stringa in LocalDate
                    dataValida = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Formato data non valido. Riprova.");
                }
            }

            // Inserisci il libro nella mensola
            mensola[numeroLibriInseriti] = nuovoLibro;
            numeroLibriInseriti++;

            // Chiedere all'utente se vuole continuare ad inserire libri
            if (numeroLibriInseriti < MAX_LIBRI) {
                System.out.println("Vuoi inserire un altro libro? (si/no)");
                String risposta = scanner.nextLine().toLowerCase();
                if (!risposta.equals("si")) {
                    continuaInserimento = false;
                }
            } else {
                System.out.println("Hai raggiunto il numero massimo di libri consentito.");
            }
        }

        // Visualizzare i libri inseriti
        visualizzaLibri(scanner);
    }

    // Metodo per modificare il numero di pagine di un libro cercandolo per titolo
    private static void modificaPagine(Scanner scanner) {
        System.out.println("Inserisci il titolo del libro di cui vuoi modificare il numero di pagine: ");
        String titolo = scanner.nextLine();
        Libro libro = cercaLibroPerTitolo(titolo);

        if (libro != null) {
            try {
                System.out.println("Inserisci il nuovo numero di pagine: ");
                int nuovePagine = scanner.nextInt();
                scanner.nextLine(); // Consuma newline
                if (nuovePagine <= 0) {
                    throw new IllegalArgumentException("Il numero di pagine deve essere maggiore di zero.");
                }
                libro.numeroPagine = nuovePagine;
                System.out.println("Numero di pagine modificato correttamente.");
            } catch (InputMismatchException e) {
                System.out.println("Errore: devi inserire un numero intero.");
                scanner.nextLine(); // Consuma l'input errato
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Libro non trovato.");
        }
    }

    // Metodo per cancellare un libro cercandolo per titolo
    private static void cancellaLibro(Scanner scanner) {
        System.out.println("Inserisci il titolo del libro da cancellare: ");
        String titolo = scanner.nextLine();
        for (int i = 0; i < mensola.length; i++) {
            if (mensola[i] != null && mensola[i].getTitolo().equalsIgnoreCase(titolo)) {
                mensola[i] = null; // Cancella il libro
                System.out.println("Libro cancellato correttamente.");
                return;
            }
        }
        System.out.println("Libro non trovato.");
    }

    // Metodo per visualizzare i libri di un autore
    private static void visualizzaLibriAutore(Scanner scanner) {
        System.out.println("Inserisci il nome dell'autore: ");
        String autore = scanner.nextLine();
        boolean trovato = false;
        System.out.println("Libri dell'autore " + autore + ":");
        for (Libro libro : mensola) {
            if (libro != null && libro.getAutore().equalsIgnoreCase(autore)) {
                System.out.println(libro);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("Nessun libro trovato per questo autore.");
        }
    }

    // Metodo per cercare un libro per titolo
    private static Libro cercaLibroPerTitolo(String titolo) {
        for (Libro libro : mensola) {
            if (libro != null && libro.getTitolo().equalsIgnoreCase(titolo)) {
                return libro;
            }
        }
        return null;
    }

    // Metodo per controllare se un libro già esiste (stesso titolo e autore)
    private static boolean esisteLibro(Libro libro) {
        for (Libro l : mensola) {
            if (l != null && l.getTitolo().equalsIgnoreCase(libro.getTitolo()) && l.getAutore().equalsIgnoreCase(libro.getAutore())) {
                return true;
            }
        }
        return false;
    }

    // Metodo per visualizzare la lista dei libri
    private static void visualizzaLibri(Scanner scanner) {
        boolean continua = true;
        while (continua) {
            try {
                System.out.println("\nCosa vuoi fare?");
                System.out.println("1. Visualizzare tutti i libri");
                System.out.println("2. Modificare il numero di pagine di un libro");
                System.out.println("3. Cancellare un libro");
                System.out.println("4. Visualizzare i libri di un autore");
                System.out.println("5. Esci");
                System.out.print("Scelta: ");

                int scelta = scanner.nextInt();  // Possibile lancio di InputMismatchException
                scanner.nextLine(); // Consuma newline

                switch (scelta) {
                    case 1:
                        System.out.println("\nLibri nella mensola:");
                        for (Libro libro : mensola) {
                            if (libro != null) {
                                System.out.println(libro);
                            }
                        }
                        break;
                    case 2:
                        modificaPagine(scanner);
                        break;
                    case 3:
                        cancellaLibro(scanner);
                        break;
                    case 4:
                        visualizzaLibriAutore(scanner);
                        break;
                    case 5:
                        continua = false;
                        break;
                    default:
                        System.out.println("Scelta non valida. Inserisci un numero tra 1 e 5.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Errore: input non valido. Inserisci un numero tra 1 e 5.");
                scanner.nextLine(); // Consuma l'input errato
            }
        }
    }

}
