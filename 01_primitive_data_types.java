import java.math.BigDecimal;

class declare_variables {
  //  demonstrate unassigned boolean variable's initial value: false
  static boolean bValUnass;
  static char    cValUnass;
  static byte    byValUnass;
  static short   sValUnass;

  public static void main(String[] args) {

    // boolean type        
    System.out.println("Default Boolean variable value: " + bValUnass); //=false
    boolean bValue1 = true;
    System.out.println("Boolean variable true value: " + bValue1);
    bValue1 = !bValue1; //negates into true
    System.out.println("negated Boolean variable: " + bValue1);
    // parse character literal into boolean value
    boolean bParsed = Boolean.parseBoolean("true");
    // demonstrate double quote character " escaped in print as \u201c and \u201d
    System.out.println("parsed string \u201ctrue\u201d as boolean value: " + bParsed);

    // Integral types are types that have integer values. 
    // these are int, long, short, byte, and char

    // char type on 2 bytes, range of ['\u0000'...'\uffff'] [0...65535]
    System.out.println("Default Char variable value: \"" + cValUnass + "\"("+(int)cValUnass+")"); //=0
    System.out.println("Char maximum: " + Character.MAX_VALUE);
    System.out.println("Char A: "       + '\u0041');
    char ch = 'b';
    // demonstrate the continous print in a line using "print"
    System.out.print("Char b: " + ch);
    // close the printed line using "println"
    System.out.println(", and in uppercase: " + Character.toUpperCase(ch));
    System.out.println();

    // byte (integral) type on 1 byte range of [-2^7...2^7-1]
    System.out.println("Default Byte variable value: " + byValUnass); //=0
    byte bt = Byte.MAX_VALUE; //= 127 //MIN_VALUE= -128
    System.out.println("Byte maximum: " + bt);
    // increase variable by 1
    bt++;
    // 127+1 turns into -128 without error message or exception
    System.out.println("Byte minimum (MAX+1): " + bt);
    // hexadecimal integer literal
    bt = 0x0A; //=decimal 10
    // binary integer literal
    bt = 0b0000_1101; //=decimal 11
    System.out.println();

    // short (integral) type on 2 bytes, range of [-2^15...2^15-1]        
    System.out.println("Default Short variable value: " + sValUnass); //=0
    short sh = Short.MIN_VALUE; //= -32768 //MAX_VALUE= 32767
    System.out.println("Short minimum: " + sh);
    // decrease variable by 1
    sh--;
    // -32768-1 turns into 32767 without error message or exception
    System.out.println("Short maximum (MIN-1): " + sh);        
    System.out.println();

    // int (integral) type on 4 byte range of [-2^31...2^31-1]
    int i = Integer.MAX_VALUE; //= 2147483647 //MIN_VALUE= -2147483648
    System.out.println("Int maximum: " + i);
    // increase variable by 1
    i++;
    // 2147483647+1 turns into -2147483648 without error message or exception
    System.out.println("Int minimum (MAX+1): " + i);
    System.out.println();

    // long (integral) type on 8 bytes, range of [-2^63...2^63-1]        
    long lg = Long.MIN_VALUE; //= -9223372036854775808 //MAX_VALUE= 9223372036854775807
    System.out.println("Long minimum: " + lg);
    // decrease variable by 1
    lg--;
    // -9223372036854775808-1 turns into 9223372036854775807
    System.out.println("Long maximum (MIN-1): " + lg);
    // integer literal is of type long if suffixed with an ASCII letter L or l (ell)
    // otherwise it is of type int
    lg = 42L;
    System.out.println();

    // float (floating-point IEEE 754 32-bit single-precision) type on 4 bytes
    float fl = Float.MAX_VALUE; //= 3.4028235e38f largest positive finite literal
    System.out.println("Float maximum: " + fl);
    fl = Float.MIN_VALUE; //= 1.40e-45f smallest positive finite non-zero literal
    System.out.println("Float minimum positive non-zero : " + fl);
    // A floating-point literal is of type float if suffixed with an ASCII letter F or f
    fl = 13.46F;
    fl = 5f;
    System.out.println();

    // double (floating-point IEEE 754 64-bit double-precision) type on 8 bytes
    double db = Double.MAX_VALUE; //= 1.7976931348623157e308 largest positive finite literal
    System.out.println("Double maximum: " + db);
    db = Double.MIN_VALUE; //= 4.9e-324 smallest positive finite non-zero literal
    System.out.println("Double minimum positive non-zero : " + db);
    // a floating-point literal is type of double by default
    db = 13.57;
    // and it can optionally be suffixed with an ASCII letter D or d 
    db = 13.57d;
    db = 2D;
    System.out.println();

    // demonstration of impreciseness of double type operations
    double doubleValue  = .012;
    System.out.println("Double value:" + doubleValue + " * 3");
    double doubleSum = doubleValue + doubleValue + doubleValue;
    System.out.println("Expected value: 0.036 Calculated with double:" + doubleSum);
    // usage of class BigDecimal to fix the problem
    // transform double to string to get the proper 0.012 form
    // feed the string into BigDecimal constructor
    BigDecimal bigValue = new BigDecimal( Double.toString(doubleValue));
    System.out.println("BigDecimal value:" + bigValue.toString() );
    // use BigDecimal's add method to increase the value 2 times
    BigDecimal bigSum = bigValue.add(bigValue).add(bigValue);
    System.out.println("BigDecimal sum:" + bigSum.toString() );

    // widening an integral variable type from int to long
    int intValue = 56;
    long longValue = intValue;

    // narrowing an integral variable type from int to short using (casting)
    short shortValue = (short)intValue;

    // data loss if value doesn't fit to smaller space
    intValue = 1024;
    byte byteValue = (byte) intValue; //here byteValue gets 0 !!!

    // try casting from floating point to integer
    doubleValue = 3.99999d;
    // loss of fractional value part of double
    intValue = (int)doubleValue; //here intValue gets 3 !!!

    // demonstration of arithmetics
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
    double result5 = (double)intValue1 / intValue2;
    System.out.println("/ division (double):" + result5); //=1.3333333333333333

    // comparison operators: on primitive variables their value is compared
    //                       on complex variables their ponter is compared
    //       ==  equal
    //       !=  not equal
    //       >=  greater than or equal
    //       <=  less than or equal
    //       >   greater than
    //       <   less than
    // instanceof Class membership

    // demonstrate expression evaluation
    boolean bExpr = (1 == 2); //=false
    System.out.println("Evaluated expression (1 == 2) as: " + bExpr);

    // demonstrate instanceof operator
    String sHello1 = "Hello";
    if (sHello1 instanceof java.lang.String) {
        System.out.println("s is a String");
    }

    // comparing strings: using String class's equals method
    String sHello2 = "Hello";
    if (sHello1.equals(sHello2)){
        System.out.println("The two strings match " + sHello1 + sHello2);
    }
    else {
        System.out.println("The two strings do not match " + sHello1 + sHello2);
    }

    // logical operators: <expression1> operator <expression2>
    //   &&  AND
    //   ||  OR
    //   ?:  Ternary (short-hand for if-then) if expression is true, assign
    //       to variable the value after ?, else assign value after :
    String sTern = (1!=2) ? "trueValue" : "falseValue"; //="trueValue"
  }
}