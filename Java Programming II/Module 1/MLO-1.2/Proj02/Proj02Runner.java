/* File Proj02Runner
Whit Allee
2/11/2026
ITSE-2317-001
Professor Baldwin
*****************************************************/
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class Proj02Runner implements Comparable{

  int data = 0;

  Proj02Runner(){//overloaded constructor
    //The purpose of this constructor is to display
    // the certification.
    System.out.println(
      "I certify that this program is my own work \n"+
      "and is not the work of others. I agree not \n" +
      "to share my solution with others.\n" +
      "Whit Allee\n");
  }//end overloaded constructor
  
  Proj02Runner(int data){//overloaded constructor
    //The purpose of this constructor is to store
    // the incoming data value
    this.data = data;
  }//end overloaded constructor

  public String toString(){
    return "" + data;
  }//end toString()

  public int compareTo(Object o){
    if(!(o instanceof Proj02Runner))
      throw new ClassCastException();
    if(((Proj02Runner)o).data < data)
      return 1;
    if(((Proj02Runner)o).data > data)
      return -1;
    else return 0;
  }//end compareTo()

  public boolean equals(Object o){
    if(!(o instanceof Proj02Runner))
      return false;
    if(((Proj02Runner)o).data == data)
      return true;
    else return false;
  }//end equals()

}//end class Proj02Runner

