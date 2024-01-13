package Race;

public class Track {
    private int finishedRacers;

    public Track() {
        this.finishedRacers = 1;
    }

    public synchronized int getFinishedRacers(){
        return this.finishedRacers;
    }

    public synchronized void setFinishedRacers(){
        this.finishedRacers++;
    }


}
