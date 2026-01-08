import java.util.TreeSet;
import java.util.Collection;
import java.util.Iterator;

public class AP400{
  public static void main(
                        String args[]){
    new Worker().doIt();
  }//end main()
}//end class AP400

class Worker{
  public void doIt(){
    Collection ref = new TreeSet();
    Populator.fillIt(ref);
    Iterator iter = ref.iterator();
    while(iter.hasNext()){
      System.out.print(iter.next());
    }//end while loop
    System.out.println();

  }//end doIt()
}// end class Worker

class Populator{
  public static void fillIt(
                       Collection ref){
    ref.add(new Integer(4));
    ref.add(new Integer(4));
    ref.add(new Integer(3));
    ref.add(new Integer(2));
    ref.add(new Integer(1));
  }//end fillIt()
}//end class populator