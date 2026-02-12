/*File Proj03Runner.java
Whit Allee
02/11/2026
ITSE 2317-001
Professor Baldwin
***********************************************************/

import java.util.Comparator;

public class Proj03Runner implements Comparator {
    
    private String name;

    Proj03Runner(){//overloaded constructor
    //The purpose of this constructor is to display
    // the certification.
    System.out.println(
      "I certify that this program is my own work \n"+
      "and is not the work of others. I agree not \n" +
      "to share my solution with others.\n" +
      "Whit Allee\n");
  }//end overloaded constructor

    Proj03Runner(String name) {//overloaded constructor
        this.name = name;
    }//end overloaded constructor
    
    public int compare(Object o1, Object o2) { // case insensitive comparison in descending order
        return (((String) o1).compareToIgnoreCase((String) o2)) * -1;
    }//end compare

    public String toString() {
        return name;
    }//end toString
}