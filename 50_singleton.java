class Singleton_Pattern {
/*
Singleton pattern is one of the simplest design patterns, comes under creational patterns
This pattern involves a single class which is responsible to create an object
while making sure that only one object gets created. This class provides a way to directly
access its only object without need to instantiate the object of the class.
*/
    public static void main(String[] args) {
        //illegal construct
        //Compile Time Error: The constructor SingleObject() is not visible
        //  SingleObject object = new SingleObject();

        SingleObjectDynamicallyInitialized so1 = SingleObjectDynamicallyInitialized.getInstance();
        SingleObjectDynamicallyInitialized so2 = SingleObjectDynamicallyInitialized.getInstance();
        System.out.println("The two objects are the same: " + (so1==so2) );
    }

    static class SingleObjectStaticallyInitialized{
        public static SingleObjectStaticallyInitialized instance =  new SingleObjectStaticallyInitialized();
        // other class attributes

        private SingleObjectStaticallyInitialized(){
            // .... stuff for one-off initialization
        }
        // other methods
        // ...
    }

    // better
    static class SingleObjectDynamicallyInitialized{
        private static SingleObjectDynamicallyInitialized instance;

        private SingleObjectDynamicallyInitialized(){}

        public static SingleObjectDynamicallyInitialized getInstance(){
            if (instance == null) instance = new SingleObjectDynamicallyInitialized();
            return instance;
        }
    }
}