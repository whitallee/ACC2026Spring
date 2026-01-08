/*File simple1.java Copyright, R.G.Baldwin
**********************************************************/
class simple1 { //define the controlling class
  public static void main(String[] args) //define main
            throws java.io.IOException {
    int ch1, ch2 = '0';

    System.out.println(
      "Enter some text, terminate with #");

    //Get and save individual bytes
    while( (ch1 = System.in.read() ) != '#') ch2 = ch1;

    //Display the character immediately before the #
    System.out.println("The char before the # was "
      + (char)ch2);
  }//end main
}//End simple1 class.