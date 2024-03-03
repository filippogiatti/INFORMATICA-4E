import java.util.Scanner;

public class giatti_gestioneData_3E {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String dataString;

        do {
            System.out.println("Inserisci la data (formato: ggmmaaaa): ");
            dataString = keyboard.nextLine();
        } while (!isValidDate(dataString));

        stampa(dataString);
    }

    private static void stampa(String dataString) {
        if (dataString.length() >= 8) {
            String giorno = dataString.substring(0, 2);
            String mese = getNomeMese(dataString.substring(2, 4));
            String anno = dataString.substring(4, 8);
            System.out.println("Giorno: " + giorno);
            System.out.println("Mese: " + mese);
            System.out.println("Anno: " + anno);
        } else {
            System.out.println("Formato data non valido: la stringa deve avere almeno 8 caratteri");
        }
    }

    private static String getNomeMese(String meseNumero) {
        switch (meseNumero) {
            case "01":
                return "Gennaio";
            case "02":
                return "Febbraio";
            case "03":
                return "Marzo";
            case "04":
                return "Aprile";
            case "05":
                return "Maggio";
            case "06":
                return "Giugno";
            case "07":
                return "Luglio";
            case "08":
                return "Agosto";
            case "09":
                return "Settembre";
            case "10":
                return "Ottobre";
            case "11":
                return "Novembre";
            case "12":
                return "Dicembre";
            default:
                return "Mese non valido";
        }
    }

    private static boolean isValidDate(String dataString) {
        if (dataString.length() != 8)
            return false;

        int giorno = Integer.parseInt(dataString.substring(0, 2));
        int mese = Integer.parseInt(dataString.substring(2, 4));
        int anno = Integer.parseInt(dataString.substring(4, 8));

        if (mese < 1 || mese > 12)
            return false;

        int[] giorniPerMese = {31, 28 + (anno % 4 == 0 && (anno % 100 != 0 || anno % 400 == 0) ? 1 : 0), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        return giorno >= 1 && giorno <= giorniPerMese[mese - 1];
    }
}
