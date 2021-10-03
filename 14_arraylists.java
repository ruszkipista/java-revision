import java.util.ArrayList;
import java.util.Arrays;

class arraylists {
    public static void main(String[] args) {
        // declare an Integer type based ArrayList
        ArrayList<Integer> arrInt;
        
        // instantiate an empty float type based ArrayList with initial capacity of 10
        ArrayList<Float> arrFloat =new ArrayList<>();
        System.out.println("Length of empty ArrayList: "+arrFloat.size());

        // instantiate an empty char type based ArrayList with initial capacity of 13
        ArrayList<Character> arrChar =new ArrayList<Character>(13);
        System.out.println("Length of empty ArrayList: "+arrChar.size());

        inbuilt_methods();

        ArrayList<Integer> arrInteger = new ArrayList<Integer>(Arrays.asList(-1,0,2,5,0,9,0));
        elementsToStart(arrInteger, 0);
        print_elements(arrInteger);

        ArrayList<Character> arrCharacter = new ArrayList<Character>(Arrays.asList('a','b','a','c','c','c','a'));
        removeDuplicates(arrCharacter);
        print_elements(arrCharacter);
    }

    public static void inbuilt_methods() {
        ArrayList < Character > letters = new ArrayList < Character > (); //Instantiation

        letters.add('A'); //adds at index 0
        letters.add('C'); //adds at index 1
        print_elements(letters);

        letters.add(1, 'B'); //adds at index 1, pushes the current value to index 2
        System.out.println("After inserting an element to index 1:");
        print_elements(letters);

        System.out.println("Index of \"C\":"+letters.indexOf('C'));
        System.out.println("Index of \"H\":"+letters.indexOf('H')+" (not in list)");
        System.out.println("Contains \"B\":"+letters.contains('B'));
        System.out.println("Contains \"K\":"+letters.contains('K'));

        letters.remove(0);
        System.out.println("After removing Index 0:");
        print_elements(letters);

    }

    public static <T> void print_elements(ArrayList<T> arr){
        System.out.println("The current size of the ArrayList is: " + arr.size());
        for (int i=0;i<arr.size();i++)
            System.out.print(i + ":" + arr.get(i)+", ");
        System.out.println();
    }

    // move Zeros to the beginning
    public static <T extends Comparable<T>> void elementsToStart(ArrayList<T> arrList, T element){
        int size = arrList.size();
        T element_i, element_j;
        for (int i=size-1;i>0;i--){
            element_i = arrList.get(i);
            if (element_i.compareTo(element)==0)
                for (int j=i-1;j>=0;j--){
                    element_j = arrList.get(j);
                    if (element_j.compareTo(element)!=0){
                        arrList.set(j,element_i);
                        arrList.set(i,element_j);
                        break;
                    }
                }     
        }
    }

    // remove duplicate elements from arrayList
    public static <T extends Comparable<T>> void removeDuplicates(ArrayList<T> arrList) {


        T element_i;
        int lastIndex = arrList.size()-1;
        for (int i=0;i<lastIndex;i++){
          element_i = arrList.get(i);
          for (int j=i+1;j<lastIndex+1;j++)
            if (element_i.compareTo(arrList.get(j)) == 0){
              arrList.remove(j);
              lastIndex--;
              j--;
            }
        }
      }
}
