class tests {
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

    public static void main(String[] args) {
        char[] pw = {'1','2','3','4','a','b','c','d'};
        System.out.println(check(pw));
    }
}

