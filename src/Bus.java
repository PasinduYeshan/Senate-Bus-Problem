import java.time.LocalDateTime;

public class Bus implements Runnable{
    private BoardingArea boardingArea;

    public Bus(BoardingArea boardingArea) {
        this.boardingArea = boardingArea;
    }
    @Override
    public void run() {

    }

    // Bus depart from the boarding area
    public void depart() {
        System.out.printf("Bus Number: %d is departing at %s",  1, LocalDateTime.now().toString());
    }


}
