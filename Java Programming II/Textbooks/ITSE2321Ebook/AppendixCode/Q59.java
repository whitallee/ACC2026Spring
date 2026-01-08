//3456789012345678901234567890123456789

//File Q59.java
class Q59{
  String myString = "1";//instance var  
  
  public static void main(
                        String args[]){
    Q59 myObj = new Q59();
    myObj.stringModifier(
                       myObj.myString);
    System.out.println(" " + 
                       myObj.myString);
  }//end main()
    
  void stringModifier(
                     String theString){
    //concatenate
    theString = theString + "2";
    System.out.print(theString);
  }//end stringModifier
}//end class Q59