class Scope {
    static byte class_static = 0;
    short class_local = 11;

    public static void main(String[] args) {
        System.out.println("Class static: " + class_static);
        Scope pojo1 = new Scope();
        pojo1.method();
        pojo1.method();
        Scope pojo2 = new Scope();
        pojo2.method();
        pojo2.method();
    }

    void method() {
        int method_local=21;
        System.out.println("Class static: " + ++class_static +
                           " Class local: " + ++class_local +
                           " Method local: " + method_local);
    }   
}

