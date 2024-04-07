import static tools.utility.*;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] operazioni = {"VODAFONE", "[1] Inserimento",
                "[2] Visualizzazione",
                "[3] Ricerca",
                "[4] Fine"};

        final int nMax=3;
        Contatto[] gestore = new Contatto[nMax];
        int contrattiVenduti = 0;
        boolean siTel=true;

        Scanner keyboard = new Scanner(System.in);

        boolean fine=true;
        do {
            switch(menu(operazioni, keyboard)) {
                case 1->{
                    if (contrattiVenduti < nMax) {
                        //firma contratto
                        gestore[contrattiVenduti]=leggiPersona(siTel,keyboard,contrattiVenduti,gestore);
                        contrattiVenduti++;
                    } else {
                        System.out.println("Non ci sono più contratti da vendere");
                    }
                    break;
                }
                case 2->{}
                case 3->{}
                default-> fine=false;
            }
        }while(fine);
    }
    private static Contatto leggiPersona(boolean Sitel, Scanner keyboard, int contrattiVenduti, Contatto[] gestore ) {

        //Sitel è true quando dobbiamo leggere
        String[] tipoC = {"Telefono","1]abitazione", "2]cellulare", "3]aziendale"};

        //Istanziato un oggetto di tipo contatto:
        Contatto persona = new Contatto();
        boolean esistente;
        do {
            esistente=false;
            System.out.println("\nInserisci il nome: ");
            String nome = keyboard.nextLine();
            System.out.println("\nInserisci il cognome: ");
            persona.cognome = keyboard.nextLine();
            for (int i = 0; i < contrattiVenduti; i++) {
                if (gestore[i].nome.equalsIgnoreCase(nome) && gestore[i].cognome.equalsIgnoreCase(persona.cognome)) {
                    System.out.println("Contratto già esistente per questo nome.");
                    esistente = true;
                    break;
                }
            }
            // Se il nome non è stato trovato nei contratti esistenti, assegna il nome alla persona
            if (!esistente) {
                persona.nome=nome;
            }

        }while(esistente);
        System.out.println("\nInserisci il numero di telefono: ");
        if (Sitel) {
            persona.telefono = keyboard.nextLine();  //Vado a leggere il numero di telefono
            //I valori assegnati all'attributo sono compresi nel range
            switch (menu(tipoC, keyboard)) {
                case 1 -> persona.tipo = tipoContratto.abitazione;
                case 2 -> persona.tipo = tipoContratto.cellulare;
                default -> persona.tipo = tipoContratto.aziendale;

            }
        }

        return persona;
    }
    private static void visualizza(String[] gestore, int contrattiVenduti){

    }
}
