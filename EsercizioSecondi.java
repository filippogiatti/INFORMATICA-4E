import java.util.Scanner;
public class EsercizioSecondi{
    public static void main(String[] args){
        int secondi=0, minuti=0, ore=0;

        Scanner tastiera=new Scanner(System.in);

        do {
            System.out.println("Inserisci i secondi trascorsi:  ");
            secondi = tastiera.nextInt();
            if(secondi>86400){
                System.out.println("Hai inserito un valore superiore ad un giorno, reinserisci il valore dei secondi! ");
            }
        }while(secondi>86400);

        if(secondi<60){
            System.out.println("Sono trsascorsi  " +ore+"(ore)  "+ minuti+"(minuti)  " + secondi+" (secondi) ");
        }
        if(secondi>59){
            do {
                minuti = secondi / 60;
            }while(secondi<59);
            secondi=secondi-(60*minuti);

        }
        if(minuti>59){
            do{
                ore=minuti/60;
            }while(minuti<60);
            minuti=minuti-(60*ore);


        }
        System.out.println("Sono trsascorsi  " +ore+"(ore)  "+ minuti+"(minuti)  " + secondi+" (secondi) ");
    }
}