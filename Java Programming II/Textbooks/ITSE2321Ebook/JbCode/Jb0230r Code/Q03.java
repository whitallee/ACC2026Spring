class Q03{
  public static void main(String[] args){

    System.out.println(new Runner().run());
  }//end main
}//end class

class Runner{
  int cnt = 0;
  int run(){
    while(cnt < 5){
      cnt++;
      if(cnt == 4){
        return cnt;
      }//end if
    }//end while
    return 99;
  }//end run
}//end class