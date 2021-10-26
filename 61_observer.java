import java.util.ArrayList;
import java.util.List;

class Observer_pattern {
    public static void main(String[] args) {
        // create Observed
        WeatherStation station = new WeatherStation("Mz/X Weather Station");
        // create Observer1
        Display lcdscreen = new Display();
        // sign up for updates from station
        station.register(lcdscreen);
        // create Observer1
        HeatAlarm gauge = new HeatAlarm(25);
        // sign up for updates from station
        station.register(gauge);
        // mutate Observed
        station.measureTemperature(20.1);
        // mutate Observed
        station.measureTemperature(25.5);
    }
    
    // INTERFACE: Observer
    interface IObserver <T extends IObserved>{
        public void update(T observed);
    }
    
    // Abstract Class: Observed
    public static abstract class IObserved{
        private List<IObserver> observers = new ArrayList<IObserver>();

        public void register(IObserver o){
            this.observers.add(o);
        }
        public void unregister(IObserver o){
            this.observers.remove(o);
        }
        private void notifyObservers(){
            for (IObserver observer: observers){
                observer.update(this);
            }
        }
    }

    static class WeatherStation extends IObserved{
        private double temperature;
        private String name;
        
        public WeatherStation(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }

        // mutate internal state
        public void measureTemperature(double temperature){
            this.temperature = temperature;
            super.notifyObservers();
        }
        public double getTemperature(){
            return this.temperature;
        }
    }

    // one type of observer
    static class Display implements IObserver<WeatherStation>{
        @Override
        public void update(WeatherStation observed){
            System.out.println(observed.getName() +
                               ": the temperature is " + observed.getTemperature());
        }
    }

    // other type of observer
    static class HeatAlarm implements IObserver<WeatherStation>{
        private double treshold;

        public HeatAlarm(double treshold){
            this.treshold = treshold;
        }

        @Override
        public void update(WeatherStation ws){
            if (ws.getTemperature() > this.treshold){
                System.out.println("Alarm! The temperature has risen above "+this.treshold);
            }
        }
    }
}