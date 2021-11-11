import java.util.ArrayList;
import java.util.List;

class Observer_push_pattern {
/*
The Observer pattern keeps your objects in the know when something they care about happens.
The Observer Pattern defines a one-to-many dependency between objects
so that when one object changes state, all of its dependents are notified and updated automatically.
*/    
    public static void main(String[] args) {
        Measurements measurements = new Measurements();

        // create Observed
        WeatherStation ws = new WeatherStation();

        // create Observer1
        Display lcdscreen = new Display();
        // sign up for updates from observed
        ws.register(lcdscreen);
        
        // create Observer2
        HeatAlarm gouge = new HeatAlarm(25.0);
        // sign up for updates from observed
        ws.register(gouge);

        measurements.temperature = 20.1;
        // mutate Observed
        ws.updateState(measurements);

        measurements.temperature = 25.5;
        // mutate Observed
        ws.updateState(measurements);
    }

    // interfaces
    // ===========
    // Observer
    interface Observer<T> {
        public void update(T data);
    }
    
    // Observed
    static public class Observed<T> {
        private List<Observer<T>> observers = new ArrayList<>();
        
        public void register(Observer<T> o){
            this.observers.add(o);
        }
        public void remove(Observer<T> o){
            this.observers.remove(o);
        }
        private void notifyObservers(T newState){
            for (Observer<T> observer: this.observers){
                observer.update(newState);
            }
        }
        // mutate (virtual) internal state via external call
        public void updateState(T newState){
            this.notifyObservers(newState);
        }
    }

    // concrete classes
    // =================

    // State
    static class Measurements{
      public double temperature;
    }

    // Observed
    static class WeatherStation extends Observed<Measurements> {
    }

    // one kind of Observer
    static class Display implements Observer<Measurements> {
        @Override
        public void update(Measurements data){
            System.out.println("The temperature is " + data.temperature);
        }
    }
    // other kind of Observer
    static class HeatAlarm implements Observer<Measurements> {
        private double temperatureTreshold;
        public HeatAlarm(double temperatureTreshold){
            this.temperatureTreshold = temperatureTreshold;
        }

        @Override
        public void update(Measurements data){
            if (data.temperature > this.temperatureTreshold)
                System.out.println("Alarm! The temperature has risen above "
                                    +this.temperatureTreshold);
        }
    }

}
