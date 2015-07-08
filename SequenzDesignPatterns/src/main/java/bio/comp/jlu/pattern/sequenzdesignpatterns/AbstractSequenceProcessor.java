
package bio.comp.jlu.pattern.sequenzdesignpatterns;

import java.util.LinkedList;
import java.util.List;

/**
 * Class that manages observers.
 * @author rgreim
 */
public abstract class AbstractSequenceProcessor implements SequenceProcessor {

    private final List<Observer> observerList = new LinkedList<>();

    public void addObserver(Observer o1) {
        observerList.add(o1);
    }

    public void delObserver(Observer o1) {
        observerList.remove(o1);
    }

    protected void notifyObservers() {
        for (Observer obs : observerList) {
            obs.update(this);
        }
    }

    @Override
    public final void processSequence(String str) {
        process(str);
        notifyObservers();
    }

    protected abstract void process(String str);
}

