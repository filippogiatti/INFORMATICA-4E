import java.util.Scanner;
public class MorraCinese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char giocatore1 = 0;
        char giocatore2 = 0;
        int controllo1 = 0;
        int controllo2 = 0;
        char scelta = 'S';


        do {
            do {
                System.out.println("Giocatore 1: Inserisci A per carta, S per sasso, D per forbici, o X per uscire");
                giocatore1 = scanner.next().charAt(0);

                if (giocatore1 == 'X' || giocatore1 == 'x')
                    controllo1 = 2;

                else if (giocatore1== 'A' || giocatore1 == 'a' ||
                        giocatore1 == 'S' || giocatore1 == 's' ||
                        giocatore1 == 'D' || giocatore1 == 'd')
                {
                    do {
                        System.out.println("Giocatore 2: Inserisci J per carta, K per sasso, L per forbici, o X per uscire");
                        giocatore2 = scanner.next().charAt(0);

                        if (giocatore2 == 'X' || giocatore2 == 'x')
                            controllo2 = 2;

                        else if (giocatore2 == 'J' || giocatore2 == 'j' ||
                                giocatore2 == 'K' || giocatore2 == 'k' ||
                                giocatore2 == 'L' || giocatore2 == 'l')
                            controllo2 = 1;

                        else
                            System.out.println("Input non valido per il Giocatore 2. Riprova");

                    } while (controllo2 == 0);

                    controllo1 = 1;
                }

                else
                    System.out.println("Input non valido per il Giocatore 1. Riprova");

            } while (controllo1 == 0);

            if (controllo1 == 2 || controllo2 == 2) {
                System.out.println("Gioco terminato. Vuoi giocare ancora? S/N");
                scelta = scanner.next().charAt(0);
            }

            else {
                if (giocatore1 == 'A' || giocatore1 == 'a') {
                    if (giocatore2 == 'J' || giocatore2 == 'j') {
                        System.out.println("Pareggio! Vuoi giocare ancora? S/N");
                        scelta = scanner.next().charAt(0);
                    }

                    else if (giocatore2 == 'K' || giocatore2 == 'k') {
                        System.out.println("Giocatore 1 hai vinto! Vuoi giocare ancora? S/N");
                        scelta = scanner.next().charAt(0);
                    }

                    else if (giocatore2 == 'L' || giocatore2 == 'l') {
                        System.out.println("Giocatore 2 hai vinto! Vuoi giocare ancora? S/N");
                        scelta = scanner.next().charAt(0);
                    }
                }

                if (giocatore1 == 'S' || giocatore1 == 's') {
                    if (giocatore2 == 'J' || giocatore2 == 'j') {
                        System.out.println("Giocatore 2 hai vinto! Vuoi giocare ancora? S/N");
                        scelta = scanner.next().charAt(0);
                    }

                    else if (giocatore2 == 'K' || giocatore2 == 'k') {
                        System.out.println("Pareggio! Vuoi giocare ancora? S/N");
                        scelta = scanner.next().charAt(0);
                    }

                    else if (giocatore2 == 'L' || giocatore2 == 'l') {
                        System.out.println("Giocatore 1 hai vinto! Vuoi giocare ancora? S/N");
                        scelta = scanner.next().charAt(0);
                    }
                }

                if (giocatore1 == 'D' || giocatore1 == 'd') {
                    if (giocatore2 == 'J' || giocatore2 == 'j') {
                        System.out.println("Giocatore 1 hai vinto! Vuoi giocare ancora? S/N");
                        scelta = scanner.next().charAt(0);
                    }

                    else if (giocatore2 == 'K' || giocatore2 == 'k') {
                        System.out.println("Giocatore 2 hai vinto! Vuoi giocare ancora? S/N");
                        scelta = scanner.next().charAt(0);
                    }

                    else if (giocatore2 == 'L' || giocatore2 == 'l') {
                        System.out.println("Pareggio! Vuoi giocare ancora? S/N");
                        scelta = scanner.next().charAt(0);
                    }
                }
            }


        }while (scelta == 'S' || scelta == 's');

    }
}