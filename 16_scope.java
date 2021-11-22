class Scope {
    // there is default value for primitive data types on class/object level
    // class (static) variable
    static byte class_static;
    // class final: can not be reassigned, primitive can be changed!
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

        System.out.println();
        Person p1 = new Person("Hulu");
        Person p2 = new Person("Zulu");
        p1.greet(p2);

        SubClass sb = new SubClass();
        sb.doSomething();
    }

    // class static method uses class variable
    static void class_method(){
        System.out.println("Class static: " + ++class_static);
        // Scope.PI++;
        System.out.println("Class Final Primitive: " + Scope.PI);
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

    static class Person{
        private String name;
        public Person(String name){
            this.name = name;
        }

        public void greet(Person other){
            // free access to an other object's private attribute
            // if they have the same type
            System.out.println("Hello "+other.name+", I am "+this.name);
        }
    }

    // 
    static class SuperClass{
        private   boolean privateVar;
                  boolean packagePrivate; // no access modifier: package-private
        protected boolean protectedVar;
        public    boolean publicVar;
    }
    static class SubClass extends SuperClass{
        void doSomething(){
            //this.privateVar = true;   // Not visible in SubClass like this
            // although, visible through "super."
            super.privateVar = true;
            System.out.println(super.privateVar);

            // the package-private is accessible for all classes in the same package
            // but not accessible in sub-classes in a different package
            this.packagePrivate = true;
            System.out.println(this.packagePrivate);

            // the protected is accessible for all classes in the same package
            // also accessible in the sub-classes in a different package
            this.protectedVar = true;
            System.out.println(this.protectedVar);

            // the public is accessible for all classes in all packagees
            this.publicVar = true;
            System.out.println(this.publicVar);
        }
    }
}

