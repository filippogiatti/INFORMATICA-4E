//Bego Francesco 4E
package backend.erbacee;

import backend.Pianta;

public class Erbacee extends Pianta {
    private TipiErbacee tipo;

    public Erbacee(String id, String descrizione, String fioritura, double prezzo, TipiErbacee tipo) {
        super( id, descrizione, fioritura, prezzo );
        this.tipo = tipo;
    }

    public TipiErbacee getTipo() {
        return tipo;
    }

    public void setTipo(TipiErbacee tipo) {
        this.tipo = tipo;
    }

    public String toString(){
        return super.toString() + String.format("Tipo di erbacea: %s ", tipo.toString());
    }
}
