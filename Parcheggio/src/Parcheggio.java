import java.util.ArrayList;

public class Parcheggio {
    private ArrayList<Auto> parcheggioScoperto;
    private Auto[] parcheggioCoperto;
    private String tipo;
    private int postiOccupatiCoperto;

    // Parcheggio scoperto
    public Parcheggio(String tipo) {
        this.tipo = tipo;
        if (tipo.equals("scoperto")) {
            parcheggioScoperto = new ArrayList<>();
        } else if (tipo.equals("coperto")) {
            parcheggioCoperto = new Auto[10];
            postiOccupatiCoperto = 0;
        }
    }

    // Prenotazione nel parcheggio scoperto
    public boolean prenotaAuto(Auto auto) {
        if (auto.isGpl() && tipo.equals("coperto")) {
            System.out.println("Le auto GPL non possono parcheggiare nel parcheggio coperto.");
            return false;
        }

        // Prenotazione per parcheggio coperto
        if (tipo.equals("coperto")) {
            if (postiOccupatiCoperto >= parcheggioCoperto.length) {
                System.out.println("Il parcheggio coperto è pieno.");
                return false;
            }
            if (auto.isGpl()) {
                System.out.println("Auto GPL non può parcheggiare nel parcheggio coperto.");
                return false;
            }
            parcheggioCoperto[postiOccupatiCoperto++] = auto;
            ordinaParcheggioCoperto();
            return true;
        }

        // Prenotazione per parcheggio scoperto
        if (tipo.equals("scoperto")) {
            parcheggioScoperto.add(auto);
            ordinaParcheggioScoperto();
            return true;
        }

        return false;
    }
    public void ordinaParcheggioCoperto() {
        for (int i = 0; i < postiOccupatiCoperto - 1; i++) {
            for (int j = i + 1; j < postiOccupatiCoperto; j++) {
                if (parcheggioCoperto[i].getPotenzaKw() < parcheggioCoperto[j].getPotenzaKw()) {
                    Auto temp = parcheggioCoperto[i];
                    parcheggioCoperto[i] = parcheggioCoperto[j];
                    parcheggioCoperto[j] = temp;
                }
            }
        }
    }
    public void ordinaParcheggioScoperto(){

    }
}