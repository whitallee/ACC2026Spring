//File ToArray01.java
//Copyright, R.G.Baldwin
import java.util.*;
import javax.swing.*;

public class ToArray01{
  public static void main(String args[]){
    new Worker().doIt();
  }//end main()
}//end class ToArray01
//===================================//

class Worker{
  public void doIt(){
    Collection ref;

    //Create, populate, and display the
    // contents of a collection
    ref = new LinkedList();
    Populator.fillIt(ref);
    System.out.println("Collection contents");
    showCollection(ref);

    //Get collection contents into the
    // array and display the new
    // contents of the array.
    Object[] array = ref.toArray();
    System.out.println("New array contents");
    showArray(array);

    //Modify a property of an object
    // referred to by one of the
    // elements in the array. Display
    // array contents after
    // modification
    System.out.println("Modified array contents");
    ((JComponent)array[0]).setToolTipText("XX");
    showArray(array);

    //Display the contents of the
    // collection
    System.out.println("Collection contents");
    showCollection(ref);
  }//end doIt()
//-----------------------------------//

  //Utility method for displaying
  // array contents
  void showArray(Object[] array){
    for(int i = 0; i < array.length;i++){
      if(array[i] == null){
        System.out.print("null ");
      }else{
        System.out.print(((JComponent)array[i]).
                                 getToolTipText() + " ");
      }//end else
    }//end for loop
    System.out.println();
  }//end showArray()
//-----------------------------------//

  //Utility method for displaying
  // collection contents
  void showCollection(Collection ref){
    Iterator iter = ref.iterator();
    while(iter.hasNext()){
      System.out.print(((JComponent)iter.next()).
                                 getToolTipText() + " ");
    }//end while loop
    System.out.println();
  }//end showCollection
}// end class Worker
//===================================//

class Populator{
  public static void fillIt(Collection ref){
    ref.add(new JButton());
    ref.add(new JButton());
    ref.add(new JLabel());
    ref.add(new JButton());
    ref.add(new JButton());
    ref.add(new JLabel());

    Iterator iter = ref.iterator();
    int cnt = 0;
    JComponent refVar;
    while(iter.hasNext()){
      refVar = (JComponent)iter.next();
      if(refVar instanceof JButton){
        refVar.setToolTipText("B"+cnt++);
      }else{
        refVar.setToolTipText("L" + cnt++);
      }//end else
    }//end while loop

  }//end fillIt()
}//end class Populator