public class CucinaUovo {

    public static void main(String[] args) {
        System.out.println("Inizia la cottura dell'uovo...");
        CucinaUovo();
    }

    public static void CucinaUovo() {
        int tempoCottura = 3; // tempo di cottura in minuti
        int secondi = tempoCottura * 60; // tempo di cottura in secondi
        int count = 1;

        while (secondi > 0) {
            System.out.println("Fase di cottura " + count + ":");
            UovoCheBolle();
            try {
                Thread.sleep(1000); // pausa di 1 secondo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            secondi--;
            count++;
        }
        UovoPronto();
    }

    public static void UovoCheBolle() {
        System.out.println("  _______");
        System.out.println(" /       \\");
        System.out.println("/         \\");
        System.out.println("|   __    |");
        System.out.println("|  |__|   |");
        System.out.println("\\         /");
        System.out.println(" \\_______/");
    }

    public static void UovoPronto() {
        System.out.println("L'uovo è cotto!");
        System.out.println("  _______");
        System.out.println(" /       \\");
        System.out.println("/         \\");
        System.out.println("|   **    |");
        System.out.println("|  |__|   |");
        System.out.println("\\         /");
        System.out.println(" \\_______/");
    }

    }

