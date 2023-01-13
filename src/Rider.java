import java.time.LocalDateTime;

public class Rider implements Runnable{
    private BoardingArea boardingArea;

    public  Rider(BoardingArea boardingArea) {
        this.boardingArea = boardingArea;
    }
    @Override
    public void run() {

    }

    // Rider board to bus
    public void boardBus() {
        System.out.printf("Bus Number: %d is departing at %s",  1, LocalDateTime.now().toString());
    }
}
