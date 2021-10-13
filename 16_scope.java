class Scope {
    // there is default value for primitive data types on class/object level
    // class (static) variable
    static byte class_static;
    // class constant
    static final double PI=3.14159276d;
    // Instance variable
    short class_local;

    public static void main(String[] args) {
        System.out.println("Class static: " + class_static);
        Scope.class_method();
        Scope.class_method();

        Scope pojo1 = new Scope();
        pojo1.instance_method();
        pojo1.instance_method();
        Scope pojo2 = new Scope();
        pojo2.instance_method();
        pojo2.instance_method();
    }

    // class static method uses class variable
    static void class_method(){
        System.out.println("Class static: " + ++class_static);
    }

    void instance_method() {
        // Access modifiers cannot be used for local variables.
        // Local variables are visible only within the declared method or block
        // no default value for local variables
        int method_local=20;
        System.out.print("Class static: " + ++class_static +
                         " Class local: " + ++class_local);
        if (true){
            byte block_local = 100;
            System.out.println(" Method local: " + ++method_local +
                               " Block local: " + ++block_local);
        }
    }
}

