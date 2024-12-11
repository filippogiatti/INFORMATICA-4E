public class Circonferenza {
    private double raggio;

    public Circonferenza(double raggio) { //Costruttore che si aspetta come parametro il raggio della circonferenza e ha lo scopo di creare una circonferenza dato quel raggio.
        this.raggio = raggio;
    }

    public double getRaggio() {
        return raggio;
    }

    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }

    public double calcolaArea() { //Formula di calcolo dell'area della circonferenza con pigreco e il raggio.
        return Math.PI * raggio * raggio;
    }
    //Avere metodi di calcolo in una classe è utile per l'incapsulamento e permette all'utente di non pensare a come funziona il calcolo ma può semplicemente chiamare il calcolo,
    // Inoltre è sufficiente cambiare la formula all'interno del metodo nel caso si vuole cambiarla.
    //Questi metodi rendono anche il codice riutilizzabile.

    public double compareTo(Circonferenza altro){ //Metodo che compara l'area di due circonferenze diverse e restituisce un valore diverso a seconda che l'area della prima circonferenza sia maggiore, minore o uguale alla seconda.
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
        return "Circonferenza:\nRaggio:"+raggio+"\nArea:"+calcolaArea()+"\n\n";
    }
}