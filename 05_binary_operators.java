class binary_operators{
    public static void main(String[] args) {
        byte x = 0b0011_1100;  // 60
        byte y = 0b0000_1101;  // 13
        System.out.println("Value of x in binary: " + Integer.toBinaryString(x));
        System.out.println("Value of y in binary: " + Integer.toBinaryString(y));
        // x&y = 0000 1100
        System.out.println("Bitwise AND of x and y " + Integer.toBinaryString(x & y) );
        // x|y = 0011 1101
        System.out.println("Bitwise OR of x and y " + Integer.toBinaryString(x | y) );
        // x^y = 0011 0001
        System.out.println("Bitwise XOR of x and y " + Integer.toBinaryString(x ^ y));
        // ~x  = 1100 0011
        System.out.println("Bitwise NOT of x " + Integer.toBinaryString(~x));
        // y<<3  = 0110 1000
        System.out.println("Signed Left shift y by 3 " + Integer.toBinaryString(y<<3));
        // y>>2  = 0000 0011
        System.out.println("Signed Right Shift y by 2 " + Integer.toBinaryString(y>>2));
        // y>>>2  = 0000 0011
        System.out.println("Zero fill Unsigned Right shift y by 2 " + Integer.toBinaryString(y>>>2));

    }
}