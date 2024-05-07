enum genere{narrativo,avventura,romanzo,storico}
public class Libri {
    public String titolo;
    public genere tipo;
    public int anno;
    public String stampa(){
        return String.format("titolo: %s  genere: %s  anno: %d",titolo,tipo,anno);
    }
}
