public class Main {
    public static void main(String[] args) {
        Frazione frazione1=new Frazione("3","5");
        Frazione frazione2=new Frazione("2","3");

        System.out.println(sommaFrazioni(frazione1, frazione2));


    }

    public static Frazione sommaFrazioni(Frazione frazione1, Frazione frazione2) {
        int num1 = Integer.parseInt(frazione1.getNum());
        int den1 = Integer.parseInt(frazione1.getDen());
        int num2 = Integer.parseInt(frazione2.getNum());
        int den2 = Integer.parseInt(frazione2.getDen());

        int numRisultato = num1 * den2 + num2 * den1;
        int denRisultato = den1 * den2;

        return new Frazione(String.valueOf(numRisultato), String.valueOf(denRisultato));
    }
}