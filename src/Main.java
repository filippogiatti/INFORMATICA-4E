import java.util.Scanner;

import static Tools.utility.*;
public class Main {
    public static void main(String[] Args){
        String[] opzioni={"LIBRERIA","[1]Inserimento",
                "[2] visualizza","[3]ricerca","[4]cancellazione","[5]fine"};
        final int dimScaffale=10;
        int posizione=0;
        Scanner scanner=new Scanner(System.in);
        Libri[] scaffale=new Libri[dimScaffale];
        boolean fine=true;

        do {
            switch (menu(opzioni, scanner)) {
                case 1: {
                    inserimento(scanner, scaffale, posizione);
                    posizione++;
                    break;
                }
                case 2: {
                    visualizza(scaffale, posizione);
                    break;
                }
                case 3:{
                    if(posizione==0){
                        System.out.println("Non sono presenti libri nello scaffale!");
                    }else {
                        System.out.println("Inserisci il titolo\n");
                        String titoloR = scanner.nextLine();
                        for (int i = 0; i < posizione; i++) {
                            if (scaffale[i].titolo.equals(titoloR))
                                System.out.println(scaffale[i].stampa());

                        }
                    }
                    break;
                }
                case 4:{
                    cancellazione(posizione, scaffale, scanner);
                    break;
                }
                default: {
                    fine = false;
                }
            }
        }while(fine);

    }
    public static void inserimento(Scanner scanner, Libri[] scaffale,int posizione){
        String[] scelta={"GENERE","[1]narrativo",
                "[2] avventura","3]romanzo","[4]storico"};

        Libri libro=new Libri();
        System.out.println("Inserisci il titolo\n");
        libro.titolo=scanner.nextLine();
        System.out.println("Inserisci l'anno\n");
        libro.anno=scanner.nextInt();
        scanner.nextLine();
        switch(menu(scelta,scanner)){
            case 1:
                libro.tipo=genere.narrativo;
                break;
            case 2:
                libro.tipo=genere.avventura;
                break;
            case 3:
                libro.tipo=genere.romanzo;
                break;
            default:
                libro.tipo=genere.storico;
                break;
        }
        scaffale[posizione]=libro;


    }
    public static void visualizza(Libri[] scaffale,int posizione){
        if(posizione==0){
            System.out.println("Non sono presenti libri nello scaffale!");
        }else{
            for(int i=0;i<posizione;i++){
                if(scaffale[i]==null){
                    System.out.println("Non sono presenti libri nello scaffale!");
                }else
                System.out.println(scaffale[i].stampa());
            }
        }
    }
    private static void cancellazione(int posizione, Libri[] scaffale, Scanner scanner) {
        if (posizione == 0) {
            System.out.println("Non sono presenti libri nello scaffale!");
        } else {
            System.out.println("Inserisci il titolo del libro che vuoi rimuovere:");
            String titoloDaRimuovere = scanner.nextLine();
            boolean libroTrovato = false;

            for (int i = 0; i < posizione; i++) {
                if (scaffale[i] != null && scaffale[i].titolo.equals(titoloDaRimuovere)) {
                    // Shift degli elementi a sinistra per riempire il buco
                    for (int j = i; j < posizione - 1; j++) {
                        scaffale[j] = scaffale[j + 1];
                    }
                    scaffale[posizione - 1] = null; // Imposta l'ultimo elemento a null
                    posizione--; // Riduci la posizione dopo la cancellazione
                    libroTrovato = true;
                    break;
                }
            }

            if (!libroTrovato) {
                System.out.println("Il libro con titolo '" + titoloDaRimuovere + "' non è presente nello scaffale.");
            }
        }
    }

}