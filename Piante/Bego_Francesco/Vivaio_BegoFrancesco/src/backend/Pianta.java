//Bego Francesco 4E
package backend;

public abstract class Pianta {
    private String id;
    private String descrizione;
    private String fioritura;
    private double prezzo;

    public Pianta(String id, String descrizione, String fioritura, double prezzo) {
        this.id = id;
        this.descrizione = descrizione;
        this.fioritura = fioritura;
        this.prezzo = prezzo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getFioritura() {
        return fioritura;
    }

    public void setFioritura(String fioritura) {
        this.fioritura = fioritura;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String toString() {
        return String.format( "ID: %s, Descrizione: %s, Fioritura: %s, Prezzo: %f ", id, descrizione, fioritura, prezzo );
    }
}
