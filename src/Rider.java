import java.time.LocalDateTime;

public class Rider implements Runnable{
    private int riderNumber;
    @Override
    public void run() {

    }

    // Rider board to bus
    public void boardBus() {
        System.out.printf("Bus Number: %d is departing at %s",  riderNumber, LocalDateTime.now().toString());
    }
}
