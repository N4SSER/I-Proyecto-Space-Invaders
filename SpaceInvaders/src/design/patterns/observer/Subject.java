package design.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    //Obtener los datos state y actualizar
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }


    //Metodos principales attach, detach y NotifyAllObservers
    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }


    @Override
    public void notifyAllObservers(Message m) {
        for (Observer observer : observers) {
            observer.update(m);
        }
    }
}
