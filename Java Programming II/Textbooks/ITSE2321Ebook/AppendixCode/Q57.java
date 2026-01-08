//3456789012345678901234567890123456789

//File Q57.java
class Q57{
  public static void main(
                        String args[]){
    AClass ref1 = new AClass(5);
    AClass ref2 = new AClass(10);

    ref1.getAndShow(ref2);
  }//end main()
}//end class definition
//-----------------------------------//

class AClass{
  private int x;//instance variable
   
  AClass(int x){//constructor
    this.x = x;
  }// end constructor

  //An instance method
  void getAndShow(AClass ref){
    System.out.print(ref.x + " ");
  }//end getAndShow()

}//end class AClass