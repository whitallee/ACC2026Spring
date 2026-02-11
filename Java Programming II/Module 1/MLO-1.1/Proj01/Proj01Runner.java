import java.util.*;
class Proj01Runner {
    private int[] vals;

    public Proj01Runner(int[] vals) {
        this.vals = vals;
        System.out.println(
            "I certify that this program is my own work\n" +
            "and is not the work of others. I agree not\n" +
            "to share my solution with others.\n" +
            "Whit Allee\n"
        );
    }

    // create a collection of the values in the vals array in the same order as they are in the array
    public Collection runA() {
        Collection collection = new ArrayList();
        for (int val : vals) {
            collection.add(val);
        }
        return collection;
    }

    // create a collection of the unique values in the vals array in ascending order (this should use a TreeSet)
    public Collection runB() {
        Collection collection = new TreeSet();
        for (int val : vals) {
            collection.add(val);
        }
        return collection;
    }
}
