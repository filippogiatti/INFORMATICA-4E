public class Rettangolo {
    private double base;
    private double altezza;

    public Rettangolo(double base, double altezza) { //Costruttore che si aspetta come parametri la base e l'altezza del rettangolo e ha lo scopo di creare un rettangolo dati quei parametri.
        this.base = base;
        this.altezza = altezza;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public double calcolaArea() { //Calcola l'area di un rettangolo con la formula base * altezza.
        return base * altezza;
    }

    public double calcolaPerimetro() { //Calcola il perimetro di un rettangolo sommando base e altezza e moltiplicandole *2.
        return 2 * (base + altezza);
    }
    //Avere metodi di calcolo in una classe è utile per l'incapsulamento e permette all'utente di non pensare a come funziona il calcolo ma può semplicemente chiamare il calcolo,
    // Inoltre è sufficiente cambiare la formula all'interno del metodo nel caso si vuole cambiarla.
    //Questi metodi rendono anche il codice riutilizzabile.

    public String getInformazioni(){ //Da informazioni su questa figura
        return "Rettangolo:\nBase:"+base+"\nAltezza:"+altezza+"\nArea:"+calcolaArea()+"\nPerimetro:"+calcolaPerimetro()+"\n\n";
    }
}