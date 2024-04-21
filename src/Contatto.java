enum tipoContratto{abitazione, cellulare, aziendale};

public class Contatto {
    public String nome;
    public String cognome;
    public String telefono;
    public tipoContratto tipo;
    public double saldoTelefonico;


    public String stampa() {
        return String.format("Nome: %s Cognome: %s Telefono: %s, tipo: %s, saldo telefonico: %.2f", nome, cognome, telefono, tipo.toString(), saldoTelefonico);
    }

    public Contatto() {
        this.saldoTelefonico = 0.0; // Saldo iniziale
    }

    // Metodo per incrementare il saldo telefonico
    public void incrementaSaldo(double importo) {
        this.saldoTelefonico += importo;
        System.out.println("Saldo incrementato di " + importo + " Euro. Saldo attuale: " + this.saldoTelefonico + " Euro");
    }

    // Metodo per decrementare il saldo telefonico in base ai minuti di chiamata
    public void decrementaSaldo(double minutiChiamata) {
        double costoMinuto = 0.1; // Costo per minuto di chiamata
        double costoChiamata = costoMinuto * minutiChiamata;

        if (this.saldoTelefonico >= costoChiamata) {
            this.saldoTelefonico -= costoChiamata;
            System.out.println("Chiamata di " + minutiChiamata + " minuti. Costo: " + costoChiamata + " Euro. Saldo attuale: " + this.saldoTelefonico + " Euro");
        } else {
            System.out.println("Saldo insufficiente per effettuare la chiamata.");
        }
    }
}

