package Race;

public class Racer implements Runnable {
    private static int globalid = 1;
    private int id;
    private int speed;
    private Track track;

    public Racer(int speed, Track track){
        if(speed < 1 || speed > 10){
            System.out.println("Error: speed must be between 1 and 10");
        }
        this.speed = speed;
        this.id = globalid++;
        this.track = track;
    }

    public void go(){
        Thread.currentThread().setPriority(speed);

        for(int i=1; i<=100;i++){
            System.out.println("Runner " + id + " Ran " + i + " Meters");

            if(i==100){
                int finished = track.getFinishedRacers();
                System.out.println("Runner " + id + " finished " + getPlace());
                track.setFinishedRacers();
            }
            try {
                Thread.sleep((11-speed) * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private String getPlace(){
        int finished = track.getFinishedRacers();
        if (finished == 1) {
            return "1st";
        } else if (finished == 2) {
            return "2nd";
        } else if (finished == 3) {
            return "3rd";
        } else {
            return finished + "th";
        }
    }

    @Override
    public void run() {
        go();
    }
}


