import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Gson Geson = new Gson();
        Persona persona1 = new Persona("gianni", 34);
        Persona persona2 = new Persona("laura", 23);
        Persona persona3 = new Persona("mario", 64);
        Persona persona4 = new Persona("gino", 54);

        ArrayList<Persona> archivio = new ArrayList<Persona>();
        archivio.add(persona1);
        archivio.add(persona2);
        archivio.add(persona3);
        archivio.add(persona4);



        String json = Geson.toJson(persona1);
        System.out.println(json);
        System.out.println(archivio);
        Persona personaFromJson = Geson.fromJson(json, Persona.class);
        System.out.println(personaFromJson.toString());

        Gson Geson2 = new GsonBuilder().setPrettyPrinting().create();
        String jsonContent=Geson2.toJson(archivio);

        try{
            Files.write(Paths.get("archivio.json"), jsonContent.getBytes());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


        try{
            byte[] jsonData=Files.readAllBytes(Path.of("archivio.json"));
            Persona[] collezione=Geson.fromJson(new String(jsonData),Persona[].class);
            ArrayList<Persona> nuovoArchivio2 = new ArrayList<>(Arrays.asList(collezione));
            System.out.println(nuovoArchivio2);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }





        //2 metodo, scrittura, serializzazione
        try{
            FileWriter fileScrivi = new FileWriter("archivio2.json");
            fileScrivi.write(Geson2.toJson(archivio));
            fileScrivi.flush();
            fileScrivi.close();
            System.out.println("Archivio salovato con successo");
        }catch(Exception e){
            System.out.println(e.getMessage());

        }
    }
}
