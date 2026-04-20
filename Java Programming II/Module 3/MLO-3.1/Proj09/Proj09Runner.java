/*File Proj09Runner.java
The purpose of this assignment is to assess the student's
ability to write code dealing with Java streams. Student's
code must use streams to sort the String data in an
incoming array object in descending order and return the
sorted data in an object of type List.

Whit Allee
04/20/2026
Professor Ricahrd G. Baldwin
ITSE-2317-001
***********************************************************/

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Proj09Runner {
    String[] myData;
    
    Proj09Runner(String[] data) {
        System.out.println("I certify that this program is my own work\n"
                            + "and is not the work of others. I agree not\n"
                            + "to share my solution with others.\n"
                            + "Whit Allee\n");
        
        myData = data;
    }

    List<String> run() {
        return Arrays.asList(myData).stream()
                                    .sorted(Comparator.reverseOrder())
                                    .toList();
    }
}