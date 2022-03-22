/*
 * Demonstrate usage and limits of primitive variables and data structures
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author iorosz
 */
class variable_demo {

//  demonstrate unassigned boolean variable's initial value: false
    static boolean bValUnass;

//  @param args the command line arguments
    public static void main(String[] args) {
        System.out.println("Hello World from Java!");

//    boolean type
        System.out.println("Default Boolean variable value: " + bValUnass); //=false
        boolean bValue1 = true;
        System.out.println("Boolean variable true value: " + bValue1);
//      !      inverts (negatea) the value of a boolean
        bValue1 = !bValue1; //negates into true
        System.out.println("negated Boolean variable: " + bValue1);

//    logical operators: <expression1> operator <expression2>
//      &&            AND
//      ||            OR
//      ?:            Ternary (short-hand for if-then) if expression is true, assign
//                    value after ? to variable, else assign value after :
        String sTern = (1 != 2) ? "trueValue" : "falseValue"; //="trueValue"

//    parse character literal into boolean value
        boolean bParsed = Boolean.parseBoolean("true");
//    demonstrate double quote character " escaped in print as \u201c and \u201d
        System.out.println("parsed string \u201ctrue\u201d as boolean value: " + bParsed);

//    char type on 2 bytes range of ['\u0000'...'\uffff'] [0...65535]
        char ch = Character.MAX_VALUE;
        System.out.println("Char maximum: " + ch);
        ch = '\u0041';
        System.out.println("Char A: " + ch);
        ch = 'b';
//    demonstrate the continous print in a line using "print"
        System.out.print("Char b: " + ch);
//    close the printed line using "println"
        System.out.println(", and in uppercase: " + Character.toUpperCase(ch));

//    byte (integral) type on 1 byte range of [-2^7...2^7-1]
        byte bt = Byte.MAX_VALUE; //= 127 //MIN_VALUE= -128
        System.out.println("Byte maximum: " + bt);
        //   increase variable by 1
        bt++;
//    127+1 turns into -128 without error message or exception
        System.out.println("Byte minimum (MAX+1): " + bt);
//    hexadecimal integer literal
        bt = 0x0A; //=decimal 10
//    binary integer literal
        bt = 0b0000_1101; //=decimal 11

//    short (integral) type on 2 bytes, range of [-2^15...2^15-1]
        short sh = Short.MIN_VALUE; //= -32768 //MAX_VALUE= 32767
        System.out.println("Short minimum: " + sh);
        //   decrease variable by 1
        sh--;
//    -32768-1 turns into 32767 without error message or exception
        System.out.println("Short maximum (MIN-1): " + sh);

//    int (integral) type on 4 byte range of [-2^31...2^31-1]
        int i = Integer.MAX_VALUE; //= 2147483647 //MIN_VALUE= -2147483648
        System.out.println("Int maximum: " + i);
        //   increase variable by 1
        i++;

//    2147483647+1 turns into -2147483648 without error message or exception
        System.out.println("Int minimum (MAX+1): " + i);

//    long (integral) type on 8 bytes, range of [-2^63...2^63-1]
        long lg = Long.MIN_VALUE; //= -9223372036854775808 //MAX_VALUE= 9223372036854775807
        System.out.println("Long minimum: " + lg);
        //   decrease variable by 1
        lg--;
//    -9223372036854775808-1 turns into 9223372036854775807
        System.out.println("Long maximum (MIN-1): " + lg);
//    integer literal is of type long if suffixed with an ASCII letter L or l (ell)
//    otherwise it is of type int
        long lg2 = 1L;

//    float(IEEE 754 32-bit single-precision) type on 4 bytes
        float fl = Float.MAX_VALUE; //= 3.4028235e38f largest positive finite literal
        System.out.println("Float maximum: " + fl);
        fl = Float.MIN_VALUE; //= 1.40e-45f smallest positive finite non-zero literal
        System.out.println("Float minimum positive non-zero : " + fl);
//    A floating-point literal is of type float if suffixed with an ASCII letter F or f
        fl = 13.46f;
        fl = 5f;

//    double (IEEE 754 64-bit double-precision) type on 8 bytes
        double db = Double.MAX_VALUE; //= 1.7976931348623157e308 largest positive finite literal
        System.out.println("Double maximum: " + db);
        db = Double.MIN_VALUE; //= 4.9e-324 smallest positive finite non-zero literal
        System.out.println("Double minimum positive non-zero : " + db);
//    a floating-point literal is type of double by default
        db = 13.57;
//    and it can optionally be suffixed with an ASCII letter D or d
        db = 13.57d;
        db = 2d;

//    demonstration of impreciseness of double type operations
        double doubleValue = .012;
        System.out.println("Double value:" + doubleValue + " * 3");
        double doubleSum = doubleValue + doubleValue + doubleValue;
        System.out.println("Expected value: 0.036 Calculated with double:" + doubleSum);
//    usage of class BigDecimal to fix the problem
//     transform double to string to get the proper 0.012 form
//     feed the string into BigDecimal constructor
        BigDecimal bigValue = new BigDecimal(Double.toString(doubleValue));
        System.out.println("BigDecimal value:" + bigValue.toString());
//    use BigDecimal's add method to increase the value 2 times
        BigDecimal bigSum = bigValue.add(bigValue).add(bigValue);
        System.out.println("BigDecimal sum:" + bigSum.toString());

//    widening an integral variable type from int to long
        int intValue = 56;
        long longValue = intValue;

//    narrowing an integral variable type from int to short using (casting)
        short shortValue = (short) intValue;

//    data loss if value doesn't fit to smaller space
        intValue = 1024;
        byte byteValue = (byte) intValue; //here byteValue gets 0 !!!

//    try casting from floating point to integer
        doubleValue = 3.99999d;
//    loss of fractional value part of double
        intValue = (int) doubleValue; //here intValue gets 3 !!!

//    demonstration of arithmetics
        int intValue1 = 56;
        int intValue2 = 42;
        System.out.println("Basic arithmetics with int " + intValue1 + " " + intValue2);
        int result1 = intValue1 + intValue2;
        System.out.println("+ addition:" + result1);          //=98
        int result2 = intValue1 - intValue2;
        System.out.println("- subtraction:" + result2);       //=14
        int result3 = intValue1 / intValue2;
        System.out.println("/ division (integer):" + result3);//=1
        int result4 = intValue1 % intValue2;
        System.out.println("% remainder:" + result4);         //=14
        double result5 = (double) intValue1 / intValue2;
        System.out.println("/ division (double):" + result5); //=1.3333333333333333

//    demonstration of class Math
        doubleValue = -3.99999d;
        double result6 = Math.round(doubleValue);
        System.out.println("rounding of " + doubleValue + " to " + result6); //=-4.0
        double result7 = Math.abs(doubleValue);
        System.out.println("absolute value of " + doubleValue + " is " + result7); //3.99999

//        +                      concatenation of two strings
//    Unary Operators
//        <variable>++           increase variable by 1
//        <variable>--           decrease variable by 1
//     Compound assignments
//        <variable>+= <var>     increase variable with value
//        <variable>-= <var>     decrease variable with value
//        <variable>*= <var>     multiply variable by value
//        <variable>/= <var>     divide variable by value
//      postfix incremention: print 56 and increase to 57
        System.out.print("print and increase: " + intValue1++);
        System.out.println(", new value: " + intValue1);
//      prefix decrementation
        System.out.println("decrease and print: " + --intValue1);

//    comparison operators: on primitive variables their value is compared
//                          on complex variables their pointer is compared
//          !   negate a boolean value
//          ==  equal
//          !=  not equal
//          >=  greater than or equal
//          <=  less than or equal
//          >   greater than
//          <   less than
//   instanceof Class membership
//    demonstrate expression evaluation
        boolean bExpr = (1 == 2); //=false
        System.out.println("Evaluated expression (1 == 2) as: " + bExpr);

//    demonstrate instanceof operator
        String sHello = "Hello";
        if (sHello instanceof java.lang.String) {
            System.out.println("sHello variable is a String");
        }

//    Bit Shift Operators: <integral type variable> operator <number of shifts>
//          <<  signed left shift (circular) operator
//          >>  signed right shift (circular) operator
//          <<< unsigned left shift (0 padding at left) operator
//          >>> unsigned right shift (0 padding at right) operator
//    Bitwise and Bit Shift Operators: <integral type variable1> operator <integral type variable2>
//           ~  unary bitwise complement operator, inverts a bit pattern
//           &  bitwise AND operation
//           ^  exclusive OR operation
//           |  inclusive OR operation
        int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"
        System.out.println(val & bitmask);

//    demontrate 2 kind of string declarations
        String sHello1 = new String("Hello");
        String sHello2 = "Hello";            //shortcut for declaration

//    Strings objects are immutable: no change is possible,
//      only abandonement and reassignment.
//    Memory garbage collection frees up holes in memory later
//    comparing strings: using String class's equals method
        if (sHello1.equals(sHello2)) {
            System.out.println("The two strings match " + sHello1 + sHello2);
        } else {
            System.out.println("The two strings do not match " + sHello1 + sHello2);
        }

        String sConcat = sHello1 + sHello2;
        System.out.println("Concatenated strings: " + sConcat);

//    character array to string
        char[] cArray1 = {'H', 'E', 'L', 'L', 'O'};
        String sStr = new String(cArray1);
        System.out.println("character array to string: " + sStr);
//    string to character array
        char[] cArray2 = sStr.toCharArray();

//    string processing for each charaters
        for (char c : cArray2) {
            System.out.println(c);
        }

//      demonstrate integer array list
        ArrayList<Integer> weeklyTemperatures = new ArrayList<Integer>();
        weeklyTemperatures.add(24);
        weeklyTemperatures.add(18);
        weeklyTemperatures.add(20);
        weeklyTemperatures.add(28);
//      print lowest temperature accessing by index
        System.out.println(weeklyTemperatures.get(1));
//      insert a new element into the list at index position 2
        weeklyTemperatures.add(2, 29);
//      print temperature 20 at a new index 3 instead of 2
        System.out.println(weeklyTemperatures.get(3));
//      print the whole list
        for (int j = 0; j < weeklyTemperatures.size(); j++) {
            System.out.println(weeklyTemperatures.get(j));
        }
//      simplified for loop
        for (Integer temperature : weeklyTemperatures) {
            System.out.println(temperature);
        }
//      demonstrate string array list
        //Some Olympic sports
        ArrayList<String> olympicSports = new ArrayList<String>();
        olympicSports.add("Archery");
        olympicSports.add("Boxing");
        olympicSports.add("Cricket");
        olympicSports.add("Diving");
//      print the whole list
        System.out.println("There are " + olympicSports.size()
                + " Olympic sports in this list. They are: ");
        for (String sport : olympicSports) {
            System.out.println(sport);
        }
//      demonstrate hash map list
        //Host cities and the year they hosted the summer Olympics
        HashMap<String, Integer> hostCities = new HashMap<String, Integer>();
        hostCities.put("Beijing", 2008);
        hostCities.put("London", 2012);
        hostCities.put("Rio de Janeiro", 2016);

        for (String city : hostCities.keySet()) {
            if (hostCities.get(city) < 2016) {
                System.out.println(city + " hosted the summer Olympics in " + hostCities.get(city) + ".");
            } else {
                System.out.println(city + " will host the summer Olympics in " + hostCities.get(city) + ".");
            }
        }

//demonstrate structure type realized with class
        Data data1 = new Data(1, 5);
        Data data2 = new Data(2, 4);
        System.out.println(f(data1));
        System.out.println(f(data2));

    }

    private static int f(Data d) {
        return (3 * d.x) + d.y;
    }
}
//demonstrate structure type constructed with class
//to address mutability concerns x and y declared as final

class Data {

    public final int x;
    public final int y;

    public Data(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
