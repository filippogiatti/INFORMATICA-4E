import java.util.Scanner;

public class DueSequenze {
    public static void main(String[] args) {
        //dichiarazione varibaili
        int[] primaSequenza = new int[5];
        int[] secondaSequenza = new int[5];
        boolean numUguale;
        System.out.println("Inserisci i 5 numeri della prima sequenza");
        riempimentoArray(primaSequenza);
        System.out.println("Inserisci i 5 numeri della seconda sequenza");
        riempimentoArray(secondaSequenza);
        numUguale =controlloArray(primaSequenza,secondaSequenza);
        if(numUguale ==true) {
            System.out.println("OK\n");
        }else {
            System.out.println("NO\n");
        }
    }
    private static void riempimentoArray(int[] Array){//metodo di riempimento dell'array
        Scanner tastiera = new Scanner(System.in);
        for(int i=0;i<Array.length;i++){
            Array[i]=tastiera.nextInt();
        }
    }
    private static boolean controlloArray(int[] Array1,int[] Array2){//metodo per controllare se ci sono numeri uguali nei due array
        boolean numUguale =false;
        for(int i=0;i<Array1.length;i++){
            for(int k=0;k<Array2.length;k++){
                if(Array1[i] == Array2[k]){
                    numUguale =true;
                }
            }
        }
        return numUguale;
    }
}