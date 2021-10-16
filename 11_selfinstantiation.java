// demonstrate how a class instatiate itself

class SelfInstantiation {
// instance variable
   String instanceVar; //instance variable
           
// @param args the command line arguments
    public static void main(String[] args) {
      SelfInstantiation selfInst = new SelfInstantiation(); //instantiation
      selfInst.instanceVar = "HatTrick";
      selfInst.displayInstanceVar();
    }
//  instance method    
    void displayInstanceVar() {
        System.out.println("Content of instance variable is: " + this.instanceVar);
    }
}