public class Auto {
    private double potenzaKw;
    private double valore;
    private boolean isGpl;
    private boolean isVip;

    public Auto(double potenzaKw, double valore, boolean isGpl, boolean isVip) {
        this.potenzaKw = potenzaKw;
        this.valore = valore;
        this.isGpl = isGpl;
        this.isVip = isVip;
    }

    public double getPotenzaKw() {
        return potenzaKw;
    }

    public double getValore() {
        return valore;
    }

    public boolean isGpl() {
        return isGpl;
    }
}

