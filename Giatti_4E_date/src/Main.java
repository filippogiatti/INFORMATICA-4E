import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        LocalDate dataLocale= LocalDate.now();
        System.out.println("Data: "+dataLocale.toString());
        //------------------------------------------------------------------
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Data 2: "+dataLocale.format(dt));
        System.out.printf("Data 3: %s"+"\n", dataLocale.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        //------------------------------------------------------------------
        String dataString= dataLocale.format(dt);
        dataLocale=LocalDate.parse(dataString, dt);
        System.out.println("Data: "+dataLocale);
        //---------------------------------------------------------------------
        /*System.out.println("Inserire data (gg-MM-aaaa");
        String dataInput=keyboard.nextLine();
        LocalDate dataNew= LocalDate.parse(dataInput, dt);
        System.out.println("Data 5: "+dataNew);*/
        String timeString="10:32:00";
        LocalTime ora= LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("Ora: "+ora);
        //--------------------------------------------------------------------
        dataLocale=LocalDate.of(2024,10, 8);
        int anno, mese, giorno;
        anno=dataLocale.getYear();
        mese=dataLocale.getMonthValue();
        giorno=dataLocale.getDayOfMonth();
        System.out.println("Data: "+anno+"/"+mese+"/"+giorno+"giorni mese "+dataLocale.lengthOfMonth());
        if(dataLocale.isLeapYear()){
            System.out.println("Bisestile");
        }
        LocalDate dataCompare= LocalDate.now();
        if(dataCompare.equals(LocalDate.now())){
            System.out.println("Le date sono uguali");
        }


    }
}