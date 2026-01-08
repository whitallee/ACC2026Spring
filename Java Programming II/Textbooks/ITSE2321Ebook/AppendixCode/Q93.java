//3456789012345678901234567890123456789

class Q93{
  public static void main(
                        String args[]){
    try{
      byte x = -127;
      byte y = (byte)(x >> 9);
      System.out.println(y);
    }catch(Exception e){
      System.out.println("Exception");
    }//end catch
  }//end main()
}//end class definition