import java.util.Scanner;

public class DivisioneStringa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Chiediamo all'utente di inserire la stringa da dividere
        System.out.println("Inserisci una stringa da dividere (massimo 80 caratteri):");
        String inputString = scanner.nextLine();

        // Dividiamo la stringa in parole
        String[] parole = inputString.split("\\s+");

        // Variabile per tenere traccia della lunghezza corrente della riga
        int lunghezzaRiga = 0;

        // Variabile per tenere traccia della stringa corrente
        String rigaCorrente = "";

        // Ciclo attraverso le parole
        for (String parola : parole) {
            // Verifica se aggiungere questa parola alla riga corrente supererebbe il limite di 40 caratteri
            if (lunghezzaRiga + parola.length() > 40) {
                // Stampa la riga corrente
                System.out.println(rigaCorrente);

                // Resetta la riga corrente e la lunghezza della riga
                rigaCorrente = "";
                lunghezzaRiga = 0;
            }

            // Aggiunge la parola alla riga corrente
            rigaCorrente += parola + " ";
            lunghezzaRiga += parola.length() + 1; // Aggiunge uno per lo spazio tra le parole
        }

        // Stampa l'ultima riga
        System.out.println(rigaCorrente);

        // Chiudiamo lo scanner
        scanner.close();
    }
}
