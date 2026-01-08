//File Comparator06.java
//Copyright, R.G.Baldwin
import java.util.*;
import java.io.Serializable;

public class Comparator06{
  public static void main(String args[]){
    new Worker().doIt();
  }//end main()
}//end class Comparator06

class Worker{
  public void doIt(){
    Iterator iter;
    Collection ref;

    ref = new LinkedList();
    Populator.fillIt(ref);
    Collections.sort((List)ref, new TheComparator());
//    Collections.sort(ref, new TheComparator());
    iter = ref.iterator();
    while(iter.hasNext()){
      System.out.print(iter.next() + " ");
    }//end while loop
    System.out.println();

  }//end doIt()
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

    //Do an upper-case comparison
    int result = ((String)o1).compareTo(((String)o2));
    return result*(-1);
  }//end compare()
}//end class TheComparator