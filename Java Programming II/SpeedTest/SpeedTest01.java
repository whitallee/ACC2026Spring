/*File SpeedTest01
Copyright R.G.Baldwin
**************************************/

import java.util.*;

public class SpeedTest01{
  public static void main(String args[]){
    new Worker().doIt();
  }//end main()
}//end class SpeedTest01

class Worker{
  public void doIt(){
    int size = 2000000;
    //Create a TreeSet object
    Collection aTree = new TreeSet();

    //Populate the TreeSet object with
    // random values.  The add() method
    // for a set rejects duplicates.
    Random rnGen = new Random();
    for(int ct = 0; ct < size; ct++){
      aTree.add(new Double(rnGen.nextDouble()));
    }//end for loop

    //Create and populate an ArrayList
    // object with the same random
    // values
    Collection aList = new ArrayList(aTree);

    //Extract a value near the center
    // of the ArrayList object to use
    // as a test case.
    Object testVal = ((List)aList).get(size/2);

    //Search for the test value in each
    // of the collection objects.
    // Measure and display the time
    // required to perform the search
    // in each case.
    long start = new Date().getTime();
    boolean found = aList.contains(testVal);
    long stop = new Date().getTime();
    System.out.println(found + " " + (stop - start));

    start = new Date().getTime();
    for(int x = 0; x < 100000; x++){
      found = aTree.contains(testVal);
    }//end for loop
    stop = new Date().getTime();
    System.out.println(found + " " + (stop - start)/100000.0);

  }//end doIt()
}// end class Worker
