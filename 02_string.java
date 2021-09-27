class strings {
    // Special characters in Strings
    // Name	            Character
    // Backspace         \b
    // Tab               \t
    // NULL character    \0
    // Newline           \n
    // Carriage Control  \r
    // Double Quote      \"
    // Single Quote      \’
    // Backslash         \\
    public static void main(String[] args) {
        special_characters();
        immutability();
        concatenation();
        comparison();
        split();
        subtring();
        upper_lower_case();
        length();
    }

    public static void special_characters() {
        String special_char = "Line one\n" + "Line two\n";
        System.out.print(special_char);
    }

    public static void immutability() {
        String text = "       Cut string";
        // The trim function is meant to eliminate leading & trailing spaces
        System.out.println(text.trim());

        // the text variable's value is unchanged
        System.out.println(text);

        // Assigning trimmed string to the variable
        text = text.trim();
        System.out.println(text);
    }

    public static void concatenation() {
        String one = "Hello";
        String two = " World";
        int number = 42;

        // concatenating two strings
        System.out.println(one + two);

        //concatenating a number and string
        System.out.println(one + " " + number);

        //saving concatenated string and printing
        String new_string = one + two + " " + number;
        System.out.println(new_string);
    }

    public static void comparison() {
        String one = "Hello";
        String two = "World";
        String same = "Hello";

        System.out.println(one+" equals "+two+" : "+one.equals(two));
        System.out.println(one+" equals "+same+" : "+one.equals(same));
    }

    public static void split() {
        String greet = "Hello World,My name is Waldo,How are you?";
        String[] greetings = greet.split(",");
        System.out.println(greetings[0]);
        System.out.println(greetings[1]);
        System.out.println(greetings[2]);
    }

    public static void subtring() {
        String choice = "CoffeeOrTea";
        //First: Only one argument: take from index 8 till the end
        System.out.println(choice.substring(8));

        //Second: Two arguments: take from index 0 until index 6-1
        System.out.println(choice.substring(0, 6));
    }

    public static void upper_lower_case() {
        String greet = "HeLlo WoRld";

        //Returns new string in which all characters are converted to upper case
        System.out.println(greet.toUpperCase());

        //Returns new string in which all characters are converted to lower case
        System.out.println(greet.toLowerCase());
    }

    public static void length() {
        String greeting = "Hello World";
        System.out.println("The length of greeting is: " + greeting.length());
    }
}
