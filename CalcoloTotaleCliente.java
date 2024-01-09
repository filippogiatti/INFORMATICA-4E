import java.util.Scanner;

public class CalcoloTotaleCliente {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Inserisci il numero di bottiglioni acquistati: ");
        int numBottiglioni = input.nextInt();

        double capacitaBottiglione = 1.5; // Litri
        double costoAlLitro = 1.0; // Euro
        double iva = 0.21; // 21%

        double costoTotaleSenzaIva = numBottiglioni * capacitaBottiglione * costoAlLitro;
        double ivaApplicata = costoTotaleSenzaIva * iva;
        double costoTotaleConIva = costoTotaleSenzaIva + ivaApplicata;

        System.out.println("\nScontrino:");
        System.out.println("Numero di bottiglioni acquistati: " + numBottiglioni);
        System.out.println("Prezzo totale di vendita: " + costoTotaleSenzaIva + " Euro");
        System.out.println("IVA applicata: " + ivaApplicata + " Euro");
        System.out.println("Prezzo di vendita totale comprensivo di IVA: " + costoTotaleConIva + " Euro");

        input.close();
    }
}
