import java.util.Random;
import java.util.Scanner;

public class EstrazioniLotto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[] giocataUtente = new int[5];
        int[] numeriEstratti = new int[5];
        int scelta;

        do {
            System.out.println("=== Estrazioni Lotto ===");
            System.out.println("[1] Estrazioni ruota di Venezia");
            System.out.println("[2] Giocata utente");
            System.out.println("[3] Verifica vincita");
            System.out.println("[4] Visualizza giocate");
            System.out.println("[5] Fine");

            scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    numeriEstratti = generaNumeriCasuali(random);
                    System.out.println("Estrazione ruota di Venezia completata");
                    break;
                case 2:
                    giocataUtente = inserisciNumeriUtente(scanner);
                    System.out.println("Hai giocato i tuoi valori");
                    break;
                case 3:
                    verificaVincita(giocataUtente, numeriEstratti);
                    break;
                case 4:
                    visualizzaGiocate(scanner, giocataUtente, numeriEstratti);
                    break;
                case 5:
                    System.out.println("Fine del programma");
                    break;
                default:
                    System.out.println("Valore inserito errato. Riprova.");
            }
        } while (scelta != 5);
    }

    private static int[] generaNumeriCasuali(Random random) {
        int[] numeri = new int[5];
        for (int i = 0; i < numeri.length; i++) {
            numeri[i] = random.nextInt(90) + 1;
        }
        return numeri;
    }

    private static int[] inserisciNumeriUtente(Scanner scanner) {
        int[] numeri = new int[5];
        for (int i = 0; i < numeri.length; i++) {
            do {
                System.out.println("Inserisci il " + (i + 1) + "^ valore: ");
                numeri[i] = scanner.nextInt();
            } while (numeri[i] < 1 || numeri[i] > 90 || contieneDuplicati(numeri, i));
        }
        return numeri;
    }

    private static boolean contieneDuplicati(int[] array, int endIndex) {
        for (int i = 0; i < endIndex; i++) {
            if (array[i] == array[endIndex]) {
                return true;
            }
        }
        return false;
    }

    private static void verificaVincita(int[] giocata, int[] estratti) {
        int cont = 0;
        for (int i = 0; i < giocata.length; i++) {
            for (int j = 0; j < estratti.length; j++) {
                if (giocata[i] == estratti[j]) {
                    cont++;
                    break;
                }
            }
        }

        System.out.println("Hai fatto: ");
        switch (cont) {
            case 1:
                System.out.println("Ambata");
                break;
            case 2:
                System.out.println("Ambo");
                break;
            case 3:
                System.out.println("Terna");
                break;
            case 4:
                System.out.println("Quaterna");
                break;
            case 5:
                System.out.println("Cinquina");
                break;
            default:
                System.out.println("///");
        }
    }

    private static void visualizzaGiocate(Scanner scanner, int[] giocata, int[] estratti) {
        System.out.println("[1] Numeri estratti ruota di Venezia");
        System.out.println("[2] Numeri giocati dall'utente");
        System.out.println("[3] Entrambi");

        int scelta = scanner.nextInt();
        switch (scelta) {
            case 1:
                System.out.print("Numeri estratti ruota di Venezia: ");
                stampaArray(estratti);
                break;
            case 2:
                System.out.print("Numeri giocati dall'utente: ");
                stampaArray(giocata);
                break;
            case 3:
                System.out.print("Numeri giocati dall'utente: ");
                stampaArray(giocata);
                System.out.print("\nNumeri estratti ruota di Venezia: ");
                stampaArray(estratti);
                break;
            default:
                System.out.println("Valore inserito errato. Riprova");
        }
    }

    private static void stampaArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}

