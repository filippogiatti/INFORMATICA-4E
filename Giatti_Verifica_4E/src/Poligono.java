public class Poligono {
    private int numeroLati;
    private double lunghezzaLato;

    public Poligono(int numeroLati, double lunghezzaLato){
        this.numeroLati = numeroLati;
        this.lunghezzaLato = lunghezzaLato;
    }

    public double calcolaPerimetro(){ //Calcola il perimetro di un poligono moltiplicando il numero dei suoi lati per la lunghezza del lato sapendo che sono tutti uguali.
        return lunghezzaLato*numeroLati;
    }
    public String toString(){ //Da informazioni su questa figura
        return "\nPoligono con "+numeroLati+" lati di lunghezza e con perimetro: "+calcolaPerimetro();
    }
}
