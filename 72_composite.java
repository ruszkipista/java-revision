import java.util.ArrayList;

class Composite_Pattern {
/*
Composite is a structural design pattern that lets you compose objects into
tree structures and then work with these structures as if they were individual objects.
*/    
    public static void main(String[] args) {
        // compose a tree
        BranchA me = new BranchA();
        BranchB parent1 = new BranchB();
        BranchB parent2 = new BranchB();
        Simple parent11 = new Simple();
        Simple parent12 = new Simple();
        Simple dog = new Simple();
        parent1.addComponent(parent11);
        parent1.addComponent(parent12);
        me.addComponent(parent1);
        me.addComponent(parent2);
        me.addComponent(dog);
        // traverse the tree with execute()
        me.execute();
    }

// The Component interface declares common operations for both
// Simple and Complex objects of a composition.
    interface Component{
        public void execute();
    }

// The Simple class represents end objects of a composition.
// A Simple object can't have any sub-objects. 
// Usually the Simple objects do the actual work, 
// while Complex objects only delegate to their sub-components.    
    static class Simple implements Component{
        @Override
        public void execute(){
            System.out.println("executed Simple");
        }    
    }

// The Complex abstract class represents components that may have children.
// Composite objects usually delegate the actual work to their children
// and then "sum up" the result.    
    static abstract class Complex implements Component{
        private ArrayList<Component> components;
        public Complex(){
            this.components = new ArrayList<Component>();
        }
        @Override
        public void execute(){
            System.out.println("executing components of Complex");
            for (Component c : components)
                c.execute();
            System.out.println("executed Complex");
        }

        public void addComponent(Component c){
            components.add(c);
        }
        public void removeComponent(Component c){
            components.remove(c);
        }        
        public ArrayList<Component> getComponents(){
            return components;
        }
    }

// There can be many types of Complex components!    
    static class BranchA extends Complex { }
    static class BranchB extends Complex { }
    static class BranchC extends Complex { }
}
