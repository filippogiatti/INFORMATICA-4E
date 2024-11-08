import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LunaPark {
    private final int capacitaMax;
    private final List<Persona> personeNelParco;
    private int ultimoBiglietto = 0;

    public LunaPark(int capacitaMax) {
        this.capacitaMax = capacitaMax;
        this.personeNelParco = new ArrayList<>();
    }

    public boolean entraPersona() {
        if (personeNelParco.size() < capacitaMax) {
            Persona nuovaPersona = new Persona(++ultimoBiglietto);
            personeNelParco.add(nuovaPersona);
            System.out.println("Persona con biglietto " + nuovaPersona.getBiglietto() + " è entrata.");
            return true;
        } else {
            System.out.println("Capacità massima raggiunta. Non è possibile far entrare altre persone.");
            return false;
        }
    }

    public boolean esciPersona(int biglietto) {
        Optional<Persona> persona = trovaPersona(biglietto);
        if (persona.isPresent()) {
            persona.get().resetGiostreProvate();
            personeNelParco.remove(persona.get());
            System.out.println("Persona con biglietto " + biglietto + " è uscita dal parco.");
            return true;
        }
        System.out.println("Persona con biglietto " + biglietto + " non trovata nel parco.");
        return false;
    }

    public Optional<Persona> trovaPersona(int biglietto) {
        return personeNelParco.stream().filter(p -> p.getBiglietto() == biglietto).findFirst();
    }

    public void personaProvaGiostra(int biglietto, String giostra, String orario) {
        Optional<Persona> persona = trovaPersona(biglietto);
        if (persona.isPresent()) {
            persona.get().provaGiostra(giostra, orario);
        } else {
            System.out.println("Persona con biglietto " + biglietto + " non trovata nel parco.");
        }
    }

    public void visualizzaGiostreProvate(int biglietto) {
        Optional<Persona> persona = trovaPersona(biglietto);
        if (persona.isPresent()) {
            List<GiostraProvata> giostre = persona.get().getGiostreProvate();
            if (giostre.isEmpty()) {
                System.out.println("La persona con biglietto " + biglietto + " non ha provato nessuna giostra.");
            } else {
                System.out.println("Giostre provate dalla persona con biglietto " + biglietto + ":");
                for (GiostraProvata g : giostre) {
                    System.out.println("- " + g.getNomeGiostra() + " alle " + g.getOrario());
                }
            }
        } else {
            System.out.println("Persona con biglietto " + biglietto + " non trovata nel parco.");
        }
    }
}
