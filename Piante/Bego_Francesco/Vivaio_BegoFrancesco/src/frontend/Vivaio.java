//Bego Francesco 4E
package frontend;

import backend.Arboree;
import backend.Arbustive;
import backend.Pianta;
import backend.erbacee.Erbacee;
import backend.erbacee.TipiErbacee;

import static utility.Tools.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Vivaio {
    private ArrayList<Pianta> piante = new ArrayList<>();

    public void leggiPianta(Scanner keyboard) throws Exception {
        System.out.println( "Inserisci il codice alfanumerico della pianta: \n" );
        String id = keyboard.nextLine();
        if (ricercaCodice( id ) != -1) {
            throw new Exception( "Esiste già una pianta con quel codice" );
        }
        System.out.println( "Inserisci la descrizione della pianta: \n" );
        String descrizioe = keyboard.nextLine();

        System.out.println( "Inserisci il mese di fuoritura della pianta: \n" );
        String fioritura = keyboard.nextLine();

        System.out.println( "Inserisci il prezzo della pianta" );
        double prezzo = Double.parseDouble( keyboard.nextLine() );

        String[] opzioniPianta = {
                "TIPI DI PIANTA",
                "Erbacee",
                "Arbustive",
                "Arboree"
        };

        switch (Menu( opzioniPianta, keyboard )) {
            case 1: {
                System.out.println( "Inserisci il tipo di erbacea: " );
                TipiErbacee tipo = null;
                String[] opzioniErbacea = {
                        "Opzioni Erbacea",
                        "Industriali",
                        "Arbustive",
                        "Arboree"
                };
                switch (Menu( opzioniErbacea, keyboard )) {
                    case 1: {
                        tipo = TipiErbacee.industriali;
                        break;
                    }
                    case 2: {
                        tipo = TipiErbacee.officinali;
                        break;
                    }
                    case 3: {
                        tipo = TipiErbacee.daFiore;
                        break;
                    }
                }

                piante.add( new Erbacee( id, descrizioe, fioritura, prezzo, tipo ) );
                break;
            }
            case 2: {
                System.out.println( "Inserisci altezza massimma del fusto" );
                double altezza = Double.parseDouble( keyboard.nextLine() );

                piante.add( new Arbustive( id, descrizioe, fioritura, prezzo, altezza ) );
                break;
            }
            case 3: {
                System.out.println( "Inserisci altezza massimma del fusto" );
                double altezza = Double.parseDouble( keyboard.nextLine() );
                System.out.println( "Inserisci la superficie della chioma" );
                double chioma = Double.parseDouble( keyboard.nextLine() );

                piante.add( new Arboree( id, descrizioe, fioritura, prezzo, altezza, chioma ) );
                break;
            }
        }
        throw new Exception( "Errore nell'inserimento" );
    }

    public int ricercaCodice(String id) throws Exception {
        for (Pianta x : piante) {
            if (x.getId().equals( id )) {
                return piante.indexOf( x );
            }
        }
        return -1;
    }

    public ArrayList<Pianta> ricercaFioritura(String fioritura) throws Exception {
        ArrayList<Pianta> posizioni = new ArrayList<>();
        controllaSeVuoto();
        for (Pianta x : piante) {
            if (x.getFioritura().equals( fioritura )) {
                posizioni.add( x );
            }
        }
        if (posizioni.isEmpty()) {
            throw new Exception( "Non è stata trovata nessuna pianta con quel mese di fioritura" );
        } else {
            return posizioni;
        }
    }

    public ArrayList<Pianta> ricercaPrezzo(Double prezzo) throws Exception {
        ArrayList<Pianta> posizioni = new ArrayList<>();
        controllaSeVuoto();
        for (Pianta x : piante) {
            if (x.getPrezzo() <= prezzo) {
                posizioni.add( x );
            }
        }
        if (posizioni.isEmpty()) {
            throw new Exception( "Non è stata trovata nessuna pianta prezzo <= a quello inserito" );
        } else {
            return posizioni;
        }
    }

    public void visualizza() throws Exception {
        controllaSeVuoto();
        piante.forEach( x -> x.toString() );
    }

    public void visualizza(ArrayList<Pianta> a) throws Exception {
        a.forEach( x -> x.toString() );
    }


    public void controllaSeVuoto() throws Exception {
        if (piante.isEmpty()) {
            throw new Exception( "Non ci sono piante" );
        }
    }

    public void modificaPrezzo(String id, double prezzo) throws Exception {
        piante.get( ricercaCodice( id ) ).setPrezzo( prezzo );
    }

    public void vendiPianta(String id) throws Exception {
        controllaSeVuoto();
        piante.remove( piante.get( ricercaCodice( id ) ) );
    }

    public ArrayList<Pianta> getPiante() {
        return new ArrayList<>( piante );
    }

    public String inserisciCodice(Scanner keyboard) {
        System.out.println( "Inserisci il codice: " );
        return keyboard.nextLine();
    }

    public String inserisciMese(Scanner keyboard) {
        System.out.println( "Inserisci il mese di fioritura: " );
        return keyboard.nextLine();
    }

    public double inserisciPrezzo(Scanner keyboard) {
        System.out.println( "Inserisci il mese di fioritura: " );
        return Double.parseDouble( keyboard.nextLine() );
    }
}
