class DuckSimU {
    /*
    In Strategy pattern, a class behavior or its algorithm can be changed at run time. 
    This type of design pattern comes under behavior pattern.
    In Strategy pattern, we create objects which represent various strategies and a client object
    whose behavior varies as per its strategy object.
    The strategy object changes the executing algorithm of the client object.
    https://youtu.be/v9ejT8FO-7I
    */      
    public static void main(String[] args) {
        // construct a Mallard duck
        Duck mallardDuck = new MallardDuck();
        mallardDuck.describe();
        // construct a rubber duck
        Duck rubberDuck = new RubberDuck();
        rubberDuck.describe();
        // replace Fly behaviour
        rubberDuck.setFlyBehaviour(new FlyIfThrown());
        rubberDuck.describe();
        // replace Quack behaviour
        rubberDuck.setQuackBehaviour(new Squeak());
        rubberDuck.describe();
        DuckCall duckCall = new DuckCall();
        duckCall.describe();
    }

    // DUCK
    static abstract class Duck{
        private String name;
        private FlyBehaviour flyBehaviour;
        private QuackBehaviour quackBehaviour;
        public Duck(String name, FlyBehaviour flyBehaviour, QuackBehaviour quackBehaviour){
            this.name = name;
            this.flyBehaviour = flyBehaviour;
            this.quackBehaviour = quackBehaviour;
        }

        public void setFlyBehaviour(FlyBehaviour newFlyBehaviour){
            this.flyBehaviour = newFlyBehaviour;
        }
        public void setQuackBehaviour(QuackBehaviour newQuackBehaviour){
            this.quackBehaviour = newQuackBehaviour;
        }
        public void performFly(){
            this.flyBehaviour.fly();
        }
        public void performQuack(){
            this.quackBehaviour.quack();
        }
        public void describe(){
            System.out.print("I am a "+this.name+" and ");
            this.performFly();
            System.out.print(" and ");
            this.performQuack();
            System.out.println();
        }
    }

    // this class knows, how a Mallard duck flies and quacks
    static class MallardDuck extends Duck{
        public MallardDuck(){
            super("Mallard Duck", new FlyWithWings(), new Quack());
        }
    }
    static class RubberDuck extends Duck{
        public RubberDuck(){
            super("Rubber Duck", new CanNotFly(), new Silent());
        }
    }

    // FLY
    interface FlyBehaviour{
        public void fly();
    }

    static class FlyWithWings implements FlyBehaviour{
        @Override
        public void fly(){
            System.out.print("I fly with wings");
        }
    }

    static class CanNotFly implements FlyBehaviour{
        @Override
        public void fly(){
            System.out.print("I can not fly");
        }
    }

    static class FlyIfThrown implements FlyBehaviour{
        @Override
        public void fly(){
            System.out.print("I fly when thrown");
        }
    }

    // QUACK
    interface QuackBehaviour{
        public void quack();
    }

    static class Quack implements QuackBehaviour{
        @Override
        public void quack(){
            System.out.print("I Quack!");
        }
    }
    
    static class Silent implements QuackBehaviour{
        @Override
        public void quack(){
            System.out.print("I do not make a sound");
        }
    }

    static class Squeak implements QuackBehaviour{
        @Override
        public void quack(){
            System.out.print("I Squeak!");
        }
    }

    static class DuckCall{
        private QuackBehaviour quackBehaviour;
        public DuckCall(){
            this.quackBehaviour = new Quack();
        }
        public void performQuack(){
            this.quackBehaviour.quack();
        }
        public void describe(){
            System.out.print("I am a Duck Call and ");
            this.performQuack();
            System.out.println();
        }
    }
}