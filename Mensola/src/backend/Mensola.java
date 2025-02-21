package backend;

import java.util.ArrayList;

class Mensola {
    private int numeroLibri;
    private int maxLibri;
    private ArrayList<Libro> mensola;

    public Mensola(int maxLibri) {
        this.maxLibri = maxLibri;
        mensola = new ArrayList<>(maxLibri);
    }

    public void addLibro(Libro lib) throws Exception {
        if (numeroLibri >= maxLibri) {
            throw new Exception("La mensola è piena");
        }
        if (lib != null && !mensola.contains(lib)) {
            mensola.add(lib);
            numeroLibri++;
        } else {
            throw new Exception("Il libro è già presente o riferimento nullo");
        }
    }

    public ArrayList<Libro> getLista() {
        return new ArrayList<>(mensola);
    }
}
