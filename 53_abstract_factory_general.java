import java.util.Random;

class Abstract_Factory_Pattern {
    /*
    Abstract Factory patterns work with a super-factory which creates other factories.
    This factory is also called as factory of factories. This type of design pattern comes
    under creational patterns.
    In Abstract Factory pattern an interface is responsible for creating a factory of related
    objects without explicitly specifying their classes. 
    Each generated factory can provide the objects as per the Factory Pattern.
    */
    public static void main(String[] args) {
        ProductFactory factory = SuperFactory.getProductFactory();
        factory.createProductX(); 
        factory.createProductY(); 
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
        public abstract ProductX createProductX();
        public abstract ProductY createProductY();
    }
    // concrete class
    static class FactoryA implements ProductFactory{
        public FactoryA(){ System.out.println("Factory A created"); }
        @Override
        public ProductX createProductX() {
            return new ProductAX();
        }
        @Override
        public ProductY createProductY() {
            return new ProductAY();
        }
    }
    // concrete class
    static class FactoryB implements ProductFactory {
        public FactoryB(){ System.out.println("Factory B created"); }
        @Override
        public ProductX createProductX() {
            return new ProductBX();
        }
        @Override
        public ProductY createProductY() {
            return new ProductBY();
        }
    }
    // interface
    static interface ProductX { }
    // interface
    static interface ProductY { }

    // concrete classes    
    static class ProductAX implements ProductX {
        public ProductAX() { System.out.println("ProductAX created"); }
    }
    static class ProductBX implements ProductX {
        public ProductBX() { System.out.println("ProductBX created"); }
    }
    static class ProductAY implements ProductY {
        public ProductAY() { System.out.println("ProductAY created"); }
    }
    static class ProductBY implements ProductY {
        public ProductBY() { System.out.println("ProductBY created"); }
    }
}