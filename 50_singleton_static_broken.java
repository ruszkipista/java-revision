import static org.junit.Assert.assertEquals;

class Singleton_StaticInitialize_Broken {
/*
  The statically initialized Singleton may fail if the order of static initializers
  are complicated by dependencies.
  S1 depends on S2 for initialization and S2 depends on S1 for initialization.
  The run fails, because there is no correct order to run the initializations
  due to the mutual dependencies of each other's statically initialized variables.

  Easy to solve with Dynamic initializers
*/
    public static void main(String[] args) {
        assertEquals(102, SingleObjectSI1.instance.instanceVar);
        assertEquals(101, SingleObjectSI2.instance.instanceVar);
    }

    // static initialization 1
    // initializer refers to the other class
    static class SingleObjectSI1{
        public static SingleObjectSI1 instance =  new SingleObjectSI1(SingleObjectSI2.K);
        public static int K=101;
        private int instanceVar;

        private SingleObjectSI1(int n){ instanceVar = n; }
    }
    // static initialization 2
    // initializer refers to the other class
    static class SingleObjectSI2{
        public static SingleObjectSI2 instance =  new SingleObjectSI2(SingleObjectSI1.K);
        public static int K=102;
        private int instanceVar;

        private SingleObjectSI2(int n){ instanceVar = n; }
    }
}