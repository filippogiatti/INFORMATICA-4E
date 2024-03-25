import java.util.Scanner;

public class giatti_fiammiferi_3E {

    public static void main(String[] Args){
        Scanner scanner=new Scanner(System.in);
        int giocatore1=0, giocatore2=0, fiammiferi=21;
        String errore="Errore!!! Il numero supera 3\n";

        System.out.println("-------------------------------------\n");
        System.out.println("Benvenuti al gioco dei fiammiferi!\n");
        System.out.println("-------------------------------------\n");

        System.out.println("Inizia il giocatore 1\n");
        Wait();
        ClrScr();
        System.out.println("* * * * * * * * * * * * * * * * * * * * *\n");
        System.out.println("| | | | | | | | | | | | | | | | | | | | |\n");
        System.out.println("\n");

        while(fiammiferi>0){
            System.out.println("Giocatore 1 inserisci il numero di fiammiferi che vuoi togliere:\n");
            giocatore1=scanner.nextInt();
            try {
                if (giocatore1 > 3)
                    System.out.println(errore);
            } catch (Exception x) {
                giocatore1 = 3;
                continue;
            }

            fiammiferi = fiammiferi - giocatore1;
            if(fiammiferi<=0) {
                System.out.println("Ha vinto il giocatore 1");
                break;
            }

            Wait();
            ClrScr();

            System.out.println("Giocatore 2 inserisci il numero di fiammiferi che vuoi togliere:\n");

            try {
                giocatore2 = scanner.nextInt();
                if (giocatore2 > 3) {
                    System.out.println(errore);
                }
            } catch (Exception x) {
                giocatore2 = 3;
                continue;
            }

            fiammiferi = fiammiferi - giocatore2;
            if(fiammiferi<=0) {
                System.out.println("Ha vinto il giocatore 2");
                break;
            }
        }

    }
    public static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Wait() {
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
