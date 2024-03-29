package eu.telecomnancy.rpg.observer;

import eu.telecomnancy.rpg.character.BaseCharacter;
import eu.telecomnancy.rpg.visitor.CharacterVisitor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObservableTest {
    @Test
    void testObservable() {
        ConcreteObservable observable = new ConcreteObservable("ex");
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

    static class ConcreteObservable extends BaseCharacter {
        public ConcreteObservable(String name) {
            super(name);
        }

        public void callNotify() {
            notifyObservers();
        }

        @Override
        public void accept(CharacterVisitor V) {

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