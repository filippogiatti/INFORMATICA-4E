import java.util.Objects;

public class Auto {
    private String scuderia;
    private Pilota pilota;
    private double cilindrata;

    // Costruttore
    public Auto(String scuderia, Pilota pilota, double cilindrata) {
        if (scuderia == null || scuderia.isBlank()) {
            throw new IllegalArgumentException("La scuderia non può essere nulla o vuota.");
        }
        if (pilota == null) {
            throw new IllegalArgumentException("Ogni auto deve avere un pilota associato.");
        }
        if (cilindrata <= 0) {
            throw new IllegalArgumentException("La cilindrata deve essere un valore positivo.");
        }

        this.scuderia = scuderia;
        this.pilota = pilota;
        this.cilindrata = cilindrata;
    }

    // Getter e Setter
    public String getScuderia() {
        return scuderia;
    }

    public Pilota getPilota() {
        return pilota;
    }

    public double getCilindrata() {
        return cilindrata;
    }

    // Metodo toString
    @Override
    public String toString() {
        return String.format("Auto: Scuderia: %s, Pilota: [%s], Cilindrata: %.1f cc",
                scuderia, pilota.toString(), cilindrata);
    }

    // Metodo equals per verificare unicità delle auto (optional, basato su pilota e scuderia)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Auto auto = (Auto) obj;
        return scuderia.equalsIgnoreCase(auto.scuderia) && pilota.equals(auto.pilota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scuderia.toLowerCase(), pilota);
    }
}
