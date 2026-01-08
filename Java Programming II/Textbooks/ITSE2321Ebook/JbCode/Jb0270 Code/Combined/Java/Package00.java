/*File Package00.java Copyright, R.G.Baldwin
Illustrates use  of package and import directives to
build an application consisting of classes in three
separate packages.

The output from running the program follows:

Starting Package00
Instantiate obj of public classes in different packages
Constructing Package01 object in folder p1
Constructing Package02 object in folder p2
Back in main of Package00
**********************************************************/
package Combined.Java; //package directive

//Two import directives
import Combined.Java.p1.Package01;//specific form
import Combined.Java.p2.*; //wildcard form

class Package00{
  public static void main(String[] args){ //main method
    System.out.println("Starting Package00");

    System.out.println("Instantiate obj of public " +
                         "classes in different packages");
    new Package01();//Instantiate objects of two classes
    new Package02();// in different packages.

    System.out.println("Back in main of Package00");

  }//end main method
}//End Package00 class definition.