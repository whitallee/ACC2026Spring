//3456789012345678901234567890123456789

//File Q62.java
class Q62{
  public static void main(
                        String args[]){
    int localVar = 5;
    MyClass refToObj = new MyClass();
    refToObj.addFive(localVar);
    System.out.println(localVar);
  }//end main()
}//end class Q62

class MyClass{
  public void addFive(int param){
    param += 5;
  }//end addFive
}//end class MyClass