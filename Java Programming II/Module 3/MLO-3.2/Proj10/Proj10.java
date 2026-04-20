/*File Proj10.java
The purpose of this assignment is to assess the student's
ability to write programs that use functional interfaces.
***********************************************************/

// Student must not modify the code in this file. //

class Proj10 {
  public static void main(String[] args) {
    String x = "Hello ";
    int y = 7;
    
    if(args.length != 2){
      System.out.println("Use default input values, Hello and 7");
    }else{//get x and y from args
      x = args[0];
      y = Integer.parseInt(args[1]);
    };//end else
    
    System.out.println(
      "\nInput values to student code = " + x + "," + y);
    System.out.println(
      "\nStudent's solution must use functional interfaces.");

    System.out.println(
      "\nInstantiate an object from the student's code.\n");
    Proj10Runner runner = new Proj10Runner();
    
    System.out.println(
      "\nCall methods in the student's runner class\n" +
      "and print returned values.");
    System.out.println(runner.getLength(x));
    System.out.println(runner.isEven(y));
    System.out.println(runner.concatenate(x,x));
    System.out.println("Thats All Folks");
  }//end main
}//end class Proj10



