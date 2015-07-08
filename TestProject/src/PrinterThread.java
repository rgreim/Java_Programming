/**
 * TestProject
 *
 * @author R.Greim
 * @version 0.1
 */
public class PrinterThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello No. " + i);
            Thread.yield();
        }
    }
}
