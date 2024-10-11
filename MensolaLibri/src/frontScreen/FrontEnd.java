package frontScreen;

import static utility.Tools.*;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import mensola.*;
import java.time.LocalDate;

public class FrontEnd {
    public static Libro leggiLibro(Scanner keyboard) {
        //Istanziamento libro
        Libro output = new Libro();

        //Inserimento autore
        System.out.println("Inserire l'autore: ");
        output.autore = keyboard.nextLine();
        //Inserimento titolo
        System.out.println("Inserire il titolo: ");
        output.titolo = keyboard.nextLine();
        //Inserimento numero di pagine
        System.out.println("Inserire il numero di pagine");
        output.numeroPagine = keyboard.nextInt();
        //Inserimento tipologia
        Genere[] generi = Genere.values();
        String[] menuData = new String[generi.length + 1];
        menuData[0] = "Inserire genere";
        for(int i = 0; i < generi.length; i++)
            menuData[i + 1] = generi[i].toString();
        int genereIndex = (menu(menuData, keyboard) - 1);
        output.tipologia = generi[genereIndex];
        //Inserimento data
        System.out.print("Inserire data> ");
        String dataInput = keyboard.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        output.dataPubblicazione = LocalDate.parse(dataInput, formatter);

        return output;
    }
}