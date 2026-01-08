//File Comparator05.java
//Copyright, R.G.Baldwin
import java.util.*;
import java.io.Serializable;

public class Comparator05{
  public static void main(String args[]){
    new Worker().doIt();
  }//end main()
}//end class Comparator05

class Worker{
  public void doIt(){
    Iterator iter;
    Collection ref;
    Object[] array;

    ref = new Vector();
    Populator.fillIt(ref);
    iter = ref.iterator();
    System.out.println("Collection data");
    while(iter.hasNext()){
      System.out.print(iter.next() + " ");
    }//end while loop
    System.out.println();

    array = ref.toArray();
    System.out.println("Raw array data");
    display(array);

    //Sort the array into natural order
    // and display it.
    Arrays.sort(array);
    System.out.println("Natural order sorted " +
                                  "array data");
    display(array);

    //Sort the array into custom order
    // and display it.
    Arrays.sort(array, new TheComparator());
    System.out.println("Custom order sorted " +
                                 "array data");
    display(array);

    iter = ref.iterator();
    System.out.println("Collection data");
    while(iter.hasNext()){
      System.out.print(iter.next() + " ");
    }//end while loop
    System.out.println();

  }//end doIt()

  static void display(Object[] array){
    for(int i = 0; i < array.length;i++){
      System.out.print(array[i] + " ");
    }//end for loop
    System.out.println();
  }//end display()
}// end class Worker

class Populator{
  public static void fillIt(Collection ref){
    ref.add("Joe");
    ref.add("Bill");
    ref.add("Tom");
    ref.add("JOE");
    ref.add("BILL");
    ref.add("TOM");
  }//end fillIt()
}//end class Populator

class TheComparator implements Comparator,Serializable{

  public int compare(Object o1,Object o2){
    if(!(o1 instanceof String))
        throw new ClassCastException();
    if(!(o2 instanceof String))
        throw new ClassCastException();

    int result = ((String)o1).compareTo(((String)o2));
    return result*(-1);
  }//end compare()
}//end class TheComparator