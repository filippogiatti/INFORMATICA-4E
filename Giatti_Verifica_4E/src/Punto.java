import java.math.*;
public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y){ //Costruttore di un punto che crea un punto date le coordinate.
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distanza(Punto altro) {  //formula della distanza tra due punti nel piano cartesiano
        double distanza = Math.sqrt(Math.pow(this.x - altro.x, 2) + Math.pow(this.y - altro.y, 2));
        return distanza;
    }

}
