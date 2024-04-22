import java.util.Scanner;

public class evenOddSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci la dimensione dell'array:");
        int dimensione = scanner.nextInt();

        int[] arr = new int[dimensione];
        System.out.println("Inserisci gli elementi dell'array:");

        for (int i = 0; i < dimensione; i++) {
            arr[i] = scanner.nextInt();
        }

        evenOddSearch(arr);
        System.out.println("Array dopo l'ordinamento dei numeri pari e dispari:");
        System.out.println(java.util.Arrays.toString(arr));

        System.out.println("Inserisci il valore da cercare:");
        int valoreCercato = scanner.nextInt();

        int posizione = biBinarySearch(arr, valoreCercato);
        if (posizione != -1) {
            System.out.println("Il valore " + valoreCercato + " si trova in posizione " + posizione);
        } else {
            System.out.println("Il valore " + valoreCercato + " non Ã¨ presente nell'array.");
        }
    }

    // Metodo per ordinare i numeri pari in modo crescente e i dispari in modo decrescente
    public static void evenOddSearch(int[] arr) {
        int[] pari = filtraPari(arr);
        int[] dispari = filtraDispari(arr);
        quickSort(pari, 0, pari.length - 1, true);
        quickSort(dispari, 0, dispari.length - 1, false);

        // Riunire i numeri pari e dispari ordinati
        int index = 0;
        for (int i = 0; i < pari.length; i++) {
            arr[index++] = pari[i];
        }
        for (int i = 0; i < dispari.length; i++) {
            arr[index++] = dispari[i];
        }
    }

    // Metodo per filtrare numeri pari
    private static int[] filtraPari(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count++;
            }
        }
        int[] pari = new int[count];
        int index = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                pari[index++] = num;
            }
        }
        return pari;
    }

    // Metodo per filtrare numeri dispari
    private static int[] filtraDispari(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                count++;
            }
        }
        int[] dispari = new int[count];
        int index = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                dispari[index++] = num;
            }
        }
        return dispari;
    }

    // Metodo per l'ordinamento Quick Sort
    private static void quickSort(int[] arr, int basso, int alto, boolean crescente) {
        if (basso < alto) {
            int pi = partition(arr, basso, alto, crescente);
            quickSort(arr, basso, pi - 1, crescente);
            quickSort(arr, pi + 1, alto, crescente);
        }
    }

    // Metodo per il partizionamento
    private static int partition(int[] arr, int basso, int alto, boolean crescente) {
        int pivot = arr[alto];
        int i = (basso - 1);
        for (int j = basso; j < alto; j++) {
            if (crescente ? arr[j] < pivot : arr[j] > pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[alto];
        arr[alto] = temp;
        return i + 1;
    }

    // Metodo per la ricerca binaria personalizzata
    public static int biBinarySearch(int[] arr, int target) {
        int sinistra = 0;
        int destra = arr.length - 1;

        while (sinistra <= destra) {
            int medio = sinistra + (destra - sinistra) / 2;

            // Controllo se l'elemento al medio Ã¨ uguale al target
            if (arr[medio] == target) {
                return medio;
            }

            // Se il target Ã¨ minore, cerco nella metÃ  sinistra
            if (arr[medio] > target) {
                destra = medio - 1;
            }
            // Altrimenti cerco nella metÃ  destra
            else {
                sinistra = medio + 1;
            }
        }

        // Se non trovo il target, restituisco -1
        return -1;
    }
}