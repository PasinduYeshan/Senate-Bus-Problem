import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class BoardingArea {
    public static final int RIDERS_ALLOWED = 50;
    private Semaphore allAboard; // Bus wait until everyone is boarded
    private Semaphore bus; // This get signaled when the bus is arrived
    private Semaphore mutex; // Protect rider count
    // Contain the waiting riders in the boarding area
    private int waitingRiders;
    private Bus currentBus;

    public BoardingArea() {
        this.allAboard = new Semaphore(0);
        this.bus = new Semaphore(0);
        this.mutex = new Semaphore(1);
        this.waitingRiders = 0;
    }

    public Semaphore getAllAboard() {
        return this.allAboard;
    }

    public Semaphore getBus() {
        return this.bus;
    }

    public Semaphore getMutex() {
        return this.mutex;
    }

    public int getWaitingRiders() {
        return waitingRiders;
    }

    public void incWaitingRiders() {
        this.waitingRiders += 1;
    }

    public void decWaitingRiders() {
        this.waitingRiders -= 1;
    }

    public void setCurrentBus(Bus bus){
        this.currentBus = bus;
    }

    public Bus getCurrentBus() {
        return this.currentBus;
    }
}
