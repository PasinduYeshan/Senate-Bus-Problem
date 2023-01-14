import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        BoardingArea boardingArea = new BoardingArea();

        Thread busGenerator = new Thread(new BusGenerator(boardingArea));
        Thread riderGenerator = new Thread(new RiderGenerator(boardingArea));

        busGenerator.start();
        riderGenerator.start();

        try {
            busGenerator.join();
            riderGenerator.join();
        } catch (InterruptedException error) {
            error.printStackTrace();
        }
    }


}