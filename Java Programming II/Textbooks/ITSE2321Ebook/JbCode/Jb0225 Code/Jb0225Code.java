/*File Jb0225Code.java
The purpose of this code is to introduce the student to the
use of pseudo-random numbers.
***********************************************************/

import java.util.Random;
import java.util.Date;
class Jb0225Code{
  public static void main(String[] args){
    //Create a pseudo-random number generator with a 
    // time-based seed.
    long seed = new Date().getTime();
    System.out.println("Time-based seed = " + seed);
    Random generator = new Random(seed);
    
    //Get three random int values and convert them to
    // byte values to make them easier to work with
    // visually.
    byte valA = (byte)generator.nextInt();
    byte valB = (byte)generator.nextInt();
    byte valC = (byte)generator.nextInt();
    
    //Display the random byte values.
    System.out.println("Random bytes\n" +
                   valA + " " + valB + " " + valC + "\n");

    
    //Create a new generator with either the same seed as
    // above or a seed based on an incoming command-line
    // argument.
    //Get command-line arg as type String if there is one,
    // and convert it to type long.
    if(args.length != 0){
      seed = Long.parseLong(args[0]);
      System.out.println("Arg-based seed = " + seed);
    }else{
      System.out.println("No command-line arg.");
      System.out.println("Use same seed as above.");
    };

    generator = new Random(seed);
    
    //Get three random bytes from the new generator.
    valA = (byte)generator.nextInt();
    valB = (byte)generator.nextInt();
    valC = (byte)generator.nextInt();
    
    //Display the random bytes.
    System.out.println("Random bytes\n" +
                   valA + " " + valB + " " + valC + "\n");

  }//end main
}//end class Jb0225Code
//End program specifications.