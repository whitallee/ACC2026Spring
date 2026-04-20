/*File Proj09.java
The purpose of this assignment is to assess the student's
ability to write code dealing with Java streams. Student's
code must use streams to sort the String data in an
incoming array object in descending order and return the
sorted data in an object of type List.
***********************************************************/

// Student must not modify the code in this file. //

import java.util.*;
class Proj09{
  public static void main(String[] args){
    System.out.println("\nStudent must sort the data " +
      "using a stream.");
      
    String[] data = {"Not null"};
    if(args.length < 2){
      //Use default strings
      String[] temp = {"Tom","Dick","Harry"};
      data = temp;
    }else{
      //Use command-line arguments as strings
      data = args;
    }//end else
    
    //Display the data
    System.out.println("Input data = " + Arrays.asList(data));

    //Instantiate an object from the student's code.
    // Pass the data array as a parameter.
    System.out.println("Execute the student's code.\n");
    Proj09Runner obj = new Proj09Runner(data);
    
    //Execute the student's run method and display
    // the returned List object containing the 
    // original data sorted into descending order.
    List descendingOrder = obj.run();
    
    System.out.println(
      "Display List returned from student's code.");
    System.out.println(
      "\nSorted in Descending Order:\n " + descendingOrder);
    
  }//end main
}//end class Proj09
//End program specifications.