class Operators {

    public static void main(String[] args){
        arithmetic_operators();
        operator_precedence();
    }
    
    public static void arithmetic_operators(){
        int answer; 

        System.out.println("ADDITION");
        int add = 20;

        System.out.println("Initial value: " + add);
        answer = add + 2;
        System.out.println("add + 2 = " + answer);
        answer = add;
        System.out.println("add = " + answer);
        System.out.println();

        System.out.println("SUBTRACTION");
        int sub = 15;

        System.out.println("Initial value: " + sub);
        System.out.println("sub - 4 = " + (sub - 4));
        System.out.println("sub = " + sub);
        System.out.println();

        System.out.println("MULTIPLICATION");
        int mult = 25;

        System.out.println("Initial value: " + mult);
        answer = mult * 3;
        System.out.println("mult * 3 = " + answer);
        answer = mult;
        System.out.println("mult = " + mult);
        System.out.println();

        System.out.println("DIVISION (INT)");
        int div_int = 15;

        System.out.println("Initial value: " + div_int);
        System.out.println("div_int / 2 = " + (div_int / 2));
        System.out.println("div_int = " + div_int);
        System.out.println();

        System.out.println("MODULO (REMINDER)");
        int rem = 5;

        System.out.println("Initial value: " + rem);
        answer = rem % 2;
        System.out.println("rem % 2 = " + answer);
        answer = rem;
        System.out.println("rem = " + answer);
        System.out.println();

        System.out.println("PREINCREMENT BY ONE");
        int pre_inc = 5;

        System.out.println("Initial value: " + pre_inc);
        System.out.println("++pre_inc   = " + (++pre_inc));
        System.out.println("pre_inc = " + pre_inc);
        System.out.println();

        System.out.println("PREDECREMENT BY ONE");
        int pre_dec = 5;

        System.out.println("Initial value: " + pre_dec);
        answer = --pre_dec;
        System.out.println("--pre_dec   = " + answer);
        answer = pre_dec;
        System.out.println("pre_dec = " + answer);
        System.out.println();

        System.out.println("POST INCREMENT BY ONE");
        int post_inc = 5;

        System.out.println("Initial value: " + post_inc);
        System.out.println("post_inc++   = " + (post_inc++) + " !!!");
        System.out.println("post_inc = " + post_inc);
        System.out.println();

        System.out.println("POSTDECREMENT BY ONE");
        int post_dec = 5;

        System.out.println("Initial value: " + post_dec);
        answer = post_dec--;
        System.out.println("post_dec--   = " + answer + " !!!");
        answer = post_dec;
        System.out.println("post_dec = " + answer);
        System.out.println();
    }

    public static void operator_precedence() {
        int x = 5;
        int y = 10;
        int z = 7;
        int w = 6;
        int answer;

        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("z: " + z);
        System.out.println("w: " + w);

        System.out.println("Calculating Expressions with Multiple Operators");
        answer = (x - z) + y * y;
        System.out.println("(x-z) + y*y = " + answer);
        answer = w / y + (x * z);
        System.out.println("w/y + (x*z) = " + answer);

        System.out.println("Calculating Expression containing operators with the same precedence");
        answer = x + y - z;
        System.out.println("x+y-z = " + answer);
    }
}