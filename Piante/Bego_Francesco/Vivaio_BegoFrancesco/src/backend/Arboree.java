//Bego Francesco 4E
package backend;

public class Arboree extends Arbustive {
    private double superficieChioma;

    public Arboree(String id, String descrizione, String fioritura, double prezzo, double altezzaFusto, double superficieChioma) {
        super( id, descrizione, fioritura, prezzo, altezzaFusto );
        this.superficieChioma = superficieChioma;
    }

    public String toString() {
        return super.toString() + String.format( "Superficie coperta dalla chioma: %f", superficieChioma );
    }
}
