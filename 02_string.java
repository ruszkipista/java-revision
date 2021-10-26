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
        format();
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

    public static void format() {
        float floatVar = 3.1415976f;
        int intVar = 42;
        String stringVar = "hello!";
        // one-time print
        System.out.printf("The value of the float variable is " +
                          "%f, while the value of the integer " +
                          "variable is %d, and the string " +
                          "is %s\n", floatVar, intVar, stringVar);

        // reusable formatted string
        String fs;
        fs = String.format("The value of the float variable is " +
                            "%f, while the value of the integer " +
                            "variable is %d, and the string " +
                            "is %s", floatVar, intVar, stringVar);
        System.out.println(fs);
    }
}

// String Methods
// ================

// char charAt(int index)
// Returns the character at the specified index.

// int compareTo(Object o)
// Compares this String to another Object.

// int compareTo(String anotherString)
// Compares two strings lexicographically.

// int compareToIgnoreCase(String str)
// Compares two strings lexicographically, ignoring case differences.

// String concat(String str)
// Concatenates the specified string to the end of this string.

// boolean contentEquals(StringBuffer sb)
// Returns true if and only if this String represents the same sequence of characters as the specified StringBuffer.

// static String copyValueOf(char[] data)
// Returns a String that represents the character sequence in the array specified.

// static String copyValueOf(char[] data, int offset, int count)
// Returns a String that represents the character sequence in the array specified.

// boolean endsWith(String suffix)
// Tests if this string ends with the specified suffix.

// boolean equals(Object anObject)
// Compares this string to the specified object.

// boolean equalsIgnoreCase(String anotherString)
// Compares this String to another String, ignoring case considerations.

// byte[] getBytes()
// Encodes this String into a sequence of bytes using the platform's default charset, storing the result into a new byte array.

// byte[] getBytes(String charsetName)
// Encodes this String into a sequence of bytes using the named charset, storing the result into a new byte array.

// void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
// Copies characters from this string into the destination character array.

// int hashCode()
// Returns a hash code for this string.

// int indexOf(int ch)
// Returns the index within this string of the first occurrence of the specified character.

// int indexOf(int ch, int fromIndex)
// Returns the index within this string of the first occurrence of the specified character, starting the search at the specified index.

// int indexOf(String str)
// Returns the index within this string of the first occurrence of the specified substring.

// int indexOf(String str, int fromIndex)
// Returns the index within this string of the first occurrence of the specified substring, starting at the specified index.

// String intern()
// Returns a canonical representation for the string object.

// int lastIndexOf(int ch)
// Returns the index within this string of the last occurrence of the specified character.

// int lastIndexOf(int ch, int fromIndex)
// Returns the index within this string of the last occurrence of the specified character, searching backward starting at the specified index.

// int lastIndexOf(String str)
// Returns the index within this string of the rightmost occurrence of the specified substring.

// int lastIndexOf(String str, int fromIndex)
// Returns the index within this string of the last occurrence of the specified substring, searching backward starting at the specified index.

// int length()
// Returns the length of this string.

// boolean matches(String regex)
// Tells whether or not this string matches the given regular expression.

// boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)
// Tests if two string regions are equal.

// boolean regionMatches(int toffset, String other, int ooffset, int len)
// Tests if two string regions are equal.

// String replace(char oldChar, char newChar)
// Returns a new string resulting from replacing all occurrences of oldChar in this string with newChar.

// String replaceAll(String regex, String replacement
// Replaces each substring of this string that matches the given regular expression with the given replacement.

// String replaceFirst(String regex, String replacement)
// Replaces the first substring of this string that matches the given regular expression with the given replacement.

// String[] split(String regex)
// Splits this string around matches of the given regular expression.

// String[] split(String regex, int limit)
// Splits this string around matches of the given regular expression.

// boolean startsWith(String prefix)
// Tests if this string starts with the specified prefix.

// boolean startsWith(String prefix, int toffset)
// Tests if this string starts with the specified prefix beginning a specified index.

// CharSequence subSequence(int beginIndex, int endIndex)
// Returns a new character sequence that is a subsequence of this sequence.

// String substring(int beginIndex)
// Returns a new string that is a substring of this string.

// String substring(int beginIndex, int endIndex)
// Returns a new string that is a substring of this string.

// char[] toCharArray()
// Converts this string to a new character array.

// String toLowerCase()
// Converts all of the characters in this String to lower case using the rules of the default locale.

// String toLowerCase(Locale locale)
// Converts all of the characters in this String to lower case using the rules of the given Locale.

// String toString()
// This object (which is already a string!) is itself returned.

// String toUpperCase()
// Converts all of the characters in this String to upper case using the rules of the default locale.

// String toUpperCase(Locale locale)
// Converts all of the characters in this String to upper case using the rules of the given Locale.

// String trim()
// Returns a copy of the string, with leading and trailing whitespace omitted.

// static String valueOf(primitive data type x)
// Returns the string representation of the passed data type argument.