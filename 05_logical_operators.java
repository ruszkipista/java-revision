class logical_operators {
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
    }

    public static void boolean_operators() {
        boolean x = true;
        boolean y = false;

        System.out.println("Value of x: " + x);
        System.out.println("Value of y: " + y);

        System.out.println("Boolean NOT of x");
        System.out.println(!x);

        System.out.println("Boolean AND of x and y");
        System.out.println(x && y);

        System.out.println("Boolean OR of x and y");
        System.out.println(x || y);

        System.out.println("Boolean exclusive XOR of x and y");
        System.out.println(x ^ y);
    }
}
