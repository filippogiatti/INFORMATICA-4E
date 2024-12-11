public class Quadrato {
    private double lato;

    public Quadrato(double lato) { //Costruttore che si aspetta come parametro il lato del quadrato e ha lo scopo di creare un quadrato dato quel lato.
        this.lato = lato;
    }

    public double getLato() {
        return lato;
    }

    public void setLato(double lato) {
        this.lato = lato;
    }

    public double calcolaArea() { //Calcola l'area di un quadrato con la formula lato * lato.
        return lato * lato;
    }
    //Avere metodi di calcolo in una classe è utile per l'incapsulamento e permette all'utente di non pensare a come funziona il calcolo ma può semplicemente chiamare il calcolo,
    // Inoltre è sufficiente cambiare la formula all'interno del metodo nel caso si vuole cambiarla.
    //Questi metodi rendono anche il codice riutilizzabile.

    public double compareTo(Quadrato altro){ //Metodo che compara l'area di due quadrati diversi e restituisce un valore diverso a seconda che il primo quadrato sia maggiore, minore o uguale al secondo.
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
        return "Quadrato:\nLato:"+lato+"\nArea:"+calcolaArea()+"\n\n";
    }
}