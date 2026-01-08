//3456789012345678901234567890123456789

class Q83{
  public static void main(
                        String args[]){
    try{
      System.out.print(
               Float.NaN == Float.NaN);
      System.out.println(" " +
           (Float.POSITIVE_INFINITY ==
             Float.POSITIVE_INFINITY));
    }catch(Exception e){
      System.out.println("Exception");
    }//end catch
  }//end main()
}//end class definition