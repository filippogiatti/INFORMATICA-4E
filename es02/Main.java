import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = 10;
        int[] vett = new int[n];
        System.out.println("Inserisci gli elementi dell'array (numeri compresi tra 1 e 30):");

        for (int i = 0; i < n; i++) {
            int num;
            boolean isDuplicate;
            do {
                isDuplicate = false;
                System.out.print("Inserisci il numero " + (i + 1) + ": ");
                num = scanner.nextInt();

                if (num < 1 || num > 30) {
                    System.out.println("I numeri devono essere compresi tra 1 e 30. Riprova.");
                    isDuplicate = true;
                } else {
                    for (int j = 0; j < i; j++) {
                        if (vett[j] == num) {
                            System.out.println("Numero già inserito. Riprova.");
                            isDuplicate = true;
                            break;
                        }
                    }
                }
            } while (isDuplicate);
            vett[i] = num;
        }

        sortPari(vett);

        System.out.println("Array ordinato:");
        for (int num : vett) {
            System.out.print(num + " ");
        }
    }

    public static void sortPari(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            if (array[i] % 2 == 0) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (array[j] % 2 == 0 && array[j] < array[minIndex]) {
                        minIndex = j;
                    }
                }
                if (minIndex != i) {
                    int temp = array[minIndex];
                    array[minIndex] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
}
