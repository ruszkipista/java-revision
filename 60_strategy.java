class Strategy_pattern {
/*
In Strategy pattern, a class behavior or its algorithm can be changed at run time. 
This type of design pattern comes under behavior pattern.
In Strategy pattern, we create objects which represent various strategies and a client object
whose behavior varies as per its strategy object.
The strategy object changes the executing algorithm of the client object.
*/      
    public static void main(String[] args) {
        IStrategy strategyA = new StrategyA();
        IStrategy strategyB = new StrategyB();
        // construct a client with strategy A
        Client client1 = new Client("X", strategyA);
        client1.demonstrate();
        // construct a client with Strategy B
        Client client2 = new Client("Y", strategyB);
        client2.demonstrate();
    }

    static class Client{
        String name;
        IStrategy algorithm;

        public Client(String name, IStrategy algorithm){
            this.name = name;
            this.algorithm = algorithm;
        }
        public String doAlgorithm(){
            return this.algorithm.execute();
        }
        public void demonstrate(){
            System.out.println("I am client "+this.name+" and "+this.doAlgorithm());
        }
    }

    interface IStrategy{
        public String execute();
    }

    static class StrategyA implements IStrategy{
        public String execute(){
            return "I do A";
        }
    }

    static class StrategyB implements IStrategy{
        public String execute(){
            return "I do B";
        }
    }

}