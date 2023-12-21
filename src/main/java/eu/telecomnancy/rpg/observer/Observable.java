package eu.telecomnancy.rpg.observer;

import java.util.HashSet;
import java.util.Set;

public abstract class Observable {

    Set<Observer> observers;

    public Observable() {
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
