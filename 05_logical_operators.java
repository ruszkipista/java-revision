class logical_operators {
    // comparison operators: on primitive variables their value is compared
    //                       on complex variables their ponter is compared
    //       ==  equal
    //       !=  not equal
    //       >=  greater than or equal
    //       <=  less than or equal
    //       >   greater than
    //       <   less than
    //       instanceof   Class/Interface membership
    public static void main(String[] args) {
        comparative_operators();
        boolean_operators();
    }     

    public static void comparative_operators() {
        int x = 5;
        int y = 10;

        System.out.println("x is equal to: " + x);
        System.out.println("y is equal to: " + y);

        System.out.println("x is greater than y");
        System.out.println(x > y);

        System.out.println("x is less than y");
        System.out.println(x < y);

        System.out.println("x is greater than or equal to y");
        System.out.println(x >= y);

        System.out.println("y is less than or equal to y");
        System.out.println(y <= y);

        System.out.println("x is equal to y");
        System.out.println(x == y);

        System.out.println("x is not equal to y");
        System.out.println(x != y);

        // demonstrate expression evaluation
        boolean bExpr = (1 == 2); //=false
        System.out.println("Evaluated expression (1 == 2) as: " + bExpr);

        // comparing strings: using String class's equals method
        String sHello1 = "Hello";
        String sHello2 = "Hello";
        if (sHello1.equals(sHello2)){
            System.out.println("The two strings match " + sHello1 + sHello2);
        }
        else {
            System.out.println("The two strings do not match " + sHello1 + sHello2);
        }

        // demonstrate instanceof operator
        if (sHello1 instanceof java.lang.String) {
            System.out.println("sHello1 variable is a String");
        }
    }

    public static void boolean_operators() {
        boolean x = true;
        boolean y = false;

        System.out.println("Value of x: " + x);
        System.out.println("Value of y: " + y);

        System.out.println("Boolean NOT of x " + !x );
        System.out.println("Boolean AND of x and y " + (x && y) );
        System.out.println("Boolean OR of x and y " + (x || y) );
        System.out.println("Boolean exclusive XOR of x and y " + (x ^ y));
    }
}
