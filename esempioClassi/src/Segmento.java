public class Segmento {
    private Punto inizio;
    private Punto fine;
    private double distanza;

    // Costruttore
    public Segmento(Punto inizio, Punto fine) {
        this.inizio = inizio;
        this.fine = fine;
        this.distanza = calcolaDistanza();
    }

    // Metodo per calcolare la distanza tra i punti
    private double calcolaDistanza() {
        int differenzaX = fine.getCoordX() - inizio.getCoordX();
        int differenzaY = fine.getCoordY() - inizio.getCoordY();
        return Math.sqrt(differenzaX * differenzaX + differenzaY * differenzaY);
    }

    // Getter per il punto iniziale
    public Punto getInizio() {
        return inizio;
    }

    // Getter per il punto finale
    public Punto getFine() {
        return fine;
    }

    // Getter per la lunghezza del segmento
    public double getDistanza() {
        return distanza;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Segmento: " +
                "Inizio = " + inizio +
                ", Fine = " + fine +
                ", Lunghezza = " + String.format("%.2f", distanza);
    }
}

