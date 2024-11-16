import java.util.Scanner;

public class Segmento {
    private Punto estremo1;
    private Punto estremo2;
    private double lunghezza;

    public Punto getEstremo1() {
        return estremo1;
    }

    public void setEstremo1(Punto estremo1) {
        this.estremo1 = estremo1;
    }

    public Punto getEstremo2() {
        return estremo2;
    }

    public void setEstremo2(Punto estremo2) {
        this.estremo2 = estremo2;
    }

    public double getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(double lunghezza) {
        this.lunghezza = lunghezza;
    }

    public static Segmento inserimentoSegmento(Scanner keyboard){
        Segmento temp=new Segmento();
        System.out.println("Inserisci le coordinate di x:");
        temp.setEstremo1(Punto.inseriemntoPunto(keyboard));
        System.out.println("Inserisci le coordinate di y:");
        temp.setEstremo2(Punto.inseriemntoPunto(keyboard));

        return temp;
    }
}
