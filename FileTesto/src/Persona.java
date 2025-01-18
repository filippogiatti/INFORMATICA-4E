public class Persona {
    private String anagrafica;
    private int eta;

    public Persona(String anagrafica, int eta) {
        this.anagrafica = anagrafica;
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "Persona:" +
                "anagrafica='" + anagrafica + '\'' +
                ", eta=" + eta;
    }

    public String toCSV(){
        return String.format("%s;%d", anagrafica, eta);
    }
}