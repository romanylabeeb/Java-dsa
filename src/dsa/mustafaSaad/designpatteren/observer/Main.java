package dsa.mustafaSaad.designpatteren;

import java.util.ArrayList;
import java.util.List;

//1. Define a Subject Interface
interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

//2. Create a Concrete Subject
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    public int getState() {
        return state;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
}

//3. Define an Observer Interface
interface Observer {
    void update();
}

// 4. Create Concrete Observers
class ConcreteObserver implements Observer {
    private ConcreteSubject subject;
    private int observerState;

    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update() {
        observerState = subject.getState();
        System.out.println("Observer state updated to: " + observerState);
    }
}

//5. Use the Pattern
public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver(subject);
        ConcreteObserver observer2 = new ConcreteObserver(subject);

        subject.setState(10); // Output: Observer state updated to: 10 (twice)
        subject.setState(20); // Output: Observer state updated to: 20 (twice)
    }
}
