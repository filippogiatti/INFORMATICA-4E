import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int a, b, somma;
        Scanner scanner = new Scanner(System.in);
       /* try {
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Si è verificato un errore");
        }*/
        boolean ripeti;
        do {
            try {
                ripeti = false;
                gestInteger(scanner);

                System.out.println("Inserisci il secondo numero: ");
                b = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Si è verificato un errore");
                System.out.println(e.getMessage());
                ripeti = true;
            }
        } while (ripeti);
    }



        private static int gestInteger(Scanner scanner) throws Exception{
            int num=-1;
            System.out.println("Inserire un valore: ");
            num=Integer.parseInt(scanner.nextLine());

            if(num>=0){
                return num;
            }
            else{
                throw new Exception(("Valore non valido"));
            }
        }






}