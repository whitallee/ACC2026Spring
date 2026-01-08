/*File Callback01.java Copyright, R.G.Baldwin
The purpose of this program is to develop a callback
capability using Interfaces.  This version of the
program is designed to emphasize the structure of
the process, and therefore an effort was made to
avoid the requirement for any extra code to do
anything fancy.

Tested using JDK 1.1.3 under Win95.

The output from the program is:

Joe here.
**********************************************************/
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

//To keep things simple, and emphasize the structure of
// what we are doing, we will begin with a limitation
// of one object on the length of the list.

class Teacher{
  CallBack obj; //list of objects of type CallBack
  //-----------------------------------------------------//

  //Method to add objects to the list.
  void register(CallBack obj){
    this.obj = obj;
  }//end register()
  //-----------------------------------------------------//

  //Method to notify all objects on the list that
  // something interesting has happened.
  void callTheRoll(){
    //Call the callBack() method on the object.  The
    // object is guaranteed to have such a method because
    // it is of a class that implements the CallBack
    // interface.
    obj.callBack();
  }//end callTheRoll()
  //-----------------------------------------------------//
}//end class Teacher
//=======================================================//

//Class that implements the CallBack interface.  Objects
// of this class can be registered on the list maintained
// by an object of the Teacher class, and will be notified
// whenever that object calls the callBack method on the
// registered objects on the list.
class Student implements CallBack{
  String name;
  //-----------------------------------------------------//

  Student(String name){//constructor
    this.name = name;  //save the name to identify the obj
  }//end constructor
  //-----------------------------------------------------//

  //An object of the Teacher class will call this method
  // as the callback mechanism to notify an object of this
  // class that something interesting has happened.
  public void callBack(){
    System.out.println(name + " here");
  }//end overridden callBack()
}//end class Student
//=======================================================//

//Controlling class that ties all the pieces together and
// exercises them.
class Callback01{
  public static void main(String[] args){
    //Instantiate Teacher object
    Teacher missJones = new Teacher();
    //Instantiate and register a Student object with the
    // Teacher object
    missJones.register(new Student("Joe"));
    //Cause the Teacher object to do a callBack on the
    // Student object.
    missJones.callTheRoll();
  }//end main()
}//end class Callback01
//=======================================================//