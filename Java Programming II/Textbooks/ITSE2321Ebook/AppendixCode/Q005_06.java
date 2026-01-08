//3456789012345678901234567890123456789

//File Q005_06.java
class Q005_06{
  public static void main(
                        String args[]){
    AClass ref1 = new AClass(5);
    AClass ref2 = new AClass(10);
    ref1.directShow();
    ref2.directShow();
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
  void directShow(){
    System.out.print(x + " ");
  }//end directShow()

  //An instance method
  void getAndShow(AClass ref){
    System.out.print(ref.x + " ");
  }//end getAndShow()

}//end class AClass