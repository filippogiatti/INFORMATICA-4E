//Bego Francesco 4E
package backend;

public class Arbustive extends Pianta {
    private double altezzaFusto;

    public Arbustive(String id, String descrizione, String fioritura, double prezzo, double altezzaFusto) {
        super( id, descrizione, fioritura, prezzo );
        this.altezzaFusto = altezzaFusto;
    }

    public String toString() {
        return super.toString() + String.format( "Altezza Fusto: %f ", altezzaFusto );
    }
}
