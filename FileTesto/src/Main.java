import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Persona> listaPersone = new ArrayList<>();
        listaPersone.add(new Persona("Leonardo", 45));
        listaPersone.add(new Persona("Leonardo", 45));
        listaPersone.add(new Persona("Leonardo", 45));
        listaPersone.add(new Persona("Leonardo", 45));

        scriviPersona(listaPersone, "persone.csv");

    }

    private static void scriviPersona(ArrayList<Persona> persone, String fileName) {
        ArrayList<String> records = new ArrayList<>();
        try{
           for(Persona currentPersona : persone){
               records.add(currentPersona.toCSV());
           }

            Files.write(Paths.get(fileName), records);

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static ArrayList<Persona> leggiPersona(String fileName) {
        ArrayList<Persona> output = new ArrayList<>();

        try{
            ArrayList<String> linee = (ArrayList<String>)Files.readAllLines(Paths.get(fileName));

            String[] attributi;

            for (String currentLinea : linee){
                attributi=currentLinea.split(";");

                output.add(new Persona(attributi[0], Integer.parseInt(attributi[1])));
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());

        }
        return output;
    }
}
