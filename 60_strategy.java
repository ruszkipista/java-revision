class Strategy_pattern {
/*
In Strategy pattern, a class behavior or its algorithm can be changed at run time. 
This type of design pattern comes under behavior pattern.
In Strategy pattern, we create objects which represent various strategies and a client object
whose behavior varies as per its strategy object.
The strategy object changes the executing algorithm of the client object.
https://youtu.be/v9ejT8FO-7I
*/      
    public static void main(String[] args) {
        // construct a client with strategy A
        Client client1 = new Client("X", new StrategyA());
        client1.doAlgorithm();
        // construct a client with Strategy B
        Client client2 = new Client("Y", new StrategyB());
        client2.doAlgorithm();
    }

    static class Client{
        private String name;
        private IStrategy algorithm;

        public Client(String name, IStrategy algorithm){
            this.name = name;
            this.algorithm = algorithm;
        }
        public void doAlgorithm(){
            System.out.println("I am client "+this.name+
                               " and "+this.algorithm.execute());
        }
    }

    interface IStrategy{
        public String execute();
    }

    static class StrategyA implements IStrategy{
        @Override
        public String execute(){
            return "I do A";
        }
    }

    static class StrategyB implements IStrategy{
        @Override
        public String execute(){
            return "I do B";
        }
    }

}