class Abstract_Factory_Pattern_Shapes {
/*
Abstract Factory patterns work with a super-factory which creates other factories.
This factory is also called as factory of factories. This type of design pattern comes
under creational patterns.
In Abstract Factory pattern an interface is responsible for creating a factory of related
objects without explicitly specifying their classes. 
Each generated factory can provide the objects as per the Factory Pattern.
*/
    public static void main(String[] args) {
        ShapeFactory ssFactory = AbstractFactory.create(ShapeFactory.Types.SHARP);
        ShapeFactory rsFactory = AbstractFactory.create(ShapeFactory.Types.ROUNDED);

        Shape shape1 = ssFactory.create(Shape.Types.TRIANGLE);
        Shape shape2 = ssFactory.create(Shape.Types.RECTANGLE);
        Shape shape3 = rsFactory.create(Shape.Types.TRIANGLE);
        Shape shape4 = rsFactory.create(Shape.Types.RECTANGLE);

        shape1.draw();
        shape2.draw();
        shape3.draw();
        shape4.draw();
    }

    // static class to generate ShapeFactory objects
    public static class AbstractFactory{

        public static ShapeFactory create(ShapeFactory.Types type){
            ShapeFactory factory = null;
            switch (type){
                case SHARP:
                    factory = new SharpShapeFactory();
                    break;
                case ROUNDED:
                    factory = new RoundedShapeFactory();
                    break;
            }
            return factory;
        }
    }

    // ShapeFactory interface to be implemented by sub-classes
    protected interface ShapeFactory{
        public static enum Types{SHARP,ROUNDED};
        public Shape create(Shape.Types shape);
    }

    // Shape interface to be implemented by sub-classes
    protected interface Shape{
        public static enum Types{TRIANGLE, RECTANGLE};
        public void draw();
    }

    public static class SharpShapeFactory implements ShapeFactory{

        // public static method creates an instance of a Shape(ish) class
        @Override
        public Shape create(Shape.Types shape){
            Shape shapeInst = null;
            switch (shape){
                case TRIANGLE:
                    shapeInst = new SharpTriangle();
                    break;
                case RECTANGLE:
                    shapeInst = new SharpRectangle();
                    break;
            }
            return shapeInst;
        }

        private static class SharpTriangle implements Shape{
            @Override
            public void draw(){
                System.out.println("Drawing a sharp triangle");
            }
        }
        private static class SharpRectangle implements Shape{
            @Override
            public void draw(){
                System.out.println("Drawing a sharp rectangle");
            }
        }
    }

    public static class RoundedShapeFactory implements ShapeFactory{

        // public static method creates an instance of a Shape(ish) class
        @Override
        public Shape create(Shape.Types shape){
            Shape shapeInst = null;
            switch (shape){
                case TRIANGLE:
                    shapeInst = new RoundedTriangle();
                    break;
                case RECTANGLE:
                    shapeInst = new RoundedRectangle();
                    break;
            }
            return shapeInst;
        }

        private static class RoundedTriangle implements Shape{
            @Override
            public void draw(){
                System.out.println("Drawing a rounded triangle");
            }
        }
        private static class RoundedRectangle implements Shape{
            @Override
            public void draw(){
                System.out.println("Drawing a rounded rectangle");
            }
        }
    }
}