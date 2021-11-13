import static org.junit.Assert.assertEquals;

class Singleton_Pattern {
/*
Singleton pattern is one of the simplest design patterns, comes under creational patterns
This pattern involves a single class which is responsible to create an object
while making sure that only one object gets created. This class provides a way to directly
access its only object without need to instantiate the object of the class.

Which version should I use?
1. No API: just create one object, no need Singleton
2. used in API, but no dependency cycles: Static Singleton
3. API + dependency cycles: Dynamic Singleton
4. API + dependency cycles + Threads: Dynamic Singleton with Lock
5. Lock is too slow in (4.): Double Checked Lock of Volatile Variable
*/
    static SingleObjectDIL so5;
    static SingleObjectDIL so6;
    static SingleObjectDIDCL so7;
    static SingleObjectDIDCL so8;
    public static void main(String[] args) {
        //illegal construct
        //Compile Time Error: The constructor SingleObject() is not visible
        //  SingleObject object = new SingleObject();

        // Static initialization
        SingleObjectSI so1 = SingleObjectSI.instance;
        SingleObjectSI so2 = SingleObjectSI.instance;
        assertEquals(101, so1.instanceVar);
        assertEquals(101, so2.instanceVar);
        assertEquals(so1, so2);

        // Dynamic initialization
        SingleObjectDI so3 = SingleObjectDI.getInstance();
        SingleObjectDI so4 = SingleObjectDI.getInstance();
        assertEquals(so3, so4);
        assertEquals(102, so3.instanceVar);
        assertEquals(102, so4.instanceVar);

        // Dynamic initialization with Lock
        new Thread(() -> so5 = SingleObjectDIL.getInstance()).start();
        new Thread(() -> so6 = SingleObjectDIL.getInstance()).start();
        while (so5==null || so6==null){
            try { Thread.sleep(1); }
            catch (InterruptedException e) { e.printStackTrace(); }
        }
        assertEquals(so5, so6);
        assertEquals(103, so5.instanceVar);
        assertEquals(103, so6.instanceVar);
 
        // Dynamic initialization with Double Checked Lock
        new Thread(() -> so7 = SingleObjectDIDCL.getInstance()).start();
        new Thread(() -> so8 = SingleObjectDIDCL.getInstance()).start();
        while (so7==null || so8==null){
            try { Thread.sleep(1); }
            catch (InterruptedException e) { e.printStackTrace(); }
        }
        assertEquals(so7, so8);
        assertEquals(104, so7.instanceVar);
        assertEquals(104, so8.instanceVar);
    }

    // Static initialization
    // it may fail if the order of static initializers are complicated by dependencies
    // see 50_singleton_static_broken.java
    static class SingleObjectSI{
        public static SingleObjectSI instance =  new SingleObjectSI();
        // other class attributes
        private int instanceVar;

        private SingleObjectSI(){
            // .... stuff for one-off initialization
            instanceVar = 101;
        }
        // other methods
        // ...
    }

    // Dynamic initialization
    static class SingleObjectDI{
        private static SingleObjectDI instance;
        private int instanceVar;

        private SingleObjectDI(){ instanceVar = 102; }

        public static SingleObjectDI getInstance(){
            if (instance == null) instance = new SingleObjectDI();
            return instance;
        }
    }

    // Dynamic initialization with Lock
    static class SingleObjectDIL{
        private static SingleObjectDIL instance;
        private int instanceVar;

        private SingleObjectDIL(){ instanceVar = 103; }

        // with "synchronized", the thread control can not break into the "if" statement
        synchronized public static SingleObjectDIL getInstance(){
            if (instance == null) instance = new SingleObjectDIL();
            return instance;
        }
    }

    // Dynamic initialization with Double Checked Lock
    static class SingleObjectDIDCL{
        // volatile prevents Java from rearranging order of write of assign statements
        private static volatile SingleObjectDIDCL instance;
        private int instanceVar;

        private SingleObjectDIDCL(){ instanceVar = 104; }

        // with "synchronized", the thread control can not break into the "if" statement
        synchronized public static SingleObjectDIDCL getInstance(){
            if (instance == null)
                synchronized (Lock.class){    
                    if (instance == null)
                        instance = new SingleObjectDIDCL();
                }
            return instance;
        }
    }
    static class Lock {}
}