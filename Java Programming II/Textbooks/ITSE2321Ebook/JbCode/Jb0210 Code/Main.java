import java.util.function.Consumer;

public class Main {
  public static void main(String[] args) {
    // Define a lambda expression that takes a string and prints it
    Consumer<String> printString = (String s) -> System.out.println(s);
        
    // Use the lambda expression to print a string
    printString.accept("Hello, World!");
  }//End main
}//End class
