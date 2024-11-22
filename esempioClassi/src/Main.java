import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Creazione del primo punto:");
        Punto primoPunto = leggiPunto(input);

        System.out.println("Creazione del secondo punto:");
        Punto secondoPunto = leggiPunto(input);

        Segmento segmento = new Segmento(primoPunto, secondoPunto);
        System.out.println(segmento);
    }

    private static Punto leggiPunto(Scanner input) {
        System.out.print("Inserisci la coordinata X: ");
        int x = input.nextInt();

        System.out.print("Inserisci la coordinata Y: ");
        int y = input.nextInt();

        return new Punto(x, y);
    }
}
