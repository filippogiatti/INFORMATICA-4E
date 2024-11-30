public class Frazione {
    private String num;
    private String den;

    public Frazione(String num, String den){
        this.num = num;
        this.den = den;
    }

    public void setDen(String den) {
        this.den = den;
    }

    public String getDen() {
        return den;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }


    public void visualizza() {
        System.out.println("Frazione: " + this.num + "/" + this.den);
        double valore = (double) Integer.parseInt(this.num) / Integer.parseInt(this.den);
        System.out.println("Valore: " + valore);
    }

    @Override
    public String toString() {
        return "Frazione: " + this.num + "/" + this.den;
    }

}
