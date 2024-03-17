import java.util.Scanner;

public class ValidaData {
    public static void main(String[] args) {
        int numero = 0;
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;
        char scelta;
        Boolean dataValida;

        // Ciclo per continuare fino a quando l'utente desidera uscire
        do {
            dataValida = false;
            System.out.println("Inserisci un numero intero nel formato ggmmaaaa per determinare la data: ");
            try {
                numero = scanner.nextInt();
                int[] dataSeparata = separazioneData(numero);
                if (!dataOk(dataSeparata[0], dataSeparata[1], dataSeparata[2])) {
                    dataValida = true;
                    System.out.println("DATA ERRATA");
                } else {
                    System.out.println("DATA CORRETTA");
                    // Menu per aggiungere o togliere giorni
                    System.out.println("Vuoi aggiungere o togliere giorni? (A/T)");
                    scelta = scanner.next().charAt(0);
                    switch (scelta) {
                        case 'A':
                        case 'a':
                            System.out.println("Quanti giorni vuoi aggiungere?");
                            int giorniAggiunti = scanner.nextInt();
                            int[] newDataUp = data_up(dataSeparata, giorniAggiunti);
                            System.out.println("La nuova data è: " + dataToString1(newDataUp));
                            break;
                        case 'T':
                        case 't':
                            System.out.println("Quanti giorni vuoi togliere?");
                            int giorniTolti = scanner.nextInt();
                            int[] newDataDown = data_down(dataSeparata, giorniTolti);
                            System.out.println("La nuova data è: " + dataToString1(newDataDown));
                            break;
                        default:
                            System.out.println("Scelta non valida.");
                    }
                }
            } catch (Exception x) {
                System.out.println("DATA ERRATA");
                dataValida = true;
                scanner.nextLine();
            }
            // Chiedi all'utente se desidera continuare
            System.out.println("Vuoi inserire un'altra data? (S/N)");
            scelta = scanner.next().charAt(0);
            if (scelta == 'N' || scelta == 'n')
                continua = false;
        } while (continua);
    }

    // Restituisce una nuova data aumentando il numero di giorni specificato
    private static int[] data_up(int[] data, int giorni) {
        // Utilizza il metodo addDays di java.time.LocalDate
        java.time.LocalDate newDate = java.time.LocalDate.of(data[2], data[1], data[0]).plusDays(giorni);
        return new int[]{newDate.getDayOfMonth(), newDate.getMonthValue(), newDate.getYear()};
    }

    // Restituisce una nuova data diminuendo il numero di giorni specificato
    private static int[] data_down(int[] data, int giorni) {
        // Utilizza il metodo minusDays di java.time.LocalDate
        java.time.LocalDate newDate = java.time.LocalDate.of(data[2], data[1], data[0]).minusDays(giorni);
        return new int[]{newDate.getDayOfMonth(), newDate.getMonthValue(), newDate.getYear()};
    }

    // Metodi di conversione della data in stringa
    private static String dataToString1(int[] data) {
        return String.format("%02d/%02d/%04d", data[0], data[1], data[2]);
    }

    private static int[] separazioneData(int data) {
        int[] output = new int[3];
        output[2] = data % 10000;
        data /= 10000;
        output[1] = data % 100;
        data /= 100;
        output[0] = data;
        return output;
    }

    private static boolean Bisestile(int anno) {
        return ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0);
    }

    private static boolean dataOk(int giorno, int mese, int anno) {
        boolean valida = false;
        valida = switch (mese) {
            case 1, 3, 5, 7, 8, 10, 12 -> (giorno > 0 && giorno < 32);
            case 4, 6, 9, 11 -> (giorno > 0 && giorno < 31);
            case 2-> (Bisestile(anno) && giorno > 0 && giorno < 30) || (giorno > 0 && giorno < 29);
            default -> false;
        };
        return valida;
    }
}
