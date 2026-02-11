/*File Proj01.java
The purpose of this assignment is to assess the student's
ability to write a program dealing with basic Collection
Framework concepts and methods.
***********************************************************/

// Student must not modify the code in this file. //

import java.util.*;
class Proj01{
  public static void main(String[] args){
    
    //Create a pseudo-random number generator
    Random generator = null;
    if(args.length != 0){
      generator = new Random(Long.parseLong(args[0]));
    }else{
      generator = new Random(new Date().getTime());
    };
    
    //Generate some small positive random numbers and store
    // them in an array object of type int.
    int[] vals = {Math.abs(generator.nextInt())%5,
                  Math.abs(generator.nextInt())%5,
                  Math.abs(generator.nextInt())%5,
                  Math.abs(generator.nextInt())%5,
                  Math.abs(generator.nextInt())%5,
                  Math.abs(generator.nextInt())%5
                  };
    System.out.println();//blank line
    
    //Instantiate an object from the student's code.
    // Pass the vals array as a parameter.
    Proj01Runner obj = new Proj01Runner(vals);
    
    //Display the data in the vals array.
    for(int cnt = 0;cnt < vals.length;cnt++){
      System.out.print(vals[cnt] + " ");
    }//end for loop
    System.out.println();//blank line
    
    //Call the runA method on the student's object. Store
    // the return value in a reference variable named ref
    // of type Collection.
    Collection ref = obj.runA();

    //Display the return values from the runA method
    Iterator iter = ref.iterator();
    while(iter.hasNext()){
      System.out.print(iter.next() + " ");
    }//end while loop
    System.out.println();//blank line

    //Call the runB method on the student's object. Store
    // the return value in the reference variable named ref
    // of type Collection.
    ref = obj.runB();
    
    //Display the return values and the sum of the
    // return values from the runB method
    int sum = 0;
    iter = ref.iterator();
    while(iter.hasNext()){
      Integer myObj = (Integer)(iter.next());
      System.out.print(myObj + " ");
      sum += myObj.intValue();
    }//end while loop
    
    System.out.println("\nSum = " + sum);

    System.out.println();//blank line

  }//end main
}//end class Proj01
//End program specifications.