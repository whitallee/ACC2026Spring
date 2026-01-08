import java.util.function.Function;

public class Main01 {
  public static void main(String[] args) {
    
    Function<String, Integer> parseInt = Integer::parseInt;
    int result = parseInt.apply("123");
    System.out.println(++result);
  }//End main
}//End class
