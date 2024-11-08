import java.util.ArrayList;
import java.util.List;

public class Persona {
    private int biglietto;
    private List<GiostraProvata> giostreProvate;

    public Persona(int biglietto) {
        this.biglietto = biglietto;
        this.giostreProvate = new ArrayList<>();
    }

    public int getBiglietto() {
        return biglietto;
    }

    public List<GiostraProvata> getGiostreProvate() {
        return giostreProvate;
    }

    public void provaGiostra(String giostra, String orario) {
        giostreProvate.add(new GiostraProvata(giostra, orario));
        System.out.println("Persona con biglietto " + biglietto + " ha provato la giostra " + giostra + " alle " + orario + ".");
    }

    public void resetGiostreProvate() {
        giostreProvate.clear(); // Svuota la lista delle giostre provate quando la persona lascia il parco
    }
}
