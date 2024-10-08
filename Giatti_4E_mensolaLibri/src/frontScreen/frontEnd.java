package frontScreen;

import mensola.Libro;
import java.util.Scanner;

public class frontEnd {
    public static Libro leggiLibro(Scanner keyboard){
        Libro output = new Libro();

        System.out.println("Inserire l'autore: ");
        output.autore= keyboard.nextLine();
        System.out.println("Inserire il titolo: ");
        output.titolo= keyboard.nextLine();
        System.out.println("Inserire il numero di pagine: ");
        output.numeroPagine=keyboard.nextInt();
        Genere[] generi=
    }
}
