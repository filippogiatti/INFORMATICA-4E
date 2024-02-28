import java.util.Scanner;

public class giatti_gestioneData_3E {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String dataString;

        do {
            System.out.println("Inserisci la data (formato: ggmmaaaa): ");
            dataString = keyboard.nextLine();
        } while (dataString.length() != 8);

        int dataInt = Integer.parseInt(dataString);
        stampa(dataString);
    }

    private static void stampa(String dataString) {
        if (dataString.length() >= 8) {
            String giorno = dataString.substring(0, 2);
            String mese = dataString.substring(2, 4);
            String anno = dataString.substring(4, 8);
            System.out.println("Giorno: " + giorno);
            System.out.println("Mese: " + mese);
            System.out.println("Anno: " + anno);
        } else {
            System.out.println("Formato data non valido: la stringa deve avere almeno 8 caratteri");
        }
    }

}
