import java.util.ArrayList;
import java.util.List;

class Observer_pattern {
/*
The Observer pattern keeps your objects in the know when something they care about happens.
*/    
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
    interface IObserver <T>{
        public void update(IObserved<T> observed);
    }
    
    // Abstract Class: Observed
    public static abstract class IObserved<K> {
        private List<IObserver<K>> observers = new ArrayList<>();

        public void register(IObserver<K> o){
            this.observers.add(o);
        }
        public void unregister(IObserver<K> o){
            this.observers.remove(o);
        }

        private void notifyObservers(){
            for (IObserver<K> observer: observers){
                observer.update(this);
            }
        }
    }

    static class WeatherStation extends IObserved<Double> {
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

    // one kind of observer
    static class Display implements IObserver<Double> {
        @Override
        public void update(IObserved<Double> observed){
            if(observed instanceof WeatherStation) {
                WeatherStation ws = (WeatherStation) observed;
                System.out.println(ws.getName()+": the temperature is " + ws.getTemperature());
            }
        }
    }

    // other kind of observer
    static class HeatAlarm implements IObserver<Double> {
        private double treshold;

        public HeatAlarm(double treshold){
            this.treshold = treshold;
        }

        @Override
        public void update(IObserved<Double> observed){
            if(observed instanceof WeatherStation) {
                WeatherStation ws = (WeatherStation) observed;
                System.out.println(ws.getName()+": the temperature is " + ws.getTemperature());
                if (ws.getTemperature() > this.treshold){
                    System.out.println("Alarm! The temperature has risen above "+this.treshold);
                }
            }
        }
    }
}