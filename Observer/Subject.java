import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    List<Observer> observers = new ArrayList<Observer>();

    void add(Observer o) {
        observers.add(o);
    }
    void remove(Observer o) {
        observers.remove(o);
    }

    void notif(Flight _flight) {
        for (Observer o : observers) {
            o.update(_flight);
        }
    }
}
