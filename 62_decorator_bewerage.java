class Decorator_pattern_bewerage {
/*
*/    
    public static void main(String[] args) {
        // create base object
        Bewerage servedCoffe = new Coffe("Light Roasted Coffee", 1.5);
        // add milk
        servedCoffe = new AddOnDecoratedBewerage("milk", 0.50, servedCoffe);
        // add two sugar
        servedCoffe = new AddOnDecoratedBewerage("sugar", 0.25, servedCoffe);
        servedCoffe = new AddOnDecoratedBewerage("sugar", 0.25, servedCoffe);
        // print description and price
        System.out.println(servedCoffe.getDescription()
                            +" price: " + servedCoffe.getPrice());
    }


    // abstract class of Bewerage
    static abstract class Bewerage{
        protected String description;
        protected double price;
        protected Bewerage(String description, double price){
            this.description = description;
            this.price = price;
        }
        public String getDescription(){ return description; }
        public double getPrice(){ return price; }
    }

    // a concrete class of Bewerage
    static class Coffe extends Bewerage{
        public Coffe(String description, double price){
            super(description, price);
        }
    }

    // decorator abstract class for Bewerage
    static abstract class DecoratedBewerage extends Bewerage{
        protected Bewerage decoratedBewerage;
        protected DecoratedBewerage(String description, 
                                    double price, 
                                    Bewerage decoratedBewerage){
            super(description, price);
            this.decoratedBewerage = decoratedBewerage;
        }
        @Override
        public String getDescription(){ 
            return this.decoratedBewerage.getDescription() 
                  +", " + this.description;
        }
        @Override
        public double getPrice(){
            return this.decoratedBewerage.getPrice() + this.price;
        }
    }

    // concrete class of DecoratedBewerage
    static class AddOnDecoratedBewerage extends DecoratedBewerage{
        public AddOnDecoratedBewerage(String description, double price, Bewerage decorated){
            super(description, price, decorated);
        }
    }

}