enum tipoContratto {abitazione, cellulare, aziendale}

public class Contatto {
    String nome;
    String cognome;
    String telefono;
    tipoContratto tipo;
    boolean isHidden = false;
    double saldo = 0.0;

    void incrementaSaldo(double importo) {
        saldo += importo;
    }

    void decrementaSaldo(double durataChiamata) {
        saldo -= durataChiamata * 0.10; // Esempio: 0.10€ per minuto
    }

    String stampa() {
        return nome + " " + cognome + ": " + telefono + " (" + tipo + ") - Saldo: " + saldo + "€" + (isHidden ? " [Nascosto]" : "");
    }
}
