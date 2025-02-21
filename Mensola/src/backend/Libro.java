package backend;

import java.util.Objects;

public class Libro {
    private String autore;
    private String titolo;
    private int nPagine;
    private Genere tipo;
    private static final double COSTOPAGINE = 0.05;

    public Libro(String autore, String titolo, int nPagine, Genere tipo) {
        this.autore = autore;
        this.titolo = titolo;
        this.nPagine = nPagine;
        this.tipo = tipo;
    }

    public String getAutore() {
        return autore;
    }
    public String getTitolo() {
        return titolo;
    }
    public Genere getTipo() {
        return tipo;
    }
    public int getnPagine() {
        return nPagine;
    }

    @Override
    public String toString() {
        return String.format("titolo: %s; autore: %s; numero pagine: %d; tipo: %s, Prezzo Libro: %f", titolo, autore, nPagine, tipo, Libro.prezzo(nPagine, COSTOPAGINE));
    }

    public static double prezzo(int nPagine, final double COSTOPAGINE){
        return nPagine * COSTOPAGINE;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Libro libro = (Libro) object;
        return Objects.equals(autore, libro.autore) && Objects.equals(titolo, libro.titolo);
    }
}

// Classe Manuale
class Manuale extends Libro {
    private String argomento;
    private String livello;

    public Manuale(String autore, String titolo, int nPagine, String argomento, String livello) {
        super(autore, titolo, nPagine, Genere.MANUALE);
        this.argomento = argomento;
        this.livello = livello;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Argomento: %s, Livello: %s", argomento, livello);
    }
}

// Classe Romanzo
class Romanzo extends Libro {
    private String genereLetterario;

    public Romanzo(String autore, String titolo, int nPagine, String genereLetterario) {
        super(autore, titolo, nPagine, Genere.ROMANZO);
        this.genereLetterario = genereLetterario;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Genere Letterario: %s", genereLetterario);
    }
}

// Classe Thriller
class Thriller extends Libro {
    private String genereThriller;

    public Thriller(String autore, String titolo, int nPagine, String genereThriller) {
        super(autore, titolo, nPagine, Genere.THRILLER);
        this.genereThriller = genereThriller;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Genere Thriller: %s", genereThriller);
    }
}