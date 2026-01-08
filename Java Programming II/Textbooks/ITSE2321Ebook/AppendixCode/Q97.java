//3456789012345678901234567890123456789

class Q97{
  public static void main(
                        String args[]){
    try{
      System.out.print((
                new AClass()instanceof 
                        AClass) + " ");
      System.out.println(
               new AClass() instanceof 
                          AnInterface);
    }catch(Exception e){
      System.out.println(
                   "Exception Thrown");
    }//end catch
  }//end main()
}//end class definition

interface AnInterface{
  //empty interface
}//end interface definition

class AClass implements AnInterface{
  //empty class definition
}//end class definition