package design.patterns.observer;
//Tener que implementar el observer en distintas classes
public abstract class Observer {
    protected Subject subject;

    public abstract void update(Message m);
}
