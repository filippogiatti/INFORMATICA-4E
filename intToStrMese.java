public class giatti_gestioneData2_3E {
    public static void main(String[] args) {

// Metodo per convertire il nome del mese in numero
        private static int intToStrMese (String mese){
            // Array contenente i nomi dei mesi
            String[] mesi = {"GENNAIO", "FEBBRAIO", "MARZO", "APRILE", "MAGGIO", "GIUGNO", "LUGLIO", "AGOSTO", "SETTEMBRE", "OTTOBRE", "NOVEMBRE", "DICEMBRE"};

            // Converte il nome del mese in maiuscolo e prova a ottenere il corrispondente numero
            for (int i = 0; i < mesi.length; i++) {
                if (mesi[i].equalsIgnoreCase(mese)) {
                    return i + 1; // L'indice del mese + 1 corrisponde al numero del mese
                }
            }

            // Se il nome del mese non è valido, restituisce -1
            return -1;
        }
    }
}