import java.util.Scanner;
public class Punto {
    private int x;
    private int y;

    /*public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }*/

    public Punto() {
        this.x = 10;
        this.y = 10;
    }

    public Punto(int x, int y) throws Exception {
        if (x > 40) {
            throw new Exception("OutOfRange x");
        }

        if(y>50){
            throw new Exception("OutOfRange y");
        }
        this.setX(x);
        this.setY(y);
    }

    public static Punto inseriemntoPunto(Scanner keyboard){
        Punto temp=new Punto();
        System.out.println("Inserisci le coordinate di x:");
        temp.setX(keyboard.nextInt());
        System.out.println("Inserisci le coordinate di y:");
        temp.setY(keyboard.nextInt());

        return temp;
    }

    public Punto(int y) throws Exception {
        this(23, y) ;

    }
    public int getX(){
       return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x: %d\ny: %d", x,y);

    }
}
