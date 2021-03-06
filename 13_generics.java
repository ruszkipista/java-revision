class generics {
    // Primitive Data Type      Wrapper Class
    // --------------------     -------------
    // boolean                  Boolean
    // byte                     Byte
    // char                     Character
    // double                   Double
    // float                    Float
    // int                      Integer
    // long                     Long
    // short                    Short

    public static void main(String[] args) {

        templt(1, 2, 3);

        System.out.printf("Max of %d, %d and %d is %d\n", 3, 4, 5, findMax(3, 4, 5));
        System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n", 6.6, 8.8, 7.7, findMax(6.6, 8.8, 7.7));
        System.out.printf("Max of %s, %s and %s is %s\n", "pear", "apple", "orange", findMax("pear", "apple", "orange"));

        StoreObject<Integer> obj1 = new StoreObject<Integer> (5);
        System.out.println("Stored value: "+obj1.getObject());

        StoreObject<Double> obj2 = new StoreObject<Double> (15.777755);
        System.out.println("Stored value: "+obj2.getObject());

        StoreObject<String> obj3 = new StoreObject<String> ("My first Generic Class.");
        System.out.println(obj3.getObject());

        Integer[] arr = {1,2,3,2,0};
        System.out.println("Maximum value is "+findMax(arr));
    }

    // generic (template) CLASS
    // We use <> to specify Parameter type 
    static class StoreObject <T> {
        // an object of type T is declared
        T obj;
        // constructor
        StoreObject(T obj) { this.obj = obj; }
        // getter
        public T getObject() { return this.obj; }
    }

    // this is a template METHOD with 3 types
    // we use <> to specify Parameter type 
    public static < T1, T2, T3 > void templt(T1 x, T2 y, T3 z) {
        System.out.println("This is x =" + x);
        System.out.println("This is y =" + y);
        System.out.println("This is z =" + z);
    }

    // this is a template METHOD of a comparable type
    public static <T extends Comparable<T>> T findMax(T x, T y, T z) {
        T max = x; // assume x is initially the largest
        if (y.compareTo(max) > 0) max = y; // y is the largest so far
        if (z.compareTo(max) > 0) max = z; // z is the largest now
        return max; // returns the largest object
    }
    // also a template METHOD of a comparable type
    public static <T extends Comparable<T>> T findMax(T[] data) {
        T max = data[0];
        for (int i=1;i<data.length;i++){
            if (data[i].compareTo(max) > 0) max=data[i];
        }
        return max;
    }
}
