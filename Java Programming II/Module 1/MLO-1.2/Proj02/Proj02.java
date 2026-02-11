/*File Proj02.java
The purpose of this assignment is to assess the student's
ability to write a program dealing with runtime polymorphism
and the Comparable interface.
***********************************************************/

// Student must not modify the code in this file. //

import java.util.*;
class Proj02{
  public static void main(String[] args){
    
    //Create a pseudo-random number generator
    Random generator = null;
    if(args.length != 0){
      generator = new Random(Long.parseLong(args[0]));
    }else{
      generator = new Random(new Date().getTime());
    };
    
    //Generate some small positive random numbers and
    // save them in an array object of type int..
    int[] vals = {Math.abs(generator.nextInt())%5,
                  Math.abs(generator.nextInt())%5,
                  Math.abs(generator.nextInt())%5,
                  Math.abs(generator.nextInt())%5,
                  Math.abs(generator.nextInt())%5,
                  Math.abs(generator.nextInt())%5
                  };
    //Print certification
    System.out.println();//blank line
    new Proj02Runner();//Call an overloaded constructor.
    
    //Display the data in the vals array.
    for(int cnt = 0;cnt < vals.length;cnt++){
      System.out.print(vals[cnt] + " ");
    }//end for loop
    System.out.println();//blank line
    
    //Create an ArrayList object.
    ArrayList arrayList = new ArrayList();
    
    //Call the student's overloaded constructor
    // several times in succession to populate
    // the ArrayList object.
    for(int cnt=0;cnt < vals.length;cnt++){
      arrayList.add(new Proj02Runner(vals[cnt]));
    }//end for loop

    //Display the data in the ArrayList object
    Iterator iter = arrayList.iterator();
    while(iter.hasNext()){
      System.out.print(iter.next() + " ");
    }//end while loop
    System.out.println();//blank line

    //Create a TreeSet object.
    TreeSet treeSet = new TreeSet();
    
    //Call the student's overloaded constructor
    // several times in succession to populate
    // the TreeSet object.
    for(int cnt=0;cnt < vals.length;cnt++){
      treeSet.add(new Proj02Runner(vals[cnt]));
    }//end for loop

    //Display the data in the TreeSet object
    iter = treeSet.iterator();
    while(iter.hasNext()){
      System.out.print(iter.next() + " ");
    }//end while loop
    System.out.println();//blank line

  }//end main
}//end class Proj02
//End program specifications.