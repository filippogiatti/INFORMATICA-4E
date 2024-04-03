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
                    if(contrattiVenduti<nMax){
                        gestore[contrattiVenduti] = leggiPersona(siTel, keyboard);

                    }
                }
                case 2->{}
                case 3->{}
                default-> fine=false;
            }
        }while(fine);
    }
    private static Contatto leggiPersona(boolean siTel, Scanner keyboard){
        String[] tipoC = {"Telefono", "1]abitazione", "2]cellulare", "3]aziendale"};
        Contatto persona = new Contatto();
        System.out.println("\nInserisci il nome:");
        persona.nome=keyboard.nextLine();
        System.out.println("\nInserisci il cognome:");
        persona.cognome=keyboard.nextLine();
        System.out.println("\nInserisci il numero di telefono");
        if(siTel){
            persona.telefono=keyboard.nextLine();
            switch(menu(tipoC, keyboard)){
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