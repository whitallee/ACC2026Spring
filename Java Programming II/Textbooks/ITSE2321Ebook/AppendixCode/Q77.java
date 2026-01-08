//3456789012345678901234567890123456789

class Q77{
  public static void main(
                        String args[]){
    double x = 64.0;
    double y = 0.0;
    double z = x%y;
    System.out.print(z + " ");
    if(z == Double.NaN)
      System.out.println(
                       "Not-a-Number");
    else
      System.out.println("Oops");

  }//end main()
}//end class definition