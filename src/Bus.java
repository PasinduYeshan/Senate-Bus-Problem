import java.time.LocalDateTime;

public class Bus implements Runnable{
    private int busNumber;

    public Bus(int busNumber) {
        this.busNumber = busNumber;
    }
    @Override
    public void run() {

    }

    // Bus depart from the boarding area
    public void depart() {
        System.out.printf("Bus Number: %d is departing at %s",  busNumber, LocalDateTime.now().toString());
    }


}
