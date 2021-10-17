import java.util.Hashtable;

class Prototype_pattern {
/*
The Prototype pattern refers to creating duplicate object while keeping performance in mind.
This type of design pattern comes under creational patterns.
This pattern involves implementing a prototype interface which tells to create a clone
of the current object. This pattern is used when direct creation of an object is costly.
For example, an object is created after a costly database operation. We can cache the object,
returns its clone on next request.
We create an abstract class Shape and concrete classes extending the Shape class.
A class ShapeCache is defined as a next step which stores shape objects in a Hashtable
and returns their clone when requested.
*/
    public static void main(String[] args) {
        // create original objects and put them into cache
        Circle shape1 = new Circle(5);
        String shapeId1 = ShapeCache.put(shape1);  
        String shapeId2 = ShapeCache.put(new Square(7));  
        String shapeId3 = ShapeCache.put(new Rectangle(5,6));  

        Shape clonedShape1 = ShapeCache.getCloneOf(shapeId1);
        clonedShape1.draw();
        System.out.println("Shape1 is the same as ClonedShape1: "+(shape1==clonedShape1));
  
        Shape clonedShape2 = ShapeCache.getCloneOf(shapeId2);
        clonedShape2.draw();
  
        Shape clonedShape3 = ShapeCache.getCloneOf(shapeId3);
        clonedShape3.draw();
    }

    static class ShapeCache {
        private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

        public static String put(Shape shape) {
            String id = shape.getType();
            shapeMap.put(id, shape);
            return id;
        }

        public static Shape getCloneOf(String shapeId) {
           Shape cachedShape = shapeMap.get(shapeId);
           return (Shape) cachedShape.clone();
        }
     }

    // Shape abstract class implements Cloneable
    public static abstract class Shape implements Cloneable {
        protected final String type;

        private Shape(String type){ this.type = type;}

        public String getType(){return type;}

        public abstract double getArea();
        
        public void draw(){
            System.out.println("Inside "+type+"::draw() method, area: "+getArea());
        }
        // https://en.wikipedia.org/wiki/Clone_%28Java_method%29
        @Override
        public Object clone() {
           Object clone = null;          
           try {
              clone = super.clone();
           } catch (CloneNotSupportedException e) {
              e.printStackTrace();
           }
           return clone;
        }
    }

    static class Rectangle extends Shape {
        private final double sideA;
        private final double sideB;
        public Rectangle(double a, double b){
            super("Rectangle");
            this.sideA=a;
            this.sideB=b;
        }
        public double getArea(){return sideA*sideB;}
    }

    static class Square extends Shape {
        private final double sideA;
        public Square(double a){
            super("Square");
            this.sideA=a;
        }
        public double getArea(){return sideA*sideA;}
    }

    static class Circle extends Shape {
        private final double radius;
        public Circle(double radius){
            super("Circle");
            this.radius=radius;
        }
        public double getArea(){return radius*radius*Math.PI;}
    }
}