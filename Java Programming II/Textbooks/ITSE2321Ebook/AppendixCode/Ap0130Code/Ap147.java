import java.util.ArrayList;

public class Ap147{

  public static void main(
                        String args[]){
    new Worker().doIt();
  }//end main()
}//end class Ap147

class Worker{
  void doIt(){
    ArrayList ref = null;
    ref = new ArrayList(1);
    ref.add("ABC ");
    ref.add("DEF ");

    System.out.println(
                   (String)ref.get(0) +
                   (String)ref.get(1) +
                   (String)ref.get(2));
  }//end doIt()
}// end class Worker