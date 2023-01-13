import java.util.Random;

public class RiderGenerator implements Runnable {

    private float mean = 3f * 1000;
    public static Random random;
    private BoardingArea boardingArea;

    public RiderGenerator(BoardingArea boardingArea) {
        random = new Random();
        this.boardingArea = boardingArea;
    }

    @Override
    public void run() {
        while (true) {
            new Thread(new Rider(boardingArea)).start();
            try {
                float l = 1 / mean;
                Thread.sleep(Math.round(-Math.log(1 - random.nextFloat()) / l));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
