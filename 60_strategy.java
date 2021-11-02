class Strategy_pattern {
/*
The Strategy Pattern defines a family of algorithms, encapsulates each one,
and makes them interchangeable.
Strategy lets the algorithm vary independently from clients that use it.
*/      
    public static void main(String[] args) {
        // construct a client with strategy A
        Client clientX = new Client("X", new StrategyA());
        clientX.doAlgorithm();
        // construct a client with Strategy B
        Client clientY = new Client("Y", new StrategyB());
        clientY.doAlgorithm();
        // replace algorithm in runtime
        clientY.setAlgorithm(new StrategyA());
        clientY.doAlgorithm();
    }

    static class Client{
        private String name;
        private IStrategy algorithm;

        public Client(String name, IStrategy algorithm){
            this.name = name;
            this.algorithm = algorithm;
        }
        public void setAlgorithm(IStrategy newAlgorithm){
            this.algorithm = newAlgorithm;
        }
        public void doAlgorithm(){
            System.out.println("I am client "+this.name+" and "+
                               this.algorithm.execute());
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