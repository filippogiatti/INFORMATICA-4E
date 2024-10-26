package mensola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Libro {
    public String autore;
    public String titolo;
    public int numeroPagine;
    public double costoPerPagina = 0.05;
    public Genere tipologia;
    public LocalDate dataPubblicazione;
    public final DateTimeFormatter formattazioneData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Costruttore vuoto per creazione libro iniziale
    public Libro() {}

    // Costruttore completo per inizializzazione rapida
    public Libro(String autore, String titolo, int numeroPagine, Genere tipologia, LocalDate dataPubblicazione) {
        this.autore = autore;
        this.titolo = titolo;
        this.numeroPagine = numeroPagine;
        this.tipologia = tipologia;
        this.dataPubblicazione = dataPubblicazione;
    }

    // Getter e Setter
    public String getAutore() { return autore; }
    public void setAutore(String autore) { this.autore = autore; }

    public String getTitolo() { return titolo; }
    public void setTitolo(String titolo) { this.titolo = titolo; }

    public int getNumeroPagine() { return numeroPagine; }
    public void setNumeroPagine(int numeroPagine) { this.numeroPagine = numeroPagine; }

    public double getCostoPerPagina() { return costoPerPagina; }

    public Genere getTipologia() { return tipologia; }
    public void setTipologia(Genere tipologia) { this.tipologia = tipologia; }

    public LocalDate getDataPubblicazione() { return dataPubblicazione; }
    public void setDataPubblicazione(LocalDate dataPubblicazione) { this.dataPubblicazione = dataPubblicazione; }

    // Metodo toString migliorato
    @Override
    public String toString() {
        return String.format(
                "Autore: %s; Titolo: %s; Numero di pagine: %d; Prezzo: %.2f; Genere: %s; Data: %s",
                autore != null ? autore : "Sconosciuto",
                titolo != null ? titolo : "Sconosciuto",
                numeroPagine > 0 ? numeroPagine : 0,
                numeroPagine * costoPerPagina,
                tipologia != null ? tipologia.toString() : "Non specificato",
                dataPubblicazione != null ? dataPubblicazione.format(formattazioneData) : "Data non disponibile"
        );
    }
}
