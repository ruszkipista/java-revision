// demonstrate how a class instatiate itself

class SelfInstantiation {
// instance variable
   public String varInst; //instance variable
           
// @param args the command line arguments
    public static void main(String[] args) {
      SelfInstantiation clsInst = new SelfInstantiation(); //instantiation
      clsInst.varInst = "HatTrick";
      clsInst.displayVarInst();
    }
//  instance method    
    private void displayVarInst() {
        System.out.println("Content of instance variable is: " + this.varInst);
    }
}