import java.util.Scanner;

public class giatti_esMaiuscole_3E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Chiedi all'utente quanti elementi vuole inserire nel vettore
        System.out.print("Inserisci la lunghezza del vettore: ");
        int lunghezza = scanner.nextInt();

        // Crea un vettore di stringhe della lunghezza specificata
        String[] vettore = new String[lunghezza];

        // Inserisci le stringhe nel vettore
        System.out.println("Inserisci le stringhe nel vettore:");
        for (int i = 0; i < lunghezza; i++) {
            System.out.print("Elemento " + (i+1) + ": ");
            vettore[i] = scanner.next();
        }

        // Stampare le stringhe che iniziano con una lettera maiuscola
        System.out.println("Stringhe nel vettore che iniziano con una lettera maiuscola:");
        for (String str : vettore) {
            if (Character.isUpperCase(str.charAt(0))) {
                System.out.println(str);
            }
        }

        scanner.close();
    }
}
