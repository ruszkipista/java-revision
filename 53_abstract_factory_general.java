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
        String type = "B";
        AbstractFactory factory;
        
        if ("A".equals(type))
            factory = new FactoryA();
        else
            factory = new FactoryB();
        factory.createProductX(); 
        factory.createProductY(); 
}
    
    static abstract class AbstractFactory {
        public abstract ProductX createProductX();
        public abstract ProductY createProductY();
    }
    static class FactoryA extends AbstractFactory{
		
        @Override
        public ProductX createProductX() {
            return new ProductAX();
        }
        
        @Override
        public ProductY createProductY() {
            return new ProductAY();
        }
    }
    static class FactoryB extends AbstractFactory {
        @Override
        public ProductX createProductX() {
            return new ProductBX();
        }
        
        @Override
        public ProductY createProductY() {
            return new ProductBY();
        }
    }

    static abstract class ProductX {
    }
    static abstract class ProductY {
    }

    static class ProductAX extends ProductX {
        public ProductAX() { System.out.println("ProductAX created"); }
    }
    static class ProductBX extends ProductX {
        public ProductBX() { System.out.println("ProductBX created"); }
    }
    static class ProductAY extends ProductY {
        public ProductAY() { System.out.println("ProductAY created"); }
    }
    static class ProductBY extends ProductY {
        public ProductBY() { System.out.println("ProductBY created"); }
    }
}