package eu.telecomnancy.rpg.observer;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObservableTest {
    @Test
    void testObservable() {
        ConcreteObservable observable = new ConcreteObservable();
        ConcreteObserver observer = new ConcreteObserver();

        observable.callNotify();
        assertEquals(0, observer.timesNotified);

        observable.attach(observer);
        observable.callNotify();
        assertEquals(1, observer.timesNotified);

        observable.detach(observer);
        observable.callNotify();
        assertEquals(1, observer.timesNotified);
    }

    static class ConcreteObservable implements Observable {
        public void callNotify() {
            notifyObservers();
        }

        final Set<Observer> observers;

        public ConcreteObservable() {
            observers = new HashSet<>();
        }

        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(this);
            }
        }

        public void attach(Observer observer) {
            observers.add(observer);
        }

        public void detach(Observer observer) {
            observers.remove(observer);
        }
    }

    static class ConcreteObserver implements Observer {
        public int timesNotified;

        ConcreteObserver() {
            timesNotified = 0;
        }

        @Override
        public void update(Observable observable) {
            timesNotified++;
        }
    }

}