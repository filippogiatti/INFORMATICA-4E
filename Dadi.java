import java.util.Scanner;
import java.util.Random;

public class Dadi {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random faccia = new Random();

        int valoreG1, valoreG2;
        int punteggioG1=0, punteggioG2=0;

        int valoreFaccia;


        valoreG1=faccia.nextInt(6)+1;
        valoreG2=faccia.nextInt(6)+1;

        System.out.println("Giocatore 1");
        FacceDado(valoreG1);

        System.out.println("\nGiocatore 2");
        FacceDado(valoreG2);

        determinaVincitore(valoreG1, valoreG2);


    }



    private static void FacceDado(int valoreFaccia) {
        //ALT + 201 ╔
        //ALT + 188 ╝
        //ALT + 187 ╗
        //ALT + 200 ╚
        //ALT + 205 ═
        //ALT + 186 ║

        switch (valoreFaccia) {
            case 1 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 2 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 3 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 4 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 5 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 6 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }
        }
    }



    private static void determinaVincitore(int valoreG1, int valoreG2) {
        System.out.println("\nPunteggio finale:");

        if (valoreG1 > valoreG2) {
            System.out.println("Vince Giocatore 1 con " + valoreG1 + " punti!");
        } else if (valoreG1 < valoreG2) {
            System.out.println("Vince Giocatore 2 con " + valoreG2 + " punti!");
        } else {
            System.out.println("La partita è finita in parità!");
        }
    }
}