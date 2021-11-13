import static org.junit.Assert.assertEquals;

class Singleton_DynamicInitialize {
/*

*/
    public static void main(String[] args) {
        assertEquals(102, SingleObjectSD1.getInstance().instanceVar);
        assertEquals(101, SingleObjectSD2.getInstance().instanceVar);
    }

    // dynamic initialization 1
    // initializer refers to the other class
    static class SingleObjectSD1{
        private static SingleObjectSD1 instance = null;
        public static int K=101;
        private int instanceVar;

        private SingleObjectSD1(int n){ instanceVar = n; }

        public static SingleObjectSD1 getInstance(){
            if (instance==null) instance = new SingleObjectSD1(SingleObjectSD2.K);
            return instance;
        }
    }

    // dynamic initialization 2
    // initializer refers to the other class
    static class SingleObjectSD2{
        private static SingleObjectSD2 instance = null;
        public static int K=102;
        private int instanceVar;

        private SingleObjectSD2(int n){ instanceVar = n; }

        public static SingleObjectSD2 getInstance(){
            if (instance==null) instance = new SingleObjectSD2(SingleObjectSD1.K);
            return instance;
        }
    }
}