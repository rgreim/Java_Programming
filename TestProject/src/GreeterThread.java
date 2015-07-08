/**
 * TestProject
 *
 * @author R.Greim
 * @version 0.1
 */
public class GreeterThread extends Thread{
    private Thread threadToGreet;

    public GreeterThread(Thread threadToGreet) {
        this.threadToGreet = threadToGreet;
    }

    @Override
    public void run() {
        for (int i = 0; threadToGreet.isAlive() ; i++) {
            System.out.println("Hello little Thread! No. " + i);
            Thread.yield();
        }
        System.out.println("Thread is dead now. So am I, kthxbye.");
    }
}
