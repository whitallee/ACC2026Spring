//3456789012345678901234567890123456789

//File Q60.java
class Q60{
  static int count = 0;
  
  public void finalize(){
    System.out.print(++count + " ");
  }//end finalize
  
  public static void main(
                        String[] args){
    //Instantiate 5-element array obj
    Q60[] var = new Q60[5];
    
    //Populate array with refs to
    // objects.
    for(int cnt = 0; cnt < var.length;
                                cnt++){
      var[cnt] = new Q60();  
    }//end for loop
    
    //Overwrite ref to array object
    var = null;
    
    //Request garbage collection
    System.gc();
    System.out.println("Terminating");
  }//end main
}//end class Q60