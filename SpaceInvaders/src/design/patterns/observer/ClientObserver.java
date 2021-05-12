package design.patterns.observer;

public class ClientObserver extends Observer {

    public ClientObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
        this.subject.detach(this);

    }

    @Override
    public void update(Message m) {
    }
}
