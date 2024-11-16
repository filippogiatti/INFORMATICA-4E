import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        Punto punto = new Punto(-4,4);
        quadrante(punto);

        /*punto.setX(2);
        punto.setY(3);*/

        //System.out.println(punto.toString());


        /*try{
            Punto punto1 = new Punto(41,45);

            quadrante(punto1);
            Punto punto2 = new Punto(3);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }*/






    }

    public static void quadrante(Punto punto){
        if(punto.getX()>0&&punto.getY()>0){
            System.out.println("Il punto si trova nel primo quadrante");
        }else if(punto.getX()<0&&punto.getY()>0){
            System.out.println("Il punto si trova nel secondo quadrante");
        }else if(punto.getX()<0&&punto.getY()<0){
            System.out.println("Il punto si trova nel terzo quadrante");
        }else if(punto.getX()>0&&punto.getY()<0){
            System.out.println("Il punto si trova nel quarto quadrante");
        }else{
            System.out.println("Il punto si trova nell'origine");
        }
    }
}