/*File Odd.java
The purpose of this program is to demonstrate how to
determine if a given numeric value is even or odd. The
output is:
3 is Odd
4 is Even
**********************************************************/

class Odd { //define the controlling class
  public static void main(String[] args){ //define main
    int val = 3;
    System.out.print(val);
    if(val % 2 == 0){
      System.out.println(" is Even");
    }else{
      System.out.println(" is Odd");
    }
    
    val = 4;
    System.out.print(val);
    if(val % 2 == 0){
      System.out.println(" is Even");
    }else{
      System.out.println(" is Odd");
    }
  }//end main
}//End Odd class


