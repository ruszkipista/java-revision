class Factory_pattern_dynamic {
/*
Factory method is a creational design pattern which solves the problem
of creating product objects without specifying their concrete classes.
Factory Method defines a method, which should be used for creating objects
instead of direct constructor call (new operator). Subclasses can override
this method to change the class of objects that will be created.
*/
    public static void main(String[] args) {
        ShapeFactory ssf = new SolidShapeFactory();
        DrawingApp da = new DrawingApp(ssf);
        da.buildModel();
        da.drawModel();
    }
    
    static class DrawingApp{
        ShapeFactory sf;
        Shape[] model = new Shape[3];
        public DrawingApp(ShapeFactory sf){
            this.sf = sf;
        }
        public void buildModel(){
            model[0] = this.sf.createShape(SolidShapeFactory.TRIANGLE);
            model[1] = this.sf.createShape(SolidShapeFactory.RECTANGLE);
            model[2] = this.sf.createShape(SolidShapeFactory.CIRCLE);
        }
        public void drawModel(){
            for(Shape s:this.model)
                s.draw();
        }
    }

    // Shape interface to be implemented by sub-classes of ShapeFactory
    protected interface Shape{
        public void draw();
    }

    interface ShapeFactory{
        public Shape createShape(String shape);
    }
    
    static class SolidShapeFactory implements ShapeFactory{
        public static final String TRIANGLE  = "TRIANGLE";
        public static final String RECTANGLE = "RECTANGLE";
        public static final String CIRCLE    = "CIRCLE";
        public static final String OVAL      = "OVAL";

        @Override
        // public method creates an instance of a Shape(ish) class
        public Shape createShape(String shape){
            Shape shapeInst = null;
            if (shape.equalsIgnoreCase(TRIANGLE))
                shapeInst = new Triangle();
            else if (shape.equalsIgnoreCase(RECTANGLE))
                shapeInst = new Rectangle();
            else if (shape.equalsIgnoreCase(CIRCLE))
                shapeInst = new Circle();
            else if (shape.equalsIgnoreCase(OVAL))
                shapeInst = new Oval();
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
        private static class Oval implements Shape{
            @Override
            public void draw(){
                System.out.println("Drawing an oval");
            }
        }        
    }
}