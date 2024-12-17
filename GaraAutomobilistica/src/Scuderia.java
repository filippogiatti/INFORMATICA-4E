public class Scuderia implements Comparable<Scuderia>{
    private String nome;
    private Pilota p;
    private int numeroAuto;
    private Integer tempoGiro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pilota getP() {
        return p;
    }

    public void setP(Pilota p) {
        this.p = p;
    }

    public int getNumeroAuto() {
        return numeroAuto;
    }

    public void setNumeroAuto(int numeroAuto) {
        this.numeroAuto = numeroAuto;
    }

    public Integer getTempoGiro() {
        return tempoGiro;
    }

    public void setTempoGiro(Integer tempoGiro) {
        this.tempoGiro = tempoGiro;
    }

    @Override
    public int compareTo(Scuderia o) {
        return 0;
    }
}
