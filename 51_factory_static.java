class Factory_pattern_static_method {
/*
Factory method is a creational design pattern which solves the problem
of creating product objects without specifying their concrete classes.
Factory Method defines a method, which should be used for creating objects
instead of direct constructor call (new operator). Subclasses can override
this method to change the class of objects that will be created.
*/
    public static void main(String[] args) {
        Shape shape1 = ShapeFactory.createShape(ShapeFactory.Shapes.TRIANGLE);
        shape1.draw();
        Shape shape2 = ShapeFactory.createShape(ShapeFactory.Shapes.RECTANGLE);
        shape2.draw();
        ShapeFactory.createShape(ShapeFactory.Shapes.CIRCLE).draw();
    }
    
    // Shape interface to be implemented by sub-classes of ShapeFactory
    protected interface Shape{
        public void draw();
    }

    static class ShapeFactory{
        protected static enum Shapes{TRIANGLE, RECTANGLE, CIRCLE};

        // public static method creates an instance of a Shape(ish) class
        public static Shape createShape(Shapes shape){
            Shape shapeInst = null;
            switch (shape){
                case TRIANGLE:
                    shapeInst = new Triangle();
                    break;
                case RECTANGLE:
                    shapeInst = new Rectangle();
                    break;
                case CIRCLE:
                    shapeInst = new Circle();
                    break;
            }
            return shapeInst;
        }

        private static class Triangle implements Shape{
            @Override
            public void draw(){
                System.out.println("Drawing a triangle");
            }
        }
        private static class Rectangle implements Shape{
            @Override
            public void draw(){
                System.out.println("Drawing a rectangle");
            }
        }
        private static class Circle implements Shape{
            @Override
            public void draw(){
                System.out.println("Drawing a circle");
            }
        }

    }
}