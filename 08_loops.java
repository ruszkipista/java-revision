class loops {
    public static void main(String[] args) {
        while_loop();
        do_while_loop();
        for_loop();
        nested_for_loops();
        fibonacci(4);
        half_pyramid(4);
    }

    public static void while_loop() {
        int counter = 0;
        int y = 0;
        while (counter != 4) { // the while loop will run as long as counter==4 condition is met             
            y += counter;
            counter += 1;
        } 
        System.out.println("Value of y = " + y);
        System.out.println("Value of counter = " + counter);    
    }

    public static void do_while_loop() {
        System.out.println();
        int number = 5;
        do {
            System.out.println("Value of number is: " + number);
            number++;
        } while (number <= 9); // the contition is being checked after the first run
    }

    public static void for_loop() {
        for (int i = 0; i < 10; ++i) {
            // for loop iterates 10 times
            System.out.println("value of i = " + i);
        }
    }

    public static void nested_for_loops() {
        int input = 5;

        System.out.println("How many missiles will you fire?");
        System.out.println("I will fire: " + input + " missiles");

        for (int i = 0; i < input; i++) { // outer for loop
            for (int j = 3; j > 0; j--) { // inner for loop
                System.out.println(j + " ");
            }
            System.out.println("Missile " + (i + 1) + " has launched.");
        }

        System.out.println("All missiles have been launched.");
    }

    public static void fibonacci(int n) {
        int f0=0, f1=1, i=0, temp;
        System.out.println("Fibonacci("+n+")");
        do {
            System.out.print(f0 + " ");
            if (++i>=n) {break;}
            temp = f1;
            f1 = f0+f1;
            f0 = temp;
        } while (true);
        System.out.println();
    }

    public static void half_pyramid(int rows) {
        System.out.println("Half_Pyrqamid("+rows+")");
        //use " " to add space between # in pyramid
        for (int i=0;i<rows;i++){
            for (int j=0;j<=i;j++){
                System.out.print("# ");
            }
            System.out.println();
        }
    }
}
