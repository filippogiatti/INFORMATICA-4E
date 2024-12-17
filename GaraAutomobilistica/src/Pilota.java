public class Pilota {
    private String nome;
    private String cognome;
    private String nazionalita;

    public Pilota(String nome, String cognome, String nazionalita) {
        this.nome=nome;
        this.cognome=cognome;
        this.nazionalita=nazionalita;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }
    public boolean equals(Pilota altro){
       boolean uguale=false;
       if(this.getNome().equals(altro.getNome()) && this.getCognome().equals(altro.getCognome())&&this.getNazionalita().equals(altro.getNazionalita())){
           uguale=true;
       }
       return uguale;
    }
    public String toString(){
        return "\nPilota "+nome+" "+cognome+" "+nazionalita;
    }
}
