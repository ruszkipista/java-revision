import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

class Observer_pull_pattern_with_subscription {
/*
The Observer pattern keeps your objects in the know when something they care about happens.
The Observer Pattern defines a one-to-many dependency between objects, so that when one object changes state,
all of its dependents are notified and updated automatically.
This pull variation adds possibility for observers to subscribe to selected (update) events.
*/    
    public static void main(String[] args) {
        // create data container
        Measurements measurements = new Measurements();

        // create Observed
        WeatherStation ws = new WeatherStation("Mz/X Weather Station", measurements);

        // create Observer1
        Display lcdscreen = new Display();
        // sign up for updates from observed
        ws.register(lcdscreen, Topics.TEMPERATURE);
        
        // create Observer2
        HeatAlarm gouge = new HeatAlarm(25.0);
        // sign up for updates from observed
        ws.register(gouge, Topics.TEMPERATURE);

        measurements.updateTemperature(20.1);
        // mutate Observed
        ws.updateState(measurements);
        // no observer update expected because lack of subscription
        measurements.updateAirPressure(1500);
        ws.updateState(measurements);

        measurements.updateTemperature(25.2);
        // mutate Observed
        ws.updateState(measurements);
    }

    // interfaces / abstract classes
    // ===============================

    // Observer
    interface Observer<T extends State<E>,E extends Enum<E>> {
        public void update(Observed<T,E> observed);
    }
    
    // Observed
    static public class Observed<T extends State<E>,E extends Enum<E>>  {
        private String name;
        private T state;
        private List<Subscription> subscriptions = new ArrayList<>();
        public Observed(String name, T state){
            this.name = name;
            this.state = state;
        }
        public String getName(){
            return this.name;
        }
        private class Subscription{
            public Observer<T,E> observer;
            public EnumSet<E> topics;
            @SafeVarargs
            public Subscription(Observer<T,E> observer, E... topics){
                this.observer = observer;
                this.topics = EnumSet.copyOf(Arrays.asList(topics));
            }
        }
        @SafeVarargs
        public final void register(Observer<T,E> observer, E... topics){
            this.subscriptions.add(new Subscription(observer,topics));
        }
        public void remove(Observer<T,E> observer){
            for (Subscription subscription: this.subscriptions){
                if (subscription.observer == observer){
                    this.subscriptions.remove(subscription);
                    break;
                }
            }
        }
        private void notifySubscriptions(){
            EnumSet<E> updatedTopics = state.getUpdatedTopics();
            for (Subscription subscription: this.subscriptions){
                for(Enum<E> updatedTopic:updatedTopics)
                    if (subscription.topics.contains(updatedTopic)){
                        subscription.observer.update(this);
                        break;
                    }
            }
            state.clearUpdatedTopics();
        }
        // mutate internal state via external call
        public void updateState(T newState){
            this.state = newState;
            this.notifySubscriptions();
        }
    }

    // State
    static abstract class State<E extends Enum<E>>{
        private EnumSet<E> updatedTopics;
        public EnumSet<E> getUpdatedTopics(){
            return this.updatedTopics;
        }
        public void clearUpdatedTopics(){
            this.updatedTopics.clear();
        }
    }

    // concrete classes
    // =================
    static public enum Topics{ TEMPERATURE, AIRPRESSURE }

    // Measurements
    static class Measurements extends State<Topics>{
        private double temperature;
        private double airPressure;
        public Measurements(){
            super.updatedTopics = EnumSet.noneOf(Topics.class);
        }

        public void updateTemperature(double temperature){
            if (this.temperature != temperature){
                this.temperature = temperature;
                super.updatedTopics.add(Topics.TEMPERATURE);
            } else super.updatedTopics.remove(Topics.TEMPERATURE);
        }

        public void updateAirPressure(double airPressure){
            if (this.airPressure != airPressure){
                this.airPressure = airPressure;
                super.updatedTopics.add(Topics.AIRPRESSURE);
            } else super.updatedTopics.remove(Topics.AIRPRESSURE);
        }
    }

    // Observed
    static class WeatherStation extends Observed<Measurements,Topics> {
        public WeatherStation(String name, Measurements state){
            super(name, state);
        }
    }

    // one kind of Observer
    static class Display implements Observer<Measurements,Topics> {
        @Override
        public void update(Observed<Measurements,Topics> observed){
            System.out.println(observed.getName()
                            +": the temperature is "
                            + observed.state.temperature
                            + ", air pressure is "
                            + observed.state.airPressure);
        }
    }
    // other kind of Observer
    static class HeatAlarm implements Observer<Measurements,Topics> {
        private double temperatureTreshold;
        public HeatAlarm(double temperatureTreshold){
            this.temperatureTreshold = temperatureTreshold;
        }

        @Override
        public void update(Observed<Measurements,Topics> observed){
            if (observed.state.temperature > this.temperatureTreshold)
                System.out.println("Alarm! The temperature has risen above "
                                    +this.temperatureTreshold);
        }
    }

}
