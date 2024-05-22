import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String PASSWORD = "securePassword";

    public static void main(String[] args) {
        String[] operazioni = {
                "VODAFONE",
                "[1] Inserimento",
                "[2] Visualizzazione",
                "[3] Ricerca",
                "[4] Ricerca Numero telefonico",
                "[5] Modifica contatto",
                "[6] Cancellazione",
                "[7] Telefonate",
                "[8] Ricarica",
                "[9] Nascondi contatto",
                "[10] Mostra contatto",
                "[11] Visualizza ultime chiamate",
                "[12] Visualizza contatti nascosti",
                "[13] Torna alla situazione iniziale",
                "[14] Fine"
        };

        boolean Sitel = true;
        final int nMax = 3;
        int contrattiVenduti = 0;
        int posizione;
        Contatto[] gestore = new Contatto[nMax];
        List<String> ultimeChiamate = new ArrayList<>();
        List<Contatto> hiddenContacts = new ArrayList<>();

        Scanner keyboard = new Scanner(System.in);

        boolean fine = true;
        do {
            switch (menu(operazioni, keyboard)) {
                case 1:
                    if (contrattiVenduti < nMax) {
                        gestore[contrattiVenduti] = leggiPersona(Sitel, keyboard);
                        contrattiVenduti++;
                    } else {
                        System.out.println("Non ci sono più contratti da vendere");
                    }
                    break;
                case 2:
                    if (contrattiVenduti != 0) {
                        visualizza(gestore, contrattiVenduti, false, keyboard);
                    } else {
                        System.out.println("Non ci sono contatti");
                    }
                    break;
                case 3:
                    if (contrattiVenduti != 0) {
                        if (ricerca(gestore, leggiPersona(false, keyboard), contrattiVenduti, keyboard)) {
                            System.out.println("Il contatto esiste");
                        } else {
                            System.out.println("Il contatto non esiste");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                case 4:
                    if (contrattiVenduti != 0) {
                        posizione = RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                        if (posizione != -1) {
                            System.out.println(gestore[posizione].cognome + " " + gestore[posizione].nome + ": " + gestore[posizione].telefono);
                        } else {
                            System.out.println("Contatto inesistente");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                case 5:
                    Contatto numero = new Contatto();
                    int scelta;
                    if (contrattiVenduti != 0) {
                        posizione = RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                        if (posizione != -1) {
                            System.out.println("Vuoi modificare il numero telefonico (si = 1 | no = 0): ");
                            scelta = keyboard.nextInt();
                            keyboard.nextLine();
                            if (scelta == 1) {
                                System.out.println("Modifica numero telefonico: ");
                                numero.telefono = keyboard.nextLine();
                                gestore[posizione].telefono = numero.telefono;
                            } else {
                                System.out.println("Numero telefonico non modificato");
                            }
                        } else {
                            System.out.println("Contatto inesistente");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                case 6:
                    if (contrattiVenduti != 0) {
                        posizione = RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                        if (posizione != -1) {
                            contrattiVenduti = cancellazione(gestore, posizione, contrattiVenduti);
                        } else {
                            System.out.println("Contatto inesistente");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                case 7:
                    if (contrattiVenduti != 0) {
                        posizione = RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                        if (posizione != -1) {
                            System.out.println("Inserisci la durata della chiamata (in minuti): ");
                            double durataChiamata = keyboard.nextInt();
                            keyboard.nextLine();
                            gestore[posizione].decrementaSaldo(durataChiamata);
                            ultimeChiamate.add(gestore[posizione].nome + " " + gestore[posizione].cognome + ": " + durataChiamata + " minuti");
                        } else {
                            System.out.println("Contatto inesistente");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                case 8:
                    if (contrattiVenduti != 0) {
                        posizione = RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                        if (posizione != -1) {
                            System.out.println("Inserisci l'importo della ricarica: ");
                            double importoRicarica = keyboard.nextDouble();
                            keyboard.nextLine();
                            gestore[posizione].incrementaSaldo(importoRicarica);
                        } else {
                            System.out.println("Contatto inesistente");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                case 9:
                    if (contrattiVenduti != 0) {
                        posizione = RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                        if (posizione != -1) {
                            gestore[posizione].isHidden = true;
                            hiddenContacts.add(gestore[posizione]);
                            System.out.println("Contatto nascosto");
                        } else {
                            System.out.println("Contatto inesistente");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                case 10:
                    if (contrattiVenduti != 0) {
                        posizione = RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                        if (posizione != -1) {
                            gestore[posizione].isHidden = false;
                            hiddenContacts.remove(gestore[posizione]);
                            System.out.println("Contatto reso visibile");
                        } else {
                            System.out.println("Contatto inesistente");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                case 11:
                    visualizzaUltimeChiamate(ultimeChiamate);
                    break;
                case 12:
                    visualizza(gestore, contrattiVenduti, true, keyboard);
                    break;
                case 13:
                    ripristinaSituazioneIniziale(gestore, hiddenContacts);
                    break;
                default:
                    fine = false;
                    break;
            }
        } while (fine);
    }

    private static Contatto leggiPersona(boolean Sitel, Scanner keyboard) {
        String[] tipoC = {"Telefono", "1]abitazione", "2]cellulare", "3]aziendale"};
        Contatto persona = new Contatto();
        keyboard.nextLine(); // Consuma il newline lasciato da nextInt
        System.out.println("\nInserisci il nome: ");
        persona.nome = keyboard.nextLine();
        System.out.println("\nInserisci il cognome: ");
        persona.cognome = keyboard.nextLine();

        if (Sitel) {
            System.out.println("\nInserisci il numero di telefono: ");
            persona.telefono = keyboard.nextLine();
            switch (menu(tipoC, keyboard)) {
                case 1 -> persona.tipo = tipoContratto.abitazione;
                case 2 -> persona.tipo = tipoContratto.cellulare;
                default -> persona.tipo = tipoContratto.aziendale;
            }
        }

        return persona;
    }

    private static boolean ricerca(Contatto[] gestore, Contatto contatto, int contrattiVenduti, Scanner keyboard) {
        System.out.println("Vuoi includere anche i contatti nascosti nella ricerca? (si = 1 | no = 0): ");
        int includeNascosti = keyboard.nextInt();
        keyboard.nextLine();

        if (includeNascosti == 1) {
            System.out.println("Inserisci la password: ");
            String password = keyboard.nextLine();
            if (!PASSWORD.equals(password)) {
                System.out.println("Password errata. La ricerca verrà effettuata solo sui contatti visibili.");
                includeNascosti = 0;
            }
        }

        for (int i = 0; i < contrattiVenduti; i++) {
            if (contatto.nome.equals(gestore[i].nome) && contatto.cognome.equals(gestore[i].cognome)) {
                if (!gestore[i].isHidden || includeNascosti == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int RicercaIndex(Contatto[] gestore, Contatto ricerca, int contrattiVenduti) {
        int indice = -1;
        for (int i = 0; i < contrattiVenduti; i++) {
            if (ricerca.nome.equals(gestore[i].nome) && ricerca.cognome.equals(gestore[i].cognome)) {
                indice = i;
                break;
            }
        }
        return indice;
    }

    private static void visualizza(Contatto[] gestore, int contrattiVenduti, boolean showHidden, Scanner keyboard) {
        if (showHidden) {
            System.out.println("Inserisci la password per visualizzare i contatti nascosti: ");
            String password = keyboard.nextLine();
            if (!PASSWORD.equals(password)) {
                System.out.println("Password errata.");
                return;
            }
        }

        for (int i = 0; i < contrattiVenduti; i++) {
            if (!gestore[i].isHidden || showHidden) {
                System.out.println(gestore[i].stampa());
            }
        }
    }

    private static void visualizzaUltimeChiamate(List<String> ultimeChiamate) {
        if (ultimeChiamate.isEmpty()) {
            System.out.println("Non ci sono chiamate recenti.");
        } else {
            for (String chiamata : ultimeChiamate) {
                System.out.println(chiamata);
            }
        }
    }

    private static void ripristinaSituazioneIniziale(Contatto[] gestore, List<Contatto> hiddenContacts) {
        for (Contatto contatto : hiddenContacts) {
            contatto.isHidden = false;
        }
        hiddenContacts.clear();
        System.out.println("Situazione iniziale ripristinata. Tutti i contatti sono visibili.");
    }

    private static int cancellazione(Contatto[] gestore, int posizione, int contrattiVenduti) {
        if (posizione != gestore.length - 1) {
            System.arraycopy(gestore, posizione + 1, gestore, posizione, contrattiVenduti - posizione - 1);
        }
        gestore[contrattiVenduti - 1] = null;
        return --contrattiVenduti;
    }

    private static int menu(String[] operazioni, Scanner keyboard) {
        for (String operazione : operazioni) {
            System.out.println(operazione);
        }
        return keyboard.nextInt();
    }
}