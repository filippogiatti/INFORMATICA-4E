public class Main {
    public static void main(String[] args) {
        Rettangolo rettangolo = new Rettangolo(15, 18);
        Quadrato quadrato = new Quadrato(6);
        Quadrato altro = new Quadrato(7);
        TriangoloRettangolo triangolo = new TriangoloRettangolo(3, 4);
        Poligono poligono = new Poligono(5,12);
        Circonferenza circonferenza = new Circonferenza(6);
        Punto punto = new Punto(3,6);
        Punto punto1 = new Punto(2,4);
        System.out.println(rettangolo.getInformazioni());
        System.out.println(quadrato.getInformazioni());
        System.out.println(triangolo.getInformazioni());
        System.out.println(circonferenza.getInformazioni());
        if (quadrato.compareTo(altro) > 0) {
            System.out.println("Il primo quadrato ha un'area minore del  secondo quadrato.");
        } else {
            System.out.println("Il primo quadrato ha un'area minore o uguale a quella del secondo quadrato.");
        }
        System.out.println(poligono.toString());
        System.out.println("\nDistanza tra i punti: "+punto.distanza(punto1));
    }
}
