//File Comparator07.java
//Copyright, R.G.Baldwin
import java.util.*;

public class Comparator07{
  public static void main(String args[]){
    new Worker().doIt();
  }//end main()
}//end class Comparator07

class Worker{
  public void doIt(){
    Iterator iter;
    Collection ref;

    ref = new ArrayList();
    Populator.fillIt(ref);
    iter = ref.iterator();
    while(iter.hasNext()){
      System.out.print(iter.next() + " ");
    }//end while loop
    System.out.println();

    Collections.reverse((List)ref);
    iter = ref.iterator();
    while(iter.hasNext()){
      System.out.print(iter.next() + " ");
    }//end while loop
    System.out.println();

    Comparator aComparator = Collections.reverseOrder();
    Collections.sort((List)ref, aComparator);
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