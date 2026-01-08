/*File Callback02.java Copyright, R.G.Baldwin
The purpose of this program is to develop a callback
capability using Interfaces.  

This is an enhanced version of the program named 
Callback01. You should familiarize yourself with
the earlier program before getting into this program.

This version has the added capability to create and 
maintain a list of objects that register for callback
whereas the program named Callback01 could only remember
a single object for callback.

In addition, this version defines two different classes 
that implement the CallBack interface.  Mixed objects
of those two types are maintained on the list and
notified at CallBack time.

As before, this program defines a CallBack interface 
that can be used to establish a new type of object, and 
also to declare the interface to a method named callBack() 
that is contained in all objects of classes that
implement the interface.  This method can be used to 
notify those objects whenever something interesting 
happens.

The program defines a Teacher class that has the 
ability to create and maintain a list of objects
of the interface type, and to notify those objects
that something interesting has happened by invoking
the callBack() method on all the objects on the list.

The size of the list is limited only to the largest Vector
object that can be accommodated by the system.

The program defines a class named Student that 
implements the CallBack interface.  It also defines
a class named Dog that implements the CallBack
interface.

Objects of the Student and Dog classes can be registered 
on the list maintained by an object of the Teacher class,
and can be notified by the object of the Teacher class 
whenever something interesting happens. 

Note that objects can be added to the list and then
removed from the list.  One object is first added
and later removed for demonstration purposes.

Notification takes the form of invoking the
callBack() method on all the objects on the list.

The body of the callBack() methods in the classes that
implement the interface can be designed to do anything.
In this case, to keep things simple, they just announces
that they have been called.  However, they make the 
announcement in slightly different ways.

This program contains System.out.println() statements in
the registration and notification methods for 
demonstration purposes only, and to allow us to track
what is happening as the program runs.

Finally, the program defines a controlling class that
ties all the pieces together and exercises them.

Tested using JDK 1.1.3 under Win95.

The output from the program was:

Register Tom
Student@1cc73e added
Register Spot
Dog@1cc74e added
Register Sue
Student@1cc741 added
Register Fido
Dog@1cc751 added
Register Peg
Student@1cc744 added
Register Bob
Student@1cc747 added
Register Brownie
Dog@1cc754 added
Remove Peg
Student@1cc744 removed
Try to remove Joe
Student@1cc74a not in the list

Tom here
Woof, Woof Spot
Sue here
Woof, Woof Fido
Bob here
Woof, Woof Brownie
  
Note that Peg didn't appear in the callBack list because
she was first added to, and later removed from the list.
**********************************************************/
import java.util.*;

//First we define an interface that will create a new type
// and declare a generic method that can be used to 
// callback any object that is of a class that implements
// the interface.
interface CallBack{
  public void callBack();
}//end interface CallBack
//=======================================================//

//Next we need a class whose objects can maintain a 
// registered list of objects of type CallBack (whose
// class implements the CallBack interface) and can 
// notify all the objects on that list when something
// interesting happens.

class Teacher{
  Vector objList; //list of objects of type CallBack
  //-----------------------------------------------------//
  
  Teacher(){//constructor
    //Instantiate a Vector object to contain the list
    // of registered objects.
    objList = new Vector();
  }//end constructor
  //-----------------------------------------------------//
  
  //Method to add objects to the list.  Synchronize to
  // protect against two or more objects on different
  // threads trying to register at the same time.  Note 
  // that the objects are received as type CallBack which
  // is the interface type, and stored as type Object,
  // because the Vector class only accomodates objects of
  // type Object.
  synchronized void register(CallBack obj){
    this.objList.addElement(obj);
    System.out.println(obj + " added");
  }//end register()
  //-----------------------------------------------------//
  
  //Method to remove objects from the list.
  synchronized void unRegister(CallBack obj){
    if(this.objList.removeElement(obj))
      //true when successfully found and removed
      System.out.println(obj + " removed");
    else//false on failure to find and remove
      System.out.println(obj + " not in the list");
  }//end register()
  //-----------------------------------------------------//
  
  //Method to notify all objects on the list that 
  // something interesting has happened.  
  void callTheRoll(){
    Vector tempList;//save a temporary copy of list here
    
    //Make a copy of the list to avoid the possibility of
    // the list changing while objects are being notified.
    // Synchronize to protect against list changing while
    // making the copy.
    synchronized(this){
      tempList = (Vector)objList.clone();
    }//end synchronized block
    
    //Invoke the callBack() method on each object on
    // the list.  The object are guaranteed to have such
    // a method, even if they are of different types,
    // because they are all of a class that implements 
    // the CallBack interface. If not, they could not
    // have been registered on the list in the first
    // place.  Note the requirement to downcast to
    // type CallBack.
    for(int cnt = 0; cnt < tempList.size(); cnt++){
      ((CallBack)tempList.elementAt(cnt)).callBack();
    }//end for loop
  }//end callTheRoll()
  //-----------------------------------------------------//
}//end class Teacher
//=======================================================//

//Class that implements the CallBack interface.  Objects
// of this class can be registered on the list maintained
// by an object of the Teacher class, and will be notified
// whenever that object invokes the callBack method on the
// registered objects on the list.  This program will not
// compile if this class fails to implement the CallBack
// interface

class Student implements CallBack{
  String name; //store the object name here for later ID
  //-----------------------------------------------------//
  
  Student(String name){//constructor
    this.name = name;  //save the name to identify the obj
  }//end constructor
  //-----------------------------------------------------//

  //An object of the Teacher class will invoke this method
  // as the callback mechanism to notify an object of this
  // class that something interesting has happened.
  
  public void callBack(){//announce callBack
    System.out.println(name + " here");
  }//end overridden callBack()
}//end class Student
//=======================================================//

//Another Class that implements the CallBack interface.  
// Objects of this class can also be registered on the list
// maintained by an object of the Teacher class, and will
// also be notified whenever that object invokes the 
// callBack() method on the registered objects on the 
// list. This program will not compile if this class
// fails to implement the CallBack interface.

class Dog implements CallBack{
  String name; //store name here for later ID
  //-----------------------------------------------------//
  
  Dog(String name){//constructor
    this.name = name; //save the name to identify the obj
  }//end constructor
  //-----------------------------------------------------//

  //An object of the Teacher class will invoke this method
  // as the callback mechanism to notify an object of this
  // class that something interesting has happened.  
  
  public void callBack(){//announce callBack
    System.out.println("Woof, Woof " + name);
  }//end overridden callBack()
}//end class Dog
//=======================================================//

//Controlling class that ties all the pieces together and
// exercises them.
class Callback02{
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
    Dog spot = new Dog("Spot");
    Dog fido = new Dog("Fido");
    Dog brownie = new Dog("Brownie");

    //Register some Student and Dog objects with the 
    // Teacher object.
    System.out.println("Register Tom");
    missJones.register(tom);
    System.out.println("Register Spot");
    missJones.register(spot);
    System.out.println("Register Sue");
    missJones.register(sue);
    System.out.println("Register Fido");
    missJones.register(fido);
    System.out.println("Register Peg");
    missJones.register(peg);
    System.out.println("Register Bob");
    missJones.register(bob);
    System.out.println("Register Brownie");
    missJones.register(brownie);
    
    //Remove a Student object from the list.
    System.out.println("Remove Peg");
    missJones.unRegister(peg);
    
    //Try to remove an object that is not on the list.
    System.out.println("Try to remove Joe");
    missJones.unRegister(joe);
    
    System.out.println();//blank line
    
    //Cause the Teacher object to do a callBack on all
    // the objects on the list.
    missJones.callTheRoll();
  }//end main()
}//end class Callback02
//=======================================================//