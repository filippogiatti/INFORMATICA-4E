import utility.Tools; // Import della classe Tools
import java.util.Random;
import java.util.Scanner;

public class numeriRandom {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random casuale = new Random();
        boolean fine = true;
        final int NMAX = 10;
        final int RANGERANDOM = 20;
        int numeri[] = null;
        int numeroRicercato = 0;
        String[] opzioni = {
                "Menu Principale",
                "Genera Numeri Random",
                "Visualizza Array",
                "Ricerca di un Numero",
                "Raddoppia Vettore",
                "Inserisci Numero",
                "Cancellazione (sostituisci con zero)",
                "Cancellazione (ricompattare)",
                "Ordinare Array (metodo selezione)",
                "Fine"
        };

        do {
            switch (Tools.Menu(opzioni, keyboard)) { // Usa il metodo Menu dalla classe Tools
                case 1:
                    numeri = generaNumeriUnici(RANGERANDOM, NMAX);
                    System.out.println("Numeri generati casualmente.");
                    break;
                case 2:
                    visualizza(numeri);
                    break;
                case 3:
                    System.out.println("Inserisci il numero da cercare:");
                    numeroRicercato = keyboard.nextInt();
                    int posizione = ricercaNumero(numeri, NMAX, numeroRicercato);
                    if (posizione == -1) {
                        System.out.println("Il numero non è presente nell'array.");
                    } else {
                        System.out.println("Numero trovato alla posizione " + (posizione + 1));
                    }
                    break;
                case 4:
                    numeri = raddoppiaVettore(numeri, NMAX);
                    System.out.println("Vettore raddoppiato.");
                    break;
                case 5:
                    while (findZero(numeri) >= 0) {
                        numeroRicercato = casuale.nextInt(0, 200) + 1;
                        if (aggiungiElemento(numeri, numeroRicercato) >= 0) {
                            System.out.println("Inserimento riuscito.");
                        } else {
                            System.out.println("Inserimento fallito.");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Inserisci il numero da cancellare (sarà sostituito con zero):");
                    numeroRicercato = keyboard.nextInt();
                    cancellaConZero(numeri, numeroRicercato);
                    visualizza(numeri);
                    break;
                case 7:
                    System.out.println("Inserisci il numero da cancellare (gli elementi verranno ricompattati):");
                    numeroRicercato = keyboard.nextInt();
                    cancellaRicompattando(numeri, numeroRicercato);
                    visualizza(numeri);
                    break;
                case 8:
                    ordinaSelezione(numeri);
                    System.out.println("Array ordinato:");
                    visualizza(numeri);
                    break;
                default:
                    fine = false;
                    break;
            }
        } while (fine);
    }

    // Metodo per generare numeri casuali unici
    private static int[] generaNumeriUnici(int RangeRandom, int NMAX) {
        int[] numeri = new int[NMAX];
        Random casuale = new Random();

        for (int i = 0; i < NMAX; i++) {
            int nuovoNumero;
            boolean trovato;

            do {
                trovato = false;
                nuovoNumero = casuale.nextInt(RangeRandom) + 1;
                for (int j = 0; j < i; j++) {
                    if (nuovoNumero == numeri[j]) {
                        trovato = true;
                        break;
                    }
                }
            } while (trovato);

            numeri[i] = nuovoNumero;
        }

        return numeri;
    }

    // Metodo per raddoppiare il vettore
    private static int[] raddoppiaVettore(int[] numeri, int NMAX) {
        int newDim = 2 * NMAX;
        int[] nuovoVettore = new int[newDim];
        for (int i = 0; i < numeri.length; i++) {
            nuovoVettore[i] = numeri[i];
        }
        return nuovoVettore;
    }

    // Metodo che inserisce un numero nella posizione mancante
    private static int aggiungiElemento(int[] numeri, int elementoInserito) {
        int inserito = -1;
        if (findZero(numeri) != -1 && ricercaNumero(numeri, numeri.length, elementoInserito) == -1) {
            numeri[findZero(numeri)] = elementoInserito;
            inserito = 0;
        }
        return inserito;
    }

    // Metodo per trovare uno zero nel vettore
    private static int findZero(int[] numeri) {
        return ricercaNumero(numeri, numeri.length, 0);
    }

    // Metodo di ricerca del numero
    private static int ricercaNumero(int[] numeri, int NMAX, int numeroRicercato) {
        for (int i = 0; i < NMAX; i++) {
            if (numeri[i] == numeroRicercato) {
                return i;
            }
        }
        return -1;
    }

    // Metodo per cancellare un numero sostituendolo con zero
    private static void cancellaConZero(int[] numeri, int numero) {
        int posizione = ricercaNumero(numeri, numeri.length, numero);
        if (posizione != -1) {
            numeri[posizione] = 0;
            System.out.println("Numero " + numero + " sostituito con zero.");
        } else {
            System.out.println("Numero non trovato.");
        }
    }

    // Metodo per cancellare un numero e ricompattare gli elementi
    private static void cancellaRicompattando(int[] numeri, int numero) {
        int posizione = ricercaNumero(numeri, numeri.length, numero);
        if (posizione != -1) {
            for (int i = posizione; i < numeri.length - 1; i++) {
                numeri[i] = numeri[i + 1];
            }
            numeri[numeri.length - 1] = 0;
            System.out.println("Numero " + numero + " cancellato e array ricompattato.");
        } else {
            System.out.println("Numero non trovato.");
        }
    }

    // Metodo per ordinare l'array con il Selection Sort
    private static void ordinaSelezione(int[] numeri) {
        for (int i = 0; i < numeri.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numeri.length; j++) {
                if (numeri[j] < numeri[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = numeri[i];
            numeri[i] = numeri[minIndex];
            numeri[minIndex] = temp;
        }
    }

    // Metodo per visualizzare l'array
    private static void visualizza(int[] numeri) {
        int numRiga = 5;
        int contatore = 0;

        for (int numero : numeri) {
            System.out.print(numero + "\t");
            contatore++;

            if (contatore == numRiga) {
                contatore = 0;
                System.out.println();
            }
        }
        System.out.println();
    }
}
