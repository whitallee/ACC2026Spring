/*File Proj12.java
The purpose of this assignment is to assess the student's
ability to write programs that use lambda expressions and
the Predicate functional interface from the 
java.util.function package.
***********************************************************/

// Student must not modify the code in this file. //

class Proj12{
  public static void main(String[] args){
    String x = "Madam";
    String y = "radar";
    String z = "defied";
    
    if(args.length != 3){
      System.out.println("Use default input values.");
    }else{//get x, y, and z from args
      System.out.println("Use command-line arguments.");
      x = args[0];
      y = args[1];
      z = args[2];
    };//end else
    
    System.out.println(
      "\nInput values to student code = " + 
      x + "," + y + "," + z);
    System.out.println(
      "\nStudent's solution must use lambda expressions.");

    //Instantiate an object from the student's code.
    Proj12Runner obj = new Proj12Runner();
    
    System.out.println("\nCall student's run method.");
    boolean[] result = obj.run(x,y,z);

    System.out.println(
      "\nDisplay results returned from student's code.");
    System.out.println(x + ": " + result[0]);
    System.out.println(y + ": " + result[1]);
    System.out.println(z + ": " + result[2]);

    System.out.println("\nThat's all folks.");

  }//end main
}//end class Proj12
//End program specifications.