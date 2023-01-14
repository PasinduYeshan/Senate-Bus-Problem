import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;

public class Bus implements Runnable{
    private BoardingArea boardingArea;
    private int loaded;

    public Bus(BoardingArea boardingArea) {
        this.boardingArea = boardingArea;
    }
    @Override
    public void run() {
        try {
            boardingArea.getMutex().acquire(); // Lock the mutex, so new riders can't come when the bus is arrived
                arrive();
                boardingArea.getBus().release(); // Signal riders that the bus has arrived
                boardingArea.getAllAboard().acquire(); // Wait until all the riders are onboarded
                depart();
            boardingArea.getMutex().release();
        } catch (InterruptedException error) {
            error.printStackTrace();
        }

    }

    // Bus depart from the boarding area
    private void depart() {
        System.out.printf("Bus loaded with %d riders and %d are waiting\n" , loaded, boardingArea.getWaitingRiders());
        System.out.printf("Bus Number: %d is departing at %s\n",  Thread.currentThread().getId(), LocalDateTime.now().toString());
//        System.out.printf("%d riders are loaded to the bus", this.waitingRiders);
    }

    // Bus arrive to the boarding area
    private void arrive() {
        System.out.printf("Bus Number: %d arrived at %s\n", Thread.currentThread().getId(), LocalDateTime.now().toString());
        System.out.printf("%d riders are waiting in the queue\n", boardingArea.getWaitingRiders());
        boardingArea.setCurrentBus(this);
    }

    public int getLoaded() {
        return this.loaded;
    }

    public void incLoaded() {
        this.loaded += 1;
    }


}
