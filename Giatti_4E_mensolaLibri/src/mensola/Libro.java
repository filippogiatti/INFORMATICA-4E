package mensola;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Libro {
    public String autore;
    public String titolo;
    public int numeroPagine;
    public final double costoPerPagina=0.05;
    public Genere tipologia;
    public LocalDate dataPubblicazione;

    public String toString(){
    return String.format("Autore: %s: Titolo: %s; Numero di pagine: %d; Prezzo: %f; Genere: %s; Data:%s\n",
            autore, titolo, numeroPagine* costoPerPagina, tipologia.toString(), dataPubblicazione.format(formattazionedata));
    }
}



