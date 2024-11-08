// File: Persona.java

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Persona {
    private final int biglietto;
    private final List<Giostra> giostreProvate;
    private final LocalDateTime oraEntrata;

    public Persona(int biglietto) {
        this.biglietto = biglietto;
        this.giostreProvate = new ArrayList<>();
        this.oraEntrata = LocalDateTime.now();
    }

    public int getBiglietto() {
        return biglietto;
    }

    public LocalDateTime getOraEntrata() {
        return oraEntrata;
    }

    public void provaGiostra(Giostra giostra) {
        giostreProvate.add(giostra);
        giostra.setDataOraAccesso(LocalDateTime.now());
    }

    public List<Giostra> getGiostreProvate() {
        return giostreProvate;
    }

    public long calcolaTempoDiPermanenza() {
        return java.time.Duration.between(oraEntrata, LocalDateTime.now()).toMinutes();
    }

    public void resetGiostreProvate() {
        giostreProvate.clear();
    }
}

