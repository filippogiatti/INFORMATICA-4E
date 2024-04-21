package tools;

import java.util.Scanner;

public class utility {
    public static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void Wait(int x)
    {
        try{
            Thread.sleep(1000*x);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public static int menu(String[] opzioni, Scanner keyboard) {
        int scelta = -1; // Inizializziamo scelta con un valore di default

        do {
            ClrScr();
            System.out.println("=== " + opzioni[0] + " ===");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            String input = keyboard.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Input non valido. Riprova.");
                Wait(3);
                continue;
            }
            try {
                scelta = Integer.parseInt(input);
                if (scelta < 1 || scelta > opzioni.length - 1) {
                    System.out.println("Valore errato. Riprova");
                    Wait(3);
                }
            } catch (NumberFormatException e) {
                System.out.println("Input non valido. Riprova.");
                Wait(3);
                // Non è necessario fare nulla qui, scelta rimane -1
            }
        } while (scelta < 1 || scelta > opzioni.length - 1);

        return scelta;
    }
}
