import java.util.Scanner;
import java.lang.String;

public class EsercizioStringa {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        String phrase;
        boolean[] check = new boolean[26];
        int characterAscii; // carattere in int quindi uso ascii
        int i;
        char character;

        // make the whole array false
        for (i = 0; i < check.length; i++) {
            check[i] = false;
        }

        // take the input sentence
        do {
            System.out.println("Inserisci la frase da controllare. Non usare spazi o caratteri speciali");
            phrase = kb.nextLine().toLowerCase();
        } while (phrase.isEmpty()); // if the inserted phrase is empty, redo the request

        // gets characters from string
        for (i = 0; i < phrase.length(); i++) {
            characterAscii = phrase.charAt(i);
            check[characterAscii - 97] = true; // tolgo 97, valore in codice ascii corrispondente ad a per capire di che lettera si tratta
        } // se = 0 allora é la "a", 1 = "b"...

        // output of the entered letters
        System.out.println("\nNella stringa compaiono i caratteri:");
        for (i = 0; i < check.length; i++) {
            if (check[i]) { // true control array positions
                character = (char) (i + 97); // sommo 97 ad i dove i corrispondi alla lettera in ASCII-97
                System.out.printf("%s  ", character); // poi faccio il casting della variabile
            }
        }

        // output of the non-entered letters
        System.out.println("\nNella stringa non compaiono i caratteri:");
        for (i = 0; i < check.length; i++) {
            if (!check[i]) { // false control array positions
                character = (char) (i + 97);
                System.out.printf("%s  ", character);
            }
        }
    }
}