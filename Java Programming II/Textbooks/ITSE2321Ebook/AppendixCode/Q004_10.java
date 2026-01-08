//3456789012345678901234567890123456789
class Q004_10{
   public static void main(
                        String args[]){
     SubClass ref1 = new SubClass(5);
     SubClass ref2 = new SubClass(10);
     System.out.println(
                       ref1.add(ref2));
   }//end main()
 }//end class definition

 class AClass{
   private int x;
   
   AClass(int x){//constructor
     this.x = x;
   }// end constructor

 }//end class AClass

 class SubClass extends AClass{
   SubClass(int x){
     super(x);
   }//end constructor
   
   int add(AClass ref){
     return x + ref.x;
   }//end add()
   
 }//end class SubClass