import java.util.Random;

public class BusGenerator implements Runnable {
    private BoardingArea boardingArea;
    private float mean = 2 * 60f * 1000;
    public static Random random;

    public BusGenerator(BoardingArea boardingArea) {
        this.boardingArea = boardingArea;
        random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                float l = 1 / mean;
                Thread.sleep(Math.round(-Math.log(1 - random.nextFloat()) / l));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(new Bus(boardingArea)).start();
        }
    }
}
