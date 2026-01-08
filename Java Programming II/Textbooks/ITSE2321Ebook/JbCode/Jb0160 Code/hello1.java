/*File hello1.java Copyright, R.G.Baldwin
This is a Java application program .

When compiled, this program produces the class named:

hello1.class

When the Java interpreter is called on the application's
controlling class using the following statement at the
command line:

java hello1

the interpreter starts the program by calling the main
method defined in the controlling class. The main method is
a class method which can be called without the requirement
to instantiate an object of the class.

The program displays the following words on the screen:

Hello 
Java World

*********************************************************/
class hello1 { //define the controlling class
  //define main method
  public static void main(String[] args){
    //display text string
    System.out.println("Hello\n" + "Java " +
                       "World");
  }//end main
}//End hello1 class.
