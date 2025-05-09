//Bego Francesco 4E Fila A

import java.util.Scanner;

import static utility.Tools.*;

import backend.*;
import frontend.Vivaio;

public class Main {
    public static void main(String[] args) {
        String[] opzioni = {
                "Vivaio",
                "Inserisci Pianta",
                "Ricerca pianta dal codice",
                "Ricerca pianta per mese di fioritura",
                "Ricerca pianta dal prezzo",
                "Vendi pianta",
                "Modifica prezzo pianta",
                "Visualizza Piante",
                "Esci"
        };
        boolean fine = true;
        Scanner keyboard = new Scanner( System.in );
        Vivaio vivaio = new Vivaio();

        do {
            switch (Menu( opzioni, keyboard )) {
                case 1: {
                    try {
                        vivaio.leggiPianta( keyboard );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    try {

                        String id = vivaio.inserisciCodice( keyboard );
                        System.out.println( vivaio.getPiante().get( vivaio.ricercaCodice( id ) ) );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    try {
                        String mese = vivaio.inserisciMese( keyboard );
                        vivaio.visualizza( vivaio.ricercaFioritura( mese ) );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 4: {
                    try {
                        double prezzo = vivaio.inserisciPrezzo( keyboard );
                        vivaio.visualizza( vivaio.ricercaPrezzo( prezzo ) );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 5: {
                    try {
                        String id = vivaio.inserisciCodice( keyboard );
                        vivaio.vendiPianta( id );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 6: {
                    try {
                        String id = vivaio.inserisciCodice( keyboard );
                        double prezzo = vivaio.inserisciPrezzo( keyboard );
                        vivaio.modificaPrezzo( id, prezzo );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 7: {
                    try {
                        vivaio.visualizza();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 8: {
                    fine = false;
                    break;
                }

            }
        } while (fine);
    }
}