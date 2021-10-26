class arrays {
    // main() is a static method
    // it is called even when no object is created in the code
    public static void main(String[] args) {
        int_array();
        char_array();
        index_out_of_bound();
        two_dim_array();
        printPascalTriangle(5);
    }

    static void int_array(){
        int[] arr = new int[5];
        System.out.println("Array of size 5 gets initial values of");
        print_int_array(arr);
        initialize_int_array(arr, 7);
        System.out.println("Initialized array with 7: ");
        print_int_array(arr);
        
        // declare, instantiate and initialize an array
        int[] arr_instant = {2, 4, 6};
        System.out.println("Array initialized with {2,4,6}: ");
        print_int_array(arr_instant);
        System.out.println("First element is:  " + arr_instant[0]);
        System.out.println("Second element is: " + arr_instant[1]);
        System.out.println("Third element is:  " + arr_instant[2]);
    }

    static void print_int_array(int[] arr){
        // enhanced for loop
        for (int element: arr){
            System.out.print(element+" ");
        }
        System.out.println();
    }

    static void initialize_int_array(int[] arr, int init_value) {
        for (int i=0;i<arr.length;i++){
            arr[i] = init_value;
        }
    }

    static void char_array() {
        char[] chArray1 = { 'x','y','z'}; //initialization of first char array

        char[] chArray2 = new char[5]; //instantiation of second char array
        initialize_char_array(chArray2);
        //printing out the stored values in the arrays
        System.out.print("The Values stored in ChArray1 are: ");
        print_char_array(chArray1);

        System.out.print("The Values stored in ChArray2 are: ");
        print_char_array(chArray2);
    }

    static void print_char_array(char[] arr){
        for (int element: arr){
            System.out.print(element+" ");
        }
        System.out.println();
    }
    static void initialize_char_array(char[] arr) {
        for (char i=0;i<arr.length;i++){
            arr[i] = (char) ('a' + i);
        }
    }

    static void index_out_of_bound(){
        byte[] arr= new byte[3];
        try {
            arr[5]=0;
        } catch (Exception e) {
            // Index 5 out of bounds for length 3
            System.out.println("Invalid index in array generates exception: "+e.getMessage());
        }
    }

    static void two_dim_array() {
        //instantiating a character array of size 3*2 = 6 elements
        char[][] arr1 = new char[3][2];
        arr1[0][0]='1';
        arr1[0][1]='2';
        arr1[1][0]='3';
        arr1[1][1]='4';
        arr1[2][0]='5';
        arr1[2][1]='6';
        print_twoDim_char_array(arr1);

        // initialize a 2x4 matrix
        char[][] arr2 = {
            {'a','b','c','d'},
            {'e','f','g','h'}
        };
        print_twoDim_char_array(arr2);
    }

    static void print_twoDim_char_array(char[][] arr){
        for (char[] row: arr){
            for (char c: row){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }

    // 1 
    // 1 1 
    // 1 2 1 
    // 1 3 3 1 
    // 1 4 6 4 1
    static void printPascalTriangle(int size) {
        int[] p = new int[size];
        p[0]=1;
        int prev, tmp;
        System.out.println("Pascal triangle:");
        for (int i=0;i<size;i++){
            prev=0;
            for (int j=0;j<=i;j++){
                tmp = p[j];
                p[j] += prev;
                prev = tmp;
                System.out.print(p[j]+" ");
            }
            System.out.println();
        }
    }
}

// Arrays Methods
// ===============
// public static int binarySearch(Object[] a, Object key)
 
// Searches the specified array of Object ( Byte, Int , double, etc.) for the specified value
// using the binary search algorithm. The array must be sorted prior to making this call. 
// This returns index of the search key, if it is contained in the list;
// otherwise, it returns ( – (insertion point + 1)).
 
// public static boolean equals(long[] a, long[] a2)
// Returns true if the two specified arrays of longs are equal to one another. 
// Two arrays are considered equal if both arrays contain the same number of elements,
// and all corresponding pairs of elements in the two arrays are equal. This returns true
// if the two arrays are equal. Same method could be used by all other primitive data types
// (Byte, short, Int, etc.)

// public static void fill(int[] a, int val)
// Assigns the specified int value to each element of the specified array of ints.
// The same method could be used by all other primitive data types (Byte, short, Int, etc.)

// public static void sort(Object[] a)
// Sorts the specified array of objects into an ascending order, according to the natural
// ordering of its elements. The same method could be used by all other primitive data types
// ( Byte, short, Int, etc.)