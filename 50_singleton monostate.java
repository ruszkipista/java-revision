import static org.junit.Assert.assertEquals;

class Singleton_Pattern_Monostate {
/*
This version of Singleton is virtual, because it relies on static class variables
which are shared between all instances of the same class.
Although the instances are different, they behave like having only one instance for the same class.
For external parties it is hidden, that it is Singleton
There can be only static methods, mutating static class variables.
*/
    public static void main(String[] args) {

        MonoState so1 = new MonoState();
        MonoState so2 = new MonoState();
        assertEquals(105, so1.classVar);
        assertEquals(105, so2.classVar);
    }

    // Dynamic initialization
    static class MonoState{
        public static int classVar;
        private static boolean isInitialized = false;

        public MonoState(){
            if (!isInitialized){
                isInitialized = true;
                classVar = 105;
            }
        }
    }
}