/*File Proj10Runner.java
The purpose of this assignment is to assess the student's
ability to write programs that use functional interfaces.

Whit Allee
04/20/2026
Professor Ricahrd G. Baldwin
ITSE-2317-001
***********************************************************/

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BiFunction;

class Proj10Runner {
    Proj10Runner() {
        System.out.println("I certify that this program is my own work\n" +
        "and is not the work of others. I agree not\n" +
        "to share my solution with others.\n" +
        "Whit Allee.");
    }

    Function<String, Integer> getLengthFunctionalInterface = new Function<String, Integer>() {
        @Override
        public Integer apply(String s) {
            return s.length();
        }
    };

    Predicate<Integer> isEvenFunctionalInterface = new Predicate<Integer>() {
        @Override
        public boolean test(Integer n) {
            return n % 2 == 0;
        }
    };

    BiFunction<String, String, String> concatenateFunctionalInterface = new BiFunction<String, String, String>() {
        @Override
        public String apply(String s1, String s2) {
            return s1 + s2;
        }
    };

    public int getLength(String s) {
        return getLengthFunctionalInterface.apply(s);
    }

    public boolean isEven(int n) {
        return isEvenFunctionalInterface.test(n);
    }

    public String concatenate(String s1, String s2) {
        return concatenateFunctionalInterface.apply(s1, s2);
    }

}