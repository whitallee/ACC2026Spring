/*File Proj11.java
The purpose of this assignment is to assess the student's
ability to write programs that use lambda expressions
***********************************************************/

// Student must not modify the code in this file. //

class Proj11{
  public static void main(String[] args){
    int x = 10;
    int y = 3;
    
    if(args.length != 2){
      System.out.println("Use default input values, 10 and 3");
    }else{//get x and y from args
      x = Integer.parseInt(args[0]);
      y = Integer.parseInt(args[1]);
    };//end else
    
    System.out.println(
      "\nInput values to student code = " + x + "," + y);
    System.out.println(
      "\nStudent's solution must use lambda expressions.");

    //Instantiate an object from the student's code.
    Proj11Runner obj = new Proj11Runner();
    
    System.out.println("\nCall student's run method.\n");
    double[] result = obj.run(x,y);

    System.out.println(
      "\nDisplay results returned from student's code.");
    System.out.println("Sum: " + result[0]);
    System.out.println("Difference: " + result[1]);
    System.out.println("Product: " + result[2]);
    System.out.println("Quotient: " + result[3]);

    System.out.println("That's all folks.");

  }//end main
}//end class Proj11
//End program specifications.