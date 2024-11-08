// File: Giostra.java

import java.time.LocalDateTime;

public class Giostra {
    private final String nome;
    private LocalDateTime dataOraAccesso;

    public Giostra(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataOraAccesso() {
        return dataOraAccesso;
    }

    public void setDataOraAccesso(LocalDateTime dataOraAccesso) {
        this.dataOraAccesso = dataOraAccesso;
    }
}
