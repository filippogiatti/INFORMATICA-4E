import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crea i parcheggi
        Parcheggio parcheggioCoperto = new Parcheggio("coperto");
        Parcheggio parcheggioScoperto = new Parcheggio("scoperto");

        Auto auto1 = new Auto(100, 15000, false, true);  // VIP
        Auto auto2 = new Auto(80, 12000, false, false);  // Non VIP
        Auto auto3 = new Auto(120, 20000, true, false);  // GPL
        Auto auto4 = new Auto(150, 25000, false, true);  // VIP

        // Prenotazioni
        parcheggioCoperto.prenotaAuto(auto1);
        parcheggioScoperto.prenotaAuto(auto2);
        parcheggioCoperto.prenotaAuto(auto3);
        parcheggioScoperto.prenotaAuto(auto4);
    }
}