import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;
import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * TestProject
 *
 * @author R.Greim
 * @version 0.1
 */
public class Main {
    public static void main(String[] args) {
        Thread printer = new PrinterThread();
        Thread greeter = new GreeterThread(printer);
        printer.start();
        greeter.start();
    }
}
