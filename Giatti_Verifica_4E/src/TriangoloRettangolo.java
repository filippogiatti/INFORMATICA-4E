public class TriangoloRettangolo {
    private double base;
    private double altezza;

    public TriangoloRettangolo(double base, double altezza) { //Costruttore che si aspetta come parametri la base e l'altezza del triangolo e ha lo scopo di creare un triangolo dati quei parametri.
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

    public double calcolaArea() { //Calcola l'area di un triangolo rettangolo con la formula base * altezza diviso 2.
        return (base * altezza) / 2;
    }
    //Avere metodi di calcolo in una classe è utile per l'incapsulamento e permette all'utente di non pensare a come funziona il calcolo ma può semplicemente chiamare il calcolo,
    // Inoltre è sufficiente cambiare la formula all'interno del metodo nel caso si vuole cambiarla.
    //Questi metodi rendono anche il codice riutilizzabile.

    public double compareTo(TriangoloRettangolo altro){ //Metodo che compara l'area di due triangoli diversi e restituisce un valore diverso a seconda che l'area del primo rettangolo sia maggiore, minore o uguale al secondo.
        double valore=0;
        if(this.calcolaArea()> altro.calcolaArea()){
            valore=1;
        }
        if(this.calcolaArea()< altro.calcolaArea()){
            valore=-1;
        }
        if(this.calcolaArea()== altro.calcolaArea()){
            valore=0;
        }
        return valore;
    }

    public String getInformazioni(){ //Da informazioni su questa figura
        return "Triangolo Rettangolo:\nBase:"+base+"\nAltezza:"+altezza+"\nArea:"+calcolaArea()+"\n\n";
    }
}
