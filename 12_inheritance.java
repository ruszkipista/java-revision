class inheritance {
    public static void main(String[] args) {
        Undergrad joe = new Undergrad("John Doe", "Computer", 42);
        System.out.println(joe.name +" is "+ 
            joe.age + " years old with " +
            joe.major + " major");

        Zebra zeb = new Zebra("Ana",2);
        System.out.println(zeb.message());
        Dolphin dol = new Dolphin("Jin",3);
        System.out.println(dol.message());
    }

    // Super class
    static class Student{
        protected String name;
        public int age;
    }
    // Sub-class
    static class Undergrad extends Student{
        private String major;
        public Undergrad(String name, String major, int age){
            this.name = name;
            this.major = major;
            this.age = age;
        }
    }

    static class Animal {
        // private members
        private String name;
        private int age;
    
        public Animal(String name, int age) {
            this.age = age;
            this.name = name;
        }
    
        public String get_name(){
            return this.name;
        }
        public int get_age(){
            return this.age;
        }
        public String message(String type, String origin) {
            return "The "+type+" named "+get_name()+
            " is "+get_age()+" years old. "+
            "The "+type+" comes from "+origin;
        }
    }
    
    // derived class
    static class Zebra extends Animal {
        private static final String type = "zebra";
        private static final String origin = "Africa";
        public Zebra(String name, int age){super(name,age);}
        public String message() {
            return super.message(type,origin);
        }
    }
    
    static class Dolphin extends Animal {
        private static final String type = "dolphin";
        private static final String origin = "New Zealand";
        public Dolphin(String name, int age){super(name,age);}
        public String message() {
            return super.message(type,origin);
        }
    }
}
