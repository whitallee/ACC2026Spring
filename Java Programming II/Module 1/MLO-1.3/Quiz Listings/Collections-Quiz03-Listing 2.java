//File Comparator03.java
//Copyright 2001 R.G.Baldwin
import java.util.*;
import java.io.Serializable;

class Comparator03{
  public static void main(String args[]){
    new Worker().doIt();
  }//end main()
}//end class Comparator03

class Worker{
  public void doIt(){
    Iterator iter;
    Collection ref;
    System.out.println("Natural ordering");
    ref = new TreeSet();
    Populator.fillIt(ref);
    iter = ref.iterator();
    while(iter.hasNext()){
      System.out.print(iter.next() + " ");
    }//end while loop
    System.out.println();

    System.out.println("Comparator in use");
    ref = new TreeSet(new TheComparator());
    Populator.fillIt(ref);
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

class TheComparator
         implements Comparator,Serializable{

  public int compare(Object o1,Object o2){
    if(!(o1 instanceof String))
        throw new ClassCastException();
    if(!(o2 instanceof String))
        throw new ClassCastException();

    //Do an ignore-case comparison
/*
    int result =
            ((String)o1).toUpperCase().
                compareTo(((String)o2).
                        toUpperCase());
*/
    int result = 
      ((String)o1).compareToIgnoreCase((String)o2);
    return result;
  }//end compare()

  public boolean equals(Object o){
    if(!(o instanceof TheComparator))
        return false;
    else return true;
  }//end overridden equals()
}//end class TheComparator