import java.util.ArrayList;
import java.util.List;

class Observer_pattern {
/*
The Observer pattern keeps your objects in the know when something they care about happens.
The Observer Pattern defines a one-to-many dependency between objects
so that when one object changes state, all of its dependents are notified and updated automatically.
*/    
    public static void main(String[] args) {
        Double state=0d;
        // create Observed
        Observed observed = new Observed(state);

        // create Observer1
        Observer1 observer1 = new Observer1();
        // sign up for updates from observed
        observed.register(observer1);
        
        // create Observer2
        Observer2 observer2 = new Observer2();
        // sign up for updates from observed
        observed.register(observer2);

        // mutate Observed
        observed.updateState(20.1);
        // mutate Observed
        observed.updateState(25.5);
    }

    // INTERFACE: Observer
    interface IObserver{
        public void update(IObserved observed);
    }
    
    // INTERFACE: Observed
    interface IObserved {
        public void register(IObserver o);
        public void remove(IObserver o);
        public void notifyObservers();
        public void updateState(Object state);
        public Object getState();
    }

    static class Observed implements IObserved {
        private Object state;
        private List<IObserver> observers = new ArrayList<>();
        
        public Observed(Object state){
            this.state = state;
        }

        public void register(IObserver o){
            this.observers.add(o);
        }
        public void remove(IObserver o){
            this.observers.remove(o);
        }
        public void notifyObservers(){
            for (IObserver observer: this.observers){
                observer.update(this);
            }
        }

        // mutate internal state
        public void updateState(Object newState){
            this.state = newState;
            this.notifyObservers();
        }
        // provide access to actual state
        public Object getState(){
            return this.state;
        }
    }

    // one kind of observer
    static class Observer1 implements IObserver {
        @Override
        public void update(IObserved observed){
            System.out.println("Observer1 - processed new state of Observed: "+observed.getState().toString());
        }
    }
    // other kind of observer
    static class Observer2 implements IObserver {
        @Override
        public void update(IObserved observed){
            System.out.println("Observer1 - processed new state of Observed: "+observed.getState().toString());
        }
    }

}
