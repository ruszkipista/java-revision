class Singleton_Pattern {
// Singleton pattern is one of the simplest design patterns, comes under creational patterns
// This pattern involves a single class which is responsible to create an object
// while making sure that only one object gets created. This class provides a way to directly
// access its only object without need to instantiate the object of the class.
    public static void main(String[] args) {
        //illegal construct
        //Compile Time Error: The constructor SingleObject() is not visible
        //  SingleObject object = new SingleObject();

        SingleObject so1 = SingleObject.getInstance();
        SingleObject so2 = SingleObject.getInstance();
        System.out.println("The two objects are the same: " + (so1==so2) );
    }

    static class SingleObject{
        private static SingleObject self;

        private SingleObject(){}

        public static SingleObject getInstance(){
            if (self==null) return self=new SingleObject();
            else return self;
        }
    }
}