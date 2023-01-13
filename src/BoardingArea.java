import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class BoardingArea {
    private static final int RIDERS_ALLOWED = 50;
    private Semaphore allAboard; // Bus wait until everyone is boarded
    private Semaphore bus; // This get signaled when the bus is arrived
    private Semaphore mutex; // Protect rider count
    // Contain the waiting riders in the boarding area
    private ArrayList<Rider> waitingRiders = new ArrayList<>();

    /**
     * Rider enters to the boarding area
     * When a bus has arrived to the boarding area riders can not enter to the
     * boarding area
     * @param rider
     * @throws InterruptedException
     */
    public void enterBoardingArea(Rider rider) throws InterruptedException {
        
    }
}
