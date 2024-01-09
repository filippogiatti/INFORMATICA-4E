import java.util.Scanner;
public class BinarioDecimale {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String num = "";

        boolean flagByte = true;

        int decimal = 0;
        char bit;
        int position;

        System.out.println("Inserisci un valore binario");
        num = keyboard.nextLine();

        for (int i = 0; i < num.length(); i++){
            if (!(num.charAt(i) == '1' || num.charAt(i) == '0')) {
                flagByte = false;
            }

            else {
                System.out.println(num.charAt(i));
                bit = num.charAt(i);
                position = bit - '0';
                decimal = decimal * 2 + position;
                System.out.println("decimale :" +decimal);
            }
        }

        if (flagByte)
            System.out.println("Il valore binario inserito in decimale vale: " +decimal);

        else
            System.out.println("Errato! Non hai inserito un valore binario.");

        System.out.println("Fine programma");

    }
}