import java.util.function.Function;

public class Main02 {
  public static void main(String[] args) {
    Function<Integer, String> intToString = Object::toString;
    String result = intToString.apply(5);
    
    Class<?> type = result.getClass();
    System.out.println("Type of result is: " + type.getName());
  }//End main
}//End class
