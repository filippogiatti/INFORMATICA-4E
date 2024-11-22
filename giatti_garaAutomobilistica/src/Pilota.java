import java.util.Objects;

public class Pilota {
    private String nome;
    private String cognome;
    private String nazionalita;
    private int eta;

    // Costruttore
    public Pilota(String nome, String cognome, String nazionalita, int eta) {
        if (nome == null || cognome == null || nazionalita == null || nome.isBlank() || cognome.isBlank() || nazionalita.isBlank()) {
            throw new IllegalArgumentException("Nome, cognome e nazionalità non possono essere nulli o vuoti.");
        }
        if (eta <= 0) {
            throw new IllegalArgumentException("L'età deve essere un numero positivo.");
        }

        this.nome = nome;
        this.cognome = cognome;
        this.nazionalita = nazionalita;
        this.eta = eta;
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public int getEta() {
        return eta;
    }

    // Metodo toString
    @Override
    public String toString() {
        return String.format("Pilota: %s %s, Nazionalità: %s, Età: %d", nome, cognome, nazionalita, eta);
    }

    // Metodo equals per verificare unicità
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pilota pilota = (Pilota) obj;
        return eta == pilota.eta &&
                nome.equalsIgnoreCase(pilota.nome) &&
                cognome.equalsIgnoreCase(pilota.cognome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome.toLowerCase(), cognome.toLowerCase(), eta);
    }
}
