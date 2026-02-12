/*File Proj03.java
The purpose of this assignment is to assess the student's
ability to write a program dealing with runtime polymorphism
and the Comparator interface.
***********************************************************/

// Student must not modify the code in this file. //

import java.util.*;
class Proj03{

  
  //Create an array object containing references to eight
  // String objects representing people's names.
  static String[] names = 
  {"Don","don","Bill","bill","Ann","ann","Chris","chris"};
  
  //Create an empty array with space for references to
  // eight String objects. Each element initially 
  // contains null.
  static String[] myArray = new String[8];
  
  //Define the main method
  public static void main(String args[]){
    //Print the certification
    System.out.println();//blank line
    new Proj03Runner();//Call an overloaded constructor.

    //Create a pseudo-random number generator
    Random generator = null;
    if(args.length != 0){
      //User entered a command-line argument. Use it
      // for the seed.
      generator = new Random(Long.parseLong(args[0]));
    }else{
      //User did not enter a command-line argument.
      // Get a seed based on date and time.
      generator = new Random(new Date().getTime());
    };
    
    //Create and display the data for input to the class
    // named Proj03Runner. Use successive values from 
    // the random number generator to select a set of
    // String objects from the array containing names.
    System.out.print("Input:               ");
    for(int cnt = 0;cnt < 8;cnt++){
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
    //At this point, the array named myArray contains
    // eight names that were selected at random.
    System.out.println();//new line

    
    //Create an ArrayList object.
    ArrayList arrayList = new ArrayList();
    
    //Call the student's overloaded constructor
    // several times in succession to populate
    // the ArrayList object.
    for(int cnt=0;cnt < myArray.length;cnt++){
      arrayList.add(new Proj03Runner(myArray[cnt]));
    }//end for loop

    //Display the data in the ArrayList object
    System.out.print("ArrayList contents:  ");
    Iterator iter = arrayList.iterator();
    while(iter.hasNext()){
      System.out.print(iter.next() + " ");
    }//end while loop
    System.out.println();//blank line
    
    //Create a TreeSet object. Note that the class named
    // Proj03Runner mus implement the Comparator 
    // interface.
    TreeSet treeSet = new TreeSet(
                             new Proj03Runner("dummy"));
    for(int cnt=0;cnt < myArray.length;cnt++){
      treeSet.add(myArray[cnt]);
    }//end for loop

    //Display the data in the TreeSet object
    System.out.print("TreeSet contents:    ");
    iter = treeSet.iterator();
    while(iter.hasNext()){
      System.out.print(iter.next() + " ");
    }//end while loop
    System.out.println();//blank line
  
  }//end main

}//end class Proj03
//End program specifications.