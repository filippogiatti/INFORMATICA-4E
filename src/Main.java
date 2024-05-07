
import static tools.utility.menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] operazioni = {"VODAFONE",
                "[1] Inserimento",
                "[2] Visualizzazione",
                "[3] Ricerca",
                "[4] Ricerca Numero telefonico",
                "[5] Modifica contatto",
                "[6] Cancellazione",
                "[7] Telefonate",
                "[8] Ricarica",
                "[9] Fine"};
        boolean Sitel = true;
        final int nMax = 3;
        int contrattiVenduti = 0;
        int posizione;
        Contatto[] gestore = new Contatto[nMax];


        Scanner keyboard = new Scanner(System.in);

        boolean fine = true;
        do {
            switch (menu(operazioni, keyboard)) {
                case 1:

                    if (contrattiVenduti < nMax) {
                        //firma contratto
                        gestore[contrattiVenduti] = leggiPersona(Sitel, keyboard);
                        contrattiVenduti++;
                    } else {
                        System.out.println("Non ci sono più contratti da vendere");
                    }
                    break;
                case 2: {
                    if(contrattiVenduti!=0){
                        visualizza(gestore, contrattiVenduti);
                    }else{
                        System.out.println("Non ci sono più contatti");
                    }
                    break;
                }

                case 3: {
                    if (contrattiVenduti != 0) {
                        //Ci sono contratti venduti
                        //lettura, ricerca, visualizzazione
                        if (ricerca(gestore, leggiPersona(false, keyboard), contrattiVenduti)) {
                            System.out.println("Il contatto esiste");

                        } else {
                            System.out.println("Il contatto non esiste");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                }

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
                        if (posizione != -1)
                        {
                            contrattiVenduti = cancellazione(gestore, posizione, contrattiVenduti);

                        } else
                        {
                            System.out.println("Contatto inesistente");
                        }
                    } else
                    {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                case 7:
                    if (contrattiVenduti != 0) {
                        posizione = RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                        if (posizione != -1) {
                            System.out.println("Inserisci la durata della chiamata (in minuti): ");
                            double durataChiamata = keyboard.nextInt();
                            gestore[posizione].decrementaSaldo(durataChiamata);
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
                            gestore[posizione].incrementaSaldo(importoRicarica);
                        } else {
                            System.out.println("Contatto inesistente");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;

                default:
                    fine = false;
                    break;
            }
        } while (fine);
    }

    private static Contatto leggiPersona(boolean Sitel, Scanner keyboard) {
        //Sitel è true quando dobbiamo leggere
        String[] tipoC = {"Telefono", "1]abitazione", "2]cellulare", "3]aziendale"};
        //Istanziato un oggetto di tipo contatto:
        Contatto persona = new Contatto();
        System.out.println("\nInserisci il nome: ");
        persona.nome = keyboard.nextLine();
        System.out.println("\nInserisci il cognome: ");
        persona.cognome = keyboard.nextLine();

        if (Sitel) {
            System.out.println("\nInserisci il numero di telefono: ");
            persona.telefono = keyboard.nextLine();  //Vado a leggere il numero di telefono
            //I valori assegnati all'attributo sono compresi nel range
            switch (menu(tipoC, keyboard)) {
                case 1 -> persona.tipo = tipoContratto.abitazione;
                case 2 -> persona.tipo = tipoContratto.cellulare;
                default -> persona.tipo = tipoContratto.aziendale;

            }
        }

        return persona;
    }

    private static boolean ricerca(Contatto[] gestore, Contatto contatto, int contrattiVenduti) {
        //Controllo se il nome e il cognome del contatto e ugale al nome e cogome del gestore
        boolean ricerca = false;

        for (int i = 0; i < contrattiVenduti; i++) {
            if (contatto.nome.equals(gestore[i].nome) && contatto.cognome.equals(gestore[i].cognome)) {
                ricerca = true;
            }
        }
        return ricerca;
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

    private static void visualizza(Contatto[] gestore, int contrattiVenduti) {

        for (int i = 0; i < contrattiVenduti; i++) {
            System.out.println(gestore[i].stampa());
        }

    }

    private static int contaContattiAbitazione(Contatto[] gestore, int contrattiVenduti) {
        int contAbitazione = 0;
        for (int i = 0; i < contrattiVenduti; i++) {
            if (gestore[i].tipo == tipoContratto.abitazione) {
                contAbitazione++;
            }


        }
        return contAbitazione;
    }

    public static void ricerca(Contatto[] gestore) {
        System.out.println("Inserisci il nome del contatto");
    }

    public static int cancellazione(Contatto[] gestore, int posizione, int contrattiVenduti) {
        if (posizione != gestore.length - 1) {
            for (int i = 0; i < contrattiVenduti - 1; i++) {
                gestore[i] = gestore[i++];
            }
        }
        return --contrattiVenduti;
    }
}
