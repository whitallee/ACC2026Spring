/*File Callback03.java Copyright, R.G.Baldwin
The purpose of this program is to develop a callback
capability using Interfaces.  

This is an enhanced version of the program named 
Callback02. You should familiarize yourself with
the earlier program before getting into this program.

This version defines three different classes named
Student, Dog, and Cat that implement the CallBack 
interface.  Mixed objects of those three types are 
maintained on a list and notified at CallBack time.

As before, this program defines a CallBack interface 
that can be used to establish a new type of object.

This version of the interface declares two
different methods that can be invoked as callback
methods instead of just one.  All classes that implement
the interface must define both methods, but it is
allowable to define the method as an empty method and
ignore the callback associated with a particular method.

One of the callback methods is now called recess() and
the other is called lunch().

The Dog class ignores the recess() callback by defining
an empty method, and the Cat class ignores the lunch()
callback by defining an empty method.  The Student
class responds to both types of callbacks with fully-
defined methods.

The program defines a Teacher class that has the 
ability to create and maintain a list of objects
of the interface type, and to notify those objects
that something interesting has happened by invoking
either the recess() method or the lunch() method on all 
the objects on the list.  It is important to note that
every object on the list will be notified of both
types of callback, although as mentioned above, a
particular type of callback can be ignored simply by
leaving the method empty when it is defined.

Note that objects can be added to the list and then
removed from the list.  However, removal of objects from
the list was demonstrated in the previous program, so
removal is not demonstrated in this program.

As always, notification takes the form of invoking 
either the recess() method or the lunch() method on all
the objects on the list.

Finally, the program defines a controlling class that
ties all the pieces together and exercises them.

Tested using JDK 1.1.3 under Win95.

The output from the program was:

Tom recess
Sue recess
CleoCat recess
Peg recess
KittyKat recess
Bob recess
Tom lunch
SpotDog lunch
Sue lunch
FidoDog lunch
Peg lunch
Bob lunch
BrownieDog lunch
**********************************************************/
import java.util.*;

//First we define an interface that will create a new type
// and declare two generic methods that can be used to 
// callback any object that is of a class that implements
// the interface.
interface CallBack{
  public void recess();
  public void lunch();
}//end interface CallBack
//=======================================================//

//Next we need a class whose objects can maintain a 
// registered list of objects of type CallBack and can 
// notify all the objects on that list when something
// interesting happens. This class has the ability to
// notify of two different types of callbacks, recess()
// and lunch().  

class Teacher{
  Vector objList; //list of objects of type CallBack
  //-----------------------------------------------------//
  
  Teacher(){//constructor
    //Instantiate a Vector object to contain the list
    // of registered objects.
    objList = new Vector();
  }//end constructor
  //-----------------------------------------------------//
  
  //Method to add objects to the list.
  synchronized void register(CallBack obj){
    this.objList.addElement(obj);
  }//end register()
  //-----------------------------------------------------//
  
  //Method to remove objects from the list.
  synchronized void unRegister(CallBack obj){
    if(this.objList.removeElement(obj))
      System.out.println(obj + " removed");
    else
      System.out.println(obj + " not in the list");
  }//end register()
  //-----------------------------------------------------//
  
  //Method to notify all objects on the list that 
  // something interesting has happened regarding recess.  
  void callRecess(){
    Vector tempList;//save a temporary copy of list here
    
    //Make a copy of the list.
    synchronized(this){
      tempList = (Vector)objList.clone();
    }//end synchronized block
    
    //Invoke the recess() method on each object on
    // the list.
    for(int cnt = 0; cnt < tempList.size(); cnt++){
      ((CallBack)tempList.elementAt(cnt)).recess();
    }//end for loop
  }//end callRecess()
  //-----------------------------------------------------//
  //Method to notify all objects on the list that 
  // something interesting has happened regarding lunch.  
  void callLunch(){
    Vector tempList;//save a temporary copy of list here
    
    //Make a copy of the list.
    synchronized(this){
      tempList = (Vector)objList.clone();
    }//end synchronized block
    
    //Invoke the lunch() method on each object on
    // the list.
    for(int cnt = 0; cnt < tempList.size(); cnt++){
      ((CallBack)tempList.elementAt(cnt)).lunch();
    }//end for loop
  }//end callRecess()
  //-----------------------------------------------------//
}//end class Teacher
//=======================================================//

//Class that implements the CallBack interface.  Objects
// of this class can be registered on the list maintained
// by an object of the Teacher class, and will be notified
// whenever that object invokes either the recess() method
// or the lunch() method on the registered objects on 
// the list.  This method provides a full definition for
// both methods.

class Student implements CallBack{
  String name; //store the object name here for later ID
  //-----------------------------------------------------//
  
  Student(String name){//constructor
    this.name = name;  //save the name to identify the obj
  }//end constructor
  //-----------------------------------------------------//

  //An object of the Teacher class can invoke this method
  // as a callback mechanism.
  public void recess(){//announce recess
    System.out.println(name + " recess");
  }//end overridden recess()
  //-----------------------------------------------------//

  //An object of the Teacher class can also invoke this 
  // method as a callback mechanism.
  public void lunch(){//announce recess
    System.out.println(name + " lunch");
  }//end overridden lunch()

}//end class Student

//=======================================================//

//Another Class that implements the CallBack interface.  
// See description above. This class defines the recess()
// method as an empty method.

class Dog implements CallBack{
  String name; //store name here for later ID
  //-----------------------------------------------------//
  
  Dog(String name){//constructor
    this.name = name; //save the name to identify the obj
  }//end constructor
  //-----------------------------------------------------//

  //An object of the Teacher class can invoke this method
  // as the callback mechanism.
  
  public void recess(){//announce recess
    //ignore this callback with an empty method
  }//end overridden recess()
  //-----------------------------------------------------//

  //An object of the Teacher class can also invoke this 
  // method as a callback mechanism.
  public void lunch(){//announce recess
    System.out.println(name + " lunch");
  }//end overridden lunch()
}//end class Dog
//=======================================================//

//A third Class that implements the CallBack interface,
// similar to the other two classes.  This class defines
// the lunch() method as an empty method.

class Cat implements CallBack{
  String name; //store name here for later ID
  //-----------------------------------------------------//
  
  Cat(String name){//constructor
    this.name = name; //save the name to identify the obj
  }//end constructor
  //-----------------------------------------------------//

  //An object of the Teacher class can invoke this method
  // as the callback mechanism.
  
  public void recess(){//announce recess
    System.out.println(name + " recess");
  }//end overridden recess()
  //-----------------------------------------------------//

  //An object of the Teacher class can also invoke this 
  // method as a callback mechanism.
  public void lunch(){//announce recess
    //ignore this callback with an empty method
  }//end overridden lunch()
}//end class Cat
//=======================================================//

//Controlling class that ties all the pieces together and
// exercises them.
class Callback03{
  public static void main(String[] args){
    //Instantiate Teacher object
    Teacher missJones = new Teacher();

    //Instantiate some Student objects
    Student tom = new Student("Tom");
    Student sue = new Student("Sue");
    Student peg = new Student("Peg");
    Student bob = new Student("Bob");
    Student joe = new Student("Joe");
    
    //Instantiate some Dog objects.
    Dog spot = new Dog("SpotDog");
    Dog fido = new Dog("FidoDog");
    Dog brownie = new Dog("BrownieDog");
    
    //Instantiate some Cat objects
    Cat cleo = new Cat("CleoCat");
    Cat kitty = new Cat("KittyKat");

    //Register some Student, Dog, and Cat objects with 
    // the Teacher object.
    missJones.register(tom);
    missJones.register(spot);
    missJones.register(sue);
    missJones.register(cleo);
    missJones.register(fido);
    missJones.register(peg);
    missJones.register(kitty);
    missJones.register(bob);
    missJones.register(brownie);
    
    //Cause the Teacher object to call recess on all
    // the objects on the list.
    missJones.callRecess();
    //Cause the Teacher object to call lunch on all
    // the objects on the list.
    missJones.callLunch();
  }//end main()
}//end class Callback03
//=======================================================//