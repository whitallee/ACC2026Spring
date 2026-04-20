/*File Proj04 Copyright 2008 R.G.Baldwin
The purpose of this assignment is to assess the student's
ability to write a program dealing with sorting, arrays, 
and collections.
***********************************************************/
// Student must not modify the code in this file.

import java.util.*;

class Proj04{
  //Create an array containing names that will be used
  // later.
  static String[] names = 
  {"Don","don","Bill","bill","Ann","ann","Chris","chris"};
  
  //Create an empty array that will be populated with
  // randomly selected names and used later.
  static Object[] myArray = new String[8];
  
  //Begin the main method
  public static void main(String args[]){

    //Instantiate a new object of the student's class
    // and display the certification.
    Proj04Runner runner = new Proj04Runner();
    
    //Create a pseudo-random number generator
    Random generator = null;
    if(args.length != 0){
      //User entered a command-line argument. Use it
      // for the seed.
      System.out.println("seed = " + args[0] );
      generator = new Random(Long.parseLong(args[0]));
    }else{
      //User did not enter a command-line argument.
      // Get a seed based on date and time.
      long seed = new Date().getTime();
      System.out.println("seed = " + seed);
      generator = new Random(new Date().getTime());
    };
    
    //Create and display the data for input to the class
    // named Proj04Runner.
    System.out.print("Input:  ");
    for(int cnt = 0;cnt < myArray.length;cnt++){
      int index = ((byte)generator.nextInt())/16;
      if(index < 0){
        index = -index;
      }//end if
      if(index >= 8){
        index = 7;
      }//end if
      myArray[cnt] = names[index];
      System.out.print(myArray[cnt] + " ");
    }//end for loop
    System.out.println();//new line

    //Process the data, get, and display intermediate
    // results.
    myArray = runner.runA(myArray);
    
    System.out.print("Intermediate Results: ");
    for(int cnt = 0; cnt<myArray.length;cnt++){
      System.out.print(myArray[cnt] + " ");
    }//end for loop
    System.out.println();

    //Finish processing the data, get, and display
    // final results.
    Collection collection = runner.runB();
 
    System.out.print("Final Results:        ");
    Iterator iter = collection.iterator();
    while(iter.hasNext()){
      System.out.print(iter.next() + " ");
    }//end while loop
    System.out.println();

  }//end main()
  //----------------------------------------------------//

}//end class Proj04

