/*File Poly05.java
Copyright, R.G.Baldwin
**************************************/

interface I1{
  public void p();
}//end interface I1
//===================================//

interface I2 extends I1{
  public void q();
}//end interface I2
//===================================//

class A extends Object{
  public String toString(){
    return "toString in A";
  }//end toString()
  //---------------------------------//
  
  public String x(){
    return "x in A";
  }//end x()
  //---------------------------------//
}//end class A
//===================================//

class B extends A implements I2{
  public void p(){
  }//end p()
  //---------------------------------//
  
  public void q(){
  }//end q();
  //---------------------------------//
}//end class B
//===================================//

class C extends Object implements I2{
  public void p(){
  }//end p()
  //---------------------------------//
  
  public void q(){
  }//end q();
  //---------------------------------//
}//end class B
//===================================//

public class Poly05{
  public static void main(String[] args){
  }//end main
}//end class Poly05