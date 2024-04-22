public class Main{
    public static void main(String args[]){
        /*String linea="La mamma va al mercato a comprare i pomodori";
        String linea2="GINO,MARIA,GIOVANNI";
        String[] nome;
        String[] parole=linea.split(" ");
        for(String i:parole){
            System.out.println(i+"\n");
        }
        nome=linea.split(",");
        for(String i:nome){
            System.out.println(i+"\n");
        }*/

        String s1="b", s2="a";
        s1.compareTo(s2);
        if(s1.compareTo(s2)>0){
            System.out.println("s1 è maggiore di s2");
        }else if(s1.compareTo(s2)<0){
            System.out.println("s2 è maggiore di s1");
        }else{
            System.out.println("Le stringhe sono pari");
        }
    }

}
