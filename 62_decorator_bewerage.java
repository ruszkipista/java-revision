class Decorator_Pattern_bewerage {
/*
The Decorator Pattern attaches additional responsibilities to an object dynamically.
Decorators provide a flexible alternative to subclassing for extending functionality.
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
        // give 10% discount
        servedCoffe = new DiscountDecoratedBewerage("-10% discount", 0.1, servedCoffe);
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
    }

    // a concrete class of DecoratedBewerage
    // cumulates the price
    static class AddOnDecoratedBewerage extends DecoratedBewerage{
        public AddOnDecoratedBewerage(String description, double price, Bewerage decorated){
            super(description, price, decorated);
        }
        @Override
        public double getPrice(){
            return this.decoratedBewerage.getPrice() + this.price;
        }
    }

    // another concrete class of DecoratedBewerage
    // discounts the price
    static class DiscountDecoratedBewerage extends DecoratedBewerage{
        public DiscountDecoratedBewerage(String description, double price, Bewerage decorated){
            super(description, price, decorated);
        }
        @Override
        public double getPrice(){
            return this.decoratedBewerage.getPrice() * (1-this.price);
        }
    }
}