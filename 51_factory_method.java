import java.util.Random;

class Factory_Method_dynamic {
/*
Factory method is a creational design pattern which solves the problem
of creating product objects without specifying their concrete classes.
Factory Method defines a method, which should be used for creating objects
instead of direct constructor call (new operator). Subclasses can override
this method to change the class of objects that will be created.
*/
    public static void main(String[] args) {
        ProductFactory factory = SuperFactory.getProductFactory();
        factory.createProduct();  
    }

    // concrete static factory class
    static class SuperFactory{
        public static ProductFactory getProductFactory(){
            ProductFactory factory = null;
            // factory type selection is an internal process
            int factoryType = (new Random()).nextInt(2);
            switch (factoryType){
                case 0:
                    factory = new FactoryA();
                    break;
                case 1:
                    factory = new FactoryB();
                    break;
            }
            return factory;
        }
    }

    // interface
    static interface ProductFactory {
        public abstract Product createProduct();
    }
    // concrete class
    static class FactoryA implements ProductFactory{
        public FactoryA(){ System.out.println("Factory A created"); }
        @Override
        public Product createProduct() {
            return new ProductA();
        }
    }
    // concrete class
    static class FactoryB implements ProductFactory {
        public FactoryB(){ System.out.println("Factory B created"); }
        @Override
        public Product createProduct() {
            return new ProductB();
        }
    }
    // interface
    static interface Product { }

    // concrete classes    
    static class ProductA implements Product {
        public ProductA() { System.out.println("ProductA created"); }
    }
    static class ProductB implements Product {
        public ProductB() { System.out.println("ProductB created"); }
    }

}