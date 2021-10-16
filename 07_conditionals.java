class conditional_statements {
    public static void main(String[] args) {
        if_statement();
        if_else();
        if_else_if();
        switch_statement();
        conditional_expression();

        //   ?:  Ternary (short-hand for if-then) if expression is true, assign
        //       to variable the value after ?, else assign value after :
        String sTern = (1!=2) ? "trueValue" : "falseValue"; //="trueValue"   
        System.out.println("Ternary expression result: " + sTern);
    }

    public static void if_statement() {
        int x = 10;
        if (x > 4) {
            System.out.println("x is greater than 4");
        }
    }

    public static void if_else() {
        int x = 1;
        if (x > 4) {
            System.out.println("x is greater than 4");
        }
        else {
            System.out.println("x is less than 4");
        }
    }

    public static void if_else_if() {
        int x = 4;
        if (x > 4) {
            System.out.println("x is greater than 4");
        }
        else if (x == 4) {
            System.out.println("x is equal to 4");
        } 
        else {
            System.out.println("x is less than 4");
        }
    }
    
    public static void switch_statement() {
        int question = 2;
        char answer;

        switch (question) {
            case 1:
            case 2:
                answer = 'A';
                break;
            case 3:
                answer = 'C';
                break;
            default:
                answer = 'X';
                break;
        }
        System.out.println("Value of answer: " + answer);
    }

    public static void conditional_expression() {
        int x = 10;
        int y = 5;
        int answer = (x > y) ? x : y;
        System.out.println("Answer: " + answer + " is greater");
    }
}
