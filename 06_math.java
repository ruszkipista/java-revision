class math {
    public static void main(String[] args) {
        exponent();
        log();
        trigonometry();
        absolute();
        max_min();
    }

    public static void exponent() {
        System.out.println("2 raised to the power 3 is " + Math.pow(2, 3));
        System.out.println("Exponent squared is " + Math.exp(2));
        System.out.println("The square root of 16 is " + Math.sqrt(16));
        System.out.println("The cube root of 27 is " + Math.cbrt(27));
        System.out.println("e is " + Math.E);
        System.out.println("e raised to the power of 0.693 is " + Math.pow(Math.E, 0.6931471805599453d));
    }

    public static void log() {
        System.out.println("log to the base e of 2 is " + Math.log(2));
        System.out.println("log to the base 10 of 100 is " + Math.log10(100));
    }

    public static void trigonometry() {
        System.out.println("tan(45°) = " + Math.tan(Math.toRadians(45)));
        System.out.println("sin(45°) = " + Math.sin(Math.toRadians(45)));
        System.out.println("cos(45°) = " + Math.cos(Math.toRadians(45)));
    }

    public static void absolute() {
        System.out.println("Absolute value of -2: " + Math.abs(-2));
        System.out.println("Absolute value of 3.4: " + Math.abs(3.4f));
    }

    public static void max_min() {
        System.out.println("Maximum between 2.04 and 2.05: " + Math.max(2.04, 2.05));
        System.out.println("Minimum between 19 and 23: " + Math.min(19, 23));
    }
}