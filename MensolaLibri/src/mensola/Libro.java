package mensola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Libro {
    public String autore;
    public String titolo;
    public int numeroPagine;
    public final double costoPerPagina = 0.05;
    public Genere tipologia;
    public LocalDate dataPubblicazione;
    private final DateTimeFormatter formattazioneData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return String.format("Autore : %s; Titolo : %s; Numero di pagine : %d; Prezzo : %f; Genere : %s; Data : %s\n",
                autore, titolo, numeroPagine, numeroPagine * costoPerPagina, tipologia.toString(), dataPubblicazione.format(formattazioneData));
    }
}