class methods {
    // main() is a static method
    // it is called even when no object is created in the code
    public static void main(String[] args) {
        pass_parameter_by_value();
        pass_parameter_by_reference();
        System.out.println("Check(4,80): "+check(4,80));
        System.out.println("Grade A: " + letterToGPA("A"));
        System.out.println("Grade D: " + letterToGPA("D"));
        System.out.println("Grade L: " + letterToGPA("L"));
        System.out.println("Sum of digits of 27514: "+sumOfDigits(27514));
    }

    static void pass_parameter_by_value() {
        String name = "John";
        int age = 42;
        System.out.println(name + age);
        changeDetails(name, age);
        System.out.println(name + age);
    }

    static void changeDetails(String n, int a) {
        n = "Doe";
        a = 32;
    }

    static class CarSimple {
        // attribute, visible from outside
        public String colour;
        //Constructor takes in parameters and sets the attribute(s) in the class
        public CarSimple(String col) {
            this.colour = col;
        }
    }

    static void pass_parameter_by_reference() {
        //Create a CarSimple object with details
        CarSimple aCar = new CarSimple("Pink");
        // print current color
        System.out.println("Car colour is: " + aCar.colour);
        // here the argument "aCar" is passed by reference
        colorCarToBlue(aCar);
        // here the color is changed
        System.out.println("Car colour is: " + aCar.colour);
    }

    // the parameter "car" is an object, so it gets passed by reference
    static void colorCarToBlue(CarSimple car){
        car.colour="Blue";
    }


    static int check(int one, int two){
        int sum = one + two;
        if (sum<100){
            return 0;
        } else if (sum>100){
            return 1;
        } else {
            return 2;
        }
    }

    static double letterToGPA(String grade) {
        switch (grade){
            case "A":
            case "A+": return 4;
            case "A-": return 3.7;
            case "B+": return 3.3;
            case "B" : return 3;
            case "B-": return 2.8;
            case "C+": return 2.5;
            case "C" : return 2;
            case "C-": return 1.8;
            case "D" : return 1.5;
            case "F" : return 0;
            default  : return -1;
        }
    }

    static int sumOfDigits(int number) {
        int sum=0;
        int lastDigit;
        while (number>0){
            lastDigit = number%10;
            sum += lastDigit;
            number /= 10;
        }
        return sum;
    }
}
