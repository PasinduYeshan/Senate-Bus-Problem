import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;

public class Rider implements Runnable{
    private BoardingArea boardingArea;

    public int waitingRiders;
    public  Rider(BoardingArea boardingArea) {
        this.boardingArea = boardingArea;
    }
    @Override
    public void run() {
        try {
            boardingArea.getMutex().acquire(); // Protect waiting riders count
                enteringToBoardingArea();
            boardingArea.getMutex().release();

            boardingArea.getBus().acquire(); // Wait until bus is arrived
                boardBus();
            if (boardingArea.getCurrentBus().getLoaded() == 50 || boardingArea.getWaitingRiders() == 0) {
                boardingArea.getAllAboard().release();
            } else {
                boardingArea.decWaitingRiders();
                boardingArea.getCurrentBus().incLoaded();
                boardingArea.getBus().release();
            }

        } catch (InterruptedException error) {
            error.printStackTrace();
        }
    }

    private void boardBus() {
        System.out.printf("Rider: %s is boarding to bus\n", Thread.currentThread().getId());
    }

    private void enteringToBoardingArea() {
        System.out.printf("Rider: %s  came to boarding area.\n", Thread.currentThread().getId());
        boardingArea.incWaitingRiders(); // Increment waiting rider count
    }
}
