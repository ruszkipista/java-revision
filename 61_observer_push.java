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
        WeatherStation ws = new WeatherStation("Mz/X Weather Station", measurements);

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
        public void update(Observed<T> observed);
    }
    
    // Observed
    static public class Observed<T> {
        private String name;
        private T state;
        private List<Observer<T>> observers = new ArrayList<>();
        public Observed(String name, T state){
            this.name = name;
            this.state = state;
        }
        public String getName(){
            return this.name;
        }
        public void register(Observer<T> o){
            this.observers.add(o);
        }
        public void remove(Observer<T> o){
            this.observers.remove(o);
        }
        private void notifyObservers(){
            for (Observer<T> observer: this.observers){
                observer.update(this);
            }
        }
        // mutate internal state via external call
        public void updateState(T newState){
            this.state = newState;
            this.notifyObservers();
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
        public WeatherStation(String name, Measurements state){
            super(name, state);
        }
    }

    // one kind of Observer
    static class Display implements Observer<Measurements> {
        @Override
        public void update(Observed<Measurements> observed){
            System.out.println(observed.getName()
                            +": the temperature is " 
                            + observed.state.temperature);
        }
    }
    // other kind of Observer
    static class HeatAlarm implements Observer<Measurements> {
        private double temperatureTreshold;
        public HeatAlarm(double temperatureTreshold){
            this.temperatureTreshold = temperatureTreshold;
        }

        @Override
        public void update(Observed<Measurements> observed){
            if (observed.state.temperature > this.temperatureTreshold)
                System.out.println("Alarm! The temperature has risen above "
                                    +this.temperatureTreshold);
        }
    }

}
