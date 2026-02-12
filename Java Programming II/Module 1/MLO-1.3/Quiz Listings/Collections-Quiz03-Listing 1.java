//File Comparator02.java
//Copyright 2001, R.G.Baldwin
import java.util.*;
import java.io.Serializable;

class Comparator02{
  public static void main(String args[]){
    new Worker().doIt();
  }//end main()
}//end class Comparator02

class Worker{
  public void doIt(){
    Iterator iter;
    Collection ref;

    ref = new TreeSet(new TheComparator());
    Populator.fillIt(ref);
    iter = ref.iterator();
    while(iter.hasNext()){
      System.out.print(iter.next());
    }//end while loop
    System.out.println();

  }//end doIt()
}// end class Worker

class Populator{
  public static void fillIt(Collection ref){
    ref.add(new MyClass(4));
    ref.add(new MyClass(4));
    ref.add(new MyClass(3));
    ref.add(new MyClass(2));
    ref.add(new MyClass(1));
  }//end fillIt()
}//end class Populator

class MyClass{
  int data;

  MyClass(){
    data = 0;
  }//end noarg constructor

  MyClass(int data){
    this.data = data;
  }//end parameterized constructor

  public String toString(){
    return "" + data;
  }//end overridden toString()

}//end MyClass

class TheComparator
    implements Comparator,Serializable{

  public int compare(Object o1,Object o2){
    if(!(o1 instanceof MyClass))
        throw new ClassCastException();
    if(!(o2 instanceof MyClass))
        throw new ClassCastException();
    if(((MyClass)o1).data
                  < ((MyClass)o2).data)
      return -1;
    if(((MyClass)o1).data
                  > ((MyClass)o2).data)
      return 1;
    else return 0;
  }//end compare()

  public boolean equals(Object o){
    if(!(o instanceof TheComparator))
        return false;
    else return true;
  }//end overridden equals()
}//end class TheComparator