package backend;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mensola mensola = new Mensola(10);

        try {
            Manuale manuale = new Manuale("Autore1", "Manuale Java", 300, "Programmazione", "Avanzato");
            Romanzo romanzo = new Romanzo("Autore2", "Il Grande Romanzo", 500, "Fantasy");
            Thriller thriller = new Thriller("Autore3", "Suspense Totale", 400, "Horror");

            mensola.addLibro(manuale);
            mensola.addLibro(romanzo);
            mensola.addLibro(thriller);

            System.out.println("Libri nella mensola:");
            for (Libro libro : mensola.getLista()) {
                System.out.println(libro);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}