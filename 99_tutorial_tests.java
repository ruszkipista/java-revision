class Tutorial_tests {
    public static void main(String[] args) {
        char[] pw = {'1','2','3','4','a','b','c','d'};
        System.out.println(check(pw));

        System.out.println(ReverseString("Hello World"));

    }

    public static boolean check(char[] password) {

        // Enter your code here
        boolean valid = String.valueOf(password).matches("[0-9a-zA-Z]{8,}");
        if (valid){
            valid = String.valueOf(password).matches(".*[0-9].*[0-9].*");
        }
        /* You do not need to worry about the return statement for the 
        moment, write your code and replace it with your return statement.*/
        return valid; 
    }

    public static String ReverseString(String str) {
        // Base case
        if (str.isEmpty()) {
            return str;
        } else {
            // Recursive case
            return ReverseString(str.substring(1)) + str.charAt(0);
        }
    }
}
