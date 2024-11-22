public class Punto {
    private int coordX;
    private int coordY;
    private int quadrante;

    // Costruttore predefinito
    public Punto() {
        this.coordX = 0;
        this.coordY = 0;
        this.quadrante = determinaQuadrante();
    }

    // Costruttore con parametri
    public Punto(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.quadrante = determinaQuadrante();
    }

    // Metodo per determinare il quadrante
    private int determinaQuadrante() {
        if (coordX > 0 && coordY > 0) return 1;
        if (coordX < 0 && coordY > 0) return 2;
        if (coordX < 0 && coordY < 0) return 3;
        if (coordX > 0 && coordY < 0) return 4;
        return 0; // Origine o assi
    }

    // Getter per la coordinata X
    public int getCoordX() {
        return coordX;
    }

    // Setter per la coordinata X
    public void setCoordX(int coordX) {
        this.coordX = coordX;
        this.quadrante = determinaQuadrante(); // Aggiorna il quadrante
    }

    // Getter per la coordinata Y
    public int getCoordY() {
        return coordY;
    }

    // Setter per la coordinata Y
    public void setCoordY(int coordY) {
        this.coordY = coordY;
        this.quadrante = determinaQuadrante(); // Aggiorna il quadrante
    }

    // Getter per il quadrante
    public int getQuadrante() {
        return quadrante;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Punto (" + coordX + ", " + coordY + "), Quadrante: " + quadrante;
    }
}
