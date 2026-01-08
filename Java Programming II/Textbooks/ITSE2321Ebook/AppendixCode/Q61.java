//3456789012345678901234567890123456789

//File Q61.java
class Q61{
   public static void main(
                        String args[]){
     MyClass refToObj = new MyClass();
     refToObj.instanceVar = 5;
     refToObj.addFive(refToObj);
     System.out.println(
                 refToObj.instanceVar);
   }//end main()
 }//end Q61

 class MyClass{
   int instanceVar;
   void addFive(MyClass param){
     param.instanceVar+=5;
   }//end addFive()
 }//end MyClass