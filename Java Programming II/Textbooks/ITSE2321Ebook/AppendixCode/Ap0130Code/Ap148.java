public class Ap148{
  public static void main(
                        String args[]){
    new Worker().doIt();
  }//end main()
}//end class Ap148

class Worker{
  void doIt(){
    System.out.println(1.0/0);
  }//end doIt()
}// end class Worker