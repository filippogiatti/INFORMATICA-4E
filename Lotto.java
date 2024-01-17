import java.util.Random;

public class Lotto {
    public static void main(String[] args) {
        int[] vettore = new int[6];

        for (int i = 0; i < vettore.length; i++) {
            int casuale;
            do {
                casuale = ValoreRandom(1, 99);
            } while (contieneNumero(vettore, casuale));

            vettore[i] = casuale;
            System.out.println(vettore[i]);
        }
    }

    private static int ValoreRandom(int minValue, int maxValue) {
        Random casuale = new Random();
        return casuale.nextInt(maxValue - minValue + 1) + minValue;
    }

    private static boolean contieneNumero(int[] array, int numero) {
        for (int i : array) {
            if (i == numero) {
                return true;
            }
        }
        return false;
    }
}