import java.util.Scanner;
public class Vinaio {
    public static void main(String[] args)
    {
        System.out.println("Benvenuto nel nostro negozio!");
        double numeroBottiglioniB=0, numeroBottiglioniL=0, numeroBottiglioniM=0;
        double barbera=1.5, lugana=2, merlot=1;
        double iva=0.21;
        double totaleB=0, totIva, prezzoB=0, prezzoL=0, prezzoM=0, totaleL=0, totaleM=0, finale=0;
        double contB=0, contL=0, contM=0;

        Scanner tastiera=new Scanner(System.in);

        String menu = String.format("\n1)barbera=%.2f euro/litro\n", barbera) +
                String.format("2)lugana=%.2f euro/litro\n", lugana) +
                String.format("3)merlot=%.2f euro/litro", merlot);

        System.out.println("Questi sono i vini disponibili:" + menu);

        String scelta="";

        do {
            System.out.println("Che vino desidera?");
            scelta = tastiera.nextLine();
            if (scelta.equals("1")) {
                System.out.println("Quanti bottiglioni di barbera vuoi comprare??");
                numeroBottiglioniB = tastiera.nextDouble();
                prezzoB = barbera * numeroBottiglioniB;
                totIva = (prezzoB * iva) + prezzoB;
                totaleB = prezzoB + totIva;
                contB+=numeroBottiglioniB;
            }

            if (scelta.equals("2")) {
                System.out.println("Quanti bottiglioni di lugana vuoi comprare?");
                numeroBottiglioniL = tastiera.nextDouble();
                prezzoL = lugana * numeroBottiglioniL;
                totIva = (prezzoL * iva) + prezzoL;
                totaleL = prezzoL + totIva;
                contL+=numeroBottiglioniL;
            }
            if (scelta.equals("31" +
                    "" )) {
                System.out.println("Quanti bottiglioni di merlot vuoi comprare?");
                numeroBottiglioniM = tastiera.nextDouble();
                prezzoM = merlot * numeroBottiglioniM;
                totIva = (prezzoM * iva) + prezzoM;
                totaleM = prezzoM + totIva;
                contM+=numeroBottiglioniM;
            }

            System.out.println("Desidera altro?");
            scelta = tastiera.nextLine();
            scelta = tastiera.nextLine();


        }while(scelta.equals("S") || scelta.equals("s"));


        System.out.println("\nHai comprato " + contB + " bottiglie di barbera");
        System.out.println("\nHai comprato " +contL+ " bottiglie di lugana");
        System.out.println("\nHai comprato " +contM+ " bottiglie di merlot");
        finale=totaleB+totaleM+totaleL;
        System.out.println("Devi pagare " +finale+ " €");



    }
}
