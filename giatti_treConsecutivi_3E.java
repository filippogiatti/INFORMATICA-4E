import java.util.Random;

public class giatti_treConsecutivi_3E {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numeri = new int[10];

        // Genera numeri casuali nell'intervallo da 1 a 10 per riempire l'array
        for (int i = 0; i < numeri.length; i++) {
            numeri[i] = random.nextInt(10) + 1;
        }

        boolean trovato = false;

        for (int i = 0; i < numeri.length - 2; i++) {
            if (numeri[i] == numeri[i + 1] && numeri[i] == numeri[i + 2]) {
                trovato = true;
                break;
            }
        }

        if (trovato) {
            System.out.println("Tre valori consecutivi uguali");
        } else {
            System.out.println("NO");
        }
    }
}

