import java.time.LocalTime;

public class Cronometro {
    private LocalTime startTime;
    private LocalTime endTime;
    private int tempoGiro;

    public Cronometro(LocalTime startTime, LocalTime endTime, int tempoGiro){
        this.startTime=startTime;
        this.endTime=endTime;
        this.tempoGiro=tempoGiro;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getTempoGiro() {
        return tempoGiro;
    }

    public void setTempoGiro(int tempoGiro) {
        this.tempoGiro = tempoGiro;
    }
    private calcolaTempoGiro(){

    }
}
