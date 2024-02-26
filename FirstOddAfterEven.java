//esercizio 1 dell'altra fila(b)
import java.util.Scanner;

public class FirstOddAfterEven {
    public static void main(String[] args) {
        //dichiarazione variabili
        int quantita = 0;
        //dichiarazione scanner
        Scanner keyboard = new Scanner(System.in);
        //richiesta input
        System.out.println("Quanti numeri desideri inserire?:");
        //raccolta dati input
        quantita = keyboard.nextInt();
        //dichiarazione vettore
        int[] sequenza = new int[quantita];
        int i=0;
        int j=0;
        //ciclo for per popolare il vettore
        for (i = 0; i < sequenza.length; i++) {
            System.out.println("Inserisci il numero:");
            sequenza[i] = keyboard.nextInt();
        }
        //metodo per trovare la positività e la parità
        contaPariSeguitiDaDispari(sequenza);
    }
    private static int contaPariSeguitiDaDispari(int[] sequenza) {
        int conteggio = 0;
        for (int i = 0; i < sequenza.length - 1; i++) {
            if (sequenza[i] % 2 == 0 && sequenza[i + 1] % 2 == 1) {
                conteggio++;
            }
        }
        System.out.println("Ci sono "+conteggio+ " numeri pari seguiti da uno dispari");

        return conteggio;
    }

}