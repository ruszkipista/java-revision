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

    // Literals can be assigned to any primitive type variable
    byte a = 68;
    char b = 'B';
    // byte, int, long, and short can be expressed in 
    // decimal(base 10), hexadecimal(base 16) or octal(base 8) number systems
    // Prefix 0 is used to indicate octal
    byte octal = 0144;
    // prefix 0x indicates hexadecimal
    short hexa = 0x0A; //=decimal 10
    // prefix 0b indicates binary literal, _ separator for each 4 digits
    long bin = 0b0000_1101; //=decimal 11
    System.out.println();

    // special escape sequences for String and char literals
    //   Notation   	Character represented
    //   \n          	Newline (0x0a)
    //   \r         	Carriage return (0x0d)
    //   \f          	Formfeed (0x0c)
    //   \b	          Backspace (0x08)
    //   \s          	Space (0x20)
    //   \t          	tab
    //   \"          	Double quote
    //   \'	          Single quote
    //   \\         	backslash
    //   \ddd	        Octal character (ddd)
    //   \ uxxxx     	Hexadecimal UNICODE character (xxxx)
    
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

    // wrapper classes (Integer, Long, Byte, Double, Float, Short)
    // are subclasses of the abstract class Number

    // Boxing / Unboxing
    Integer x = 5; // boxes int to an Integer object
    x =  x + 10;   // unboxes the Integer to a int

// Number Methods
// ================
// Following is the list of the instance methods
// that all the subclasses of the Number class implements

// 	xxxValue()  - Converts the value of this Number object 
//                   to the xxx data type and returns it.
// 	compareTo() - Compares this Number object to the argument.
// 	equals()    - Determines whether this number object is equal to the argument.
// 	valueOf()   - Returns an Integer object holding the value 
//                   of the specified primitive.
// 	toString()  - Returns a String object representing the value
//                   of a specified int or Integer.
// 	parseInt()  - This method is used to get the primitive
//                   data type of a certain String.
// 	abs()       - Returns the absolute value of the argument.
// 	ceil()      - Returns the smallest integer that is greater than 
//                   or equal to the argument. Returned as a double.
// 	floor()     - Returns the largest integer that is less than
//                   or equal to the argument. Returned as a double.
//  rint()      - Returns the integer that is closest in value to the argument.
//                   Returned as a double.
//  round()     - Returns the closest long or int, as indicated by the method's return type to the argument.
//  min()       - Returns the smaller of the two arguments.
//  max()       - Returns the larger of the two arguments.
//  exp()       - Returns the base of the natural logarithms, e, to the power of the argument.
//  log()       - Returns the natural logarithm of the argument.
//  pow()       - Returns the value of the first argument 
//                  raised to the power of the second argument.
//  sqrt()      - Returns the square root of the argument.
//  sin()       - Returns the sine of the specified double value.
//  cos()       - Returns the cosine of the specified double value.
//  tan()       - Returns the tangent of the specified double value.
//  asin()      - Returns the arcsine of the specified double value.
//  acos()      - Returns the arccosine of the specified double value.
//  atan()      - Returns the arctangent of the specified double value.
//  atan2()     - Converts rectangular coordinates (x, y) to
//                  polar coordinate (r, theta) and returns theta.
//  toDegrees() - Converts the argument to degrees.
//  toRadians() - Converts the argument to radians.
//  random()    - Returns a random number.

// Character Methods
// ======================
// Following is the list of the important instance methods 
// that all the subclasses of the Character class implement

// 	isLetter()     - Determines whether the specified char value is a letter.
// 	isDigit()      - Determines whether the specified char value is a digit.
// 	isWhitespace() - Determines whether the specified char value is white space.
// 	isUpperCase()  - Determines whether the specified char value is uppercase.
// 	isLowerCase()  - Determines whether the specified char value is lowercase.
// 	toUpperCase()  - Returns the uppercase form of the specified char value.
// 	toLowerCase()  - Returns the lowercase form of the specified char value.
// 	toString()     - Returns a String object representing 
//                    the specified character value that is, a one-character string.
  }
}