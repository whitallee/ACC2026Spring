/*File Proj04Runner.java
Whit Allee
02/13/2026
ITSE 2317-001
Professor Baldwin
***********************************************************/

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.io.Serializable;
import java.util.TreeSet;

public class Proj04Runner {
    //class attribute myArray
    private TreeSet myTreeSet;

    Proj04Runner(){//constructor
    //The purpose of this constructor is to display
    // the certification.
    System.out.println(
      "I certify that this program is my own work \n"+
      "and is not the work of others. I agree not \n" +
      "to share my solution with others.\n" +
      "Whit Allee\n");
  }

    //runA method: sort the array in case-insensitive ascending order and store in class attribute myArray
    public Object[] runA(Object[] myArray) {
        // populate TreeSet
        this.myTreeSet = new TreeSet(new MyComparatorA());
        this.myTreeSet.addAll(Arrays.asList(myArray));
        return this.myTreeSet.toArray();
    }//end runA

    //runB method: sort the array in case-sensitive descending order and return as a collection
    public Collection runB() {
        // sort TreeSet in case-sensitive descending order by passing a comparator to sort method
        TreeSet treeSetB = new TreeSet(new MyComparatorB());
        treeSetB.addAll(this.myTreeSet);
        return treeSetB;
    }//end runB
}

class MyComparatorA implements Comparator, Serializable {
    public int compare(Object o1, Object o2) {
        if(!(o1 instanceof String))
            throw new ClassCastException();
        if(!(o2 instanceof String))
            throw new ClassCastException();
        return ((String) o1).compareToIgnoreCase((String) o2);
    }//end compare (case insensitive ascending order)
}

class MyComparatorB implements Comparator, Serializable {
    public int compare(Object o1, Object o2) {
        if(!(o1 instanceof String))
            throw new ClassCastException();
        if(!(o2 instanceof String))
            throw new ClassCastException();
        return ((String) o1).compareTo((String) o2) * -1;
    }//end compare (case sensitive descending order)
}
