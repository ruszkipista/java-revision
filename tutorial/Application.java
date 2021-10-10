package tutorial;

import java.lang.Math;

public class Application {
  public static void main(String[] args) {
    Module m = new Module();
    m.printPI();
  }
}
class Module {
  void printPI(){
    System.out.println(Math.PI);
  }
}

/*
** Source File Declaration Rules **

Rules for declaring classes, import and package statements in a source file.

- There can be only one public class per source file.

- The public class name should be the name of the source file as well which 
  should be appended by .java at the end. 
  For example: the class name is public class Employee{} 
  then the source file should be as Employee.java.

- A source file can have multiple non-public classes.

- If the class is defined inside a package, then the package statement should be
  the first statement in the source file.

- If import statements are present, then they must be written between the package
  statement and the class declaration. If there are no package statements, 
  then the import statement should be the first line in the source file.

- Import and package statements will imply to all the classes present in the
  source file. It is not possible to declare different import and/or 
  package statements to different classes within one source file.

*/