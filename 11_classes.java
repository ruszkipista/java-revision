class classes {

    public static void main(String[] args) {
        Pet myDog = new Pet("dog", "Ruffy", 3);
        myDog.printPetDetails();

        Pet newcat = new Pet("cat", "Princess", 2);
        newcat.printPetDetails();

        System.out.println("Last assigned ID:"+Pet.get_last_ID());

        // clone Pet object to a new ID
        Pet cat_copy = new Pet(newcat);
        cat_copy.printPetDetails();

        // change Name of cloned Pet
        cat_copy.set_name("Prince");
        cat_copy.printPetDetails();
    }

    static class Pet {
        // static: CLASS level attribute
        private static int newID = 0;
        // OBJECT level attributes
        private int petID;
        private String petType;
        private String petName;
        private int petAge;
    
        // default constructor
        // public Pet(){}

        // constructor - same name as the class
        // no return type, not even "void"
        public Pet(String type, String name, int age) {
            // set the next ID value in the CLASS
            newID = newID + 1;

            petID = newID;
            petType = type;
            petName = name;
            petAge = age;
        }
        
        // constructor without any paramters
        public Pet() {
            // callig an other constructor
            this("","",0);
        }

        // COPY constructor
        public Pet(Pet copyThisPet) {
            this(copyThisPet.petType, copyThisPet.petName, copyThisPet.petAge);
        }

        // GETter public member method for CLASS private attribute
        public static int get_last_ID() {
            return newID;
        }
        

        // GETter public member method for OBJECT private attribute
        public int get_age() {
            return this.petAge;
        }

        // SETter public member method for OBJECT private attribute
        public void set_name(String newName) {
            this.petName = newName;
        }
      
        public void printPetDetails() {
            System.out.println("Pet ID:"+petID+
                                ", Type:"+petType+
                                ", Name:"+petName+
                                ", Age:"+petAge);
        }
    
    }
}
