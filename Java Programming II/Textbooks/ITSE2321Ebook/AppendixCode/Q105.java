//3456789012345678901234567890123456789

class Q105{
  public static void main(
                        String args[]){
    try{
      boolean x = true;
      boolean y = false;
      System.out.print((x & y) + " " +
                              (x & x));
      System.out.print("  ");
      System.out.print(
        (x ^ y) + " " + (x ^ x) + " " +
                              (y ^ y));
      System.out.print("  ");
      System.out.println(
        (x | y) + " " + (x | x) + " " +
                              (y | y));

    }catch(Exception e){
      System.out.println(
                   "Exception Thrown");
    }//end catch
  }//end main()
}//end class definition