import java.util.HashSet;
import java.util.LinkedHashSet;
public class FindSum {

    public static void main(String args[]) {
        int[] arr = {1, 5, 4, 6, 7, 9};
        HashSet<Integer> res = findSums (arr);
        System.out.println (res.toString ()); // Should return [6,5,7,9]
    }

    public static HashSet<Integer> findSums(int[] elements) {
        HashSet<Integer> sums = new HashSet<Integer> ();
        HashSet<Integer> hashtable = new LinkedHashSet<> (); // using a linked hashset to preserve  insertion order
// To add "newItem" to hashtable hashtable.add(newItem);
        for (int i = 0; i < elements.length; i++) {
            sums.add (elements[i]);
        }
// To check if "item" exist in hashtable hashtable.contains(item);
        for (int i = 0; i < elements.length; i++) { //going through the elements
            for (int j = i; j < elements.length; j++) {
                int sum = elements[i] + elements[j];
                { //calculate pairs
                    if (sums.contains (sum))//if sum is in hashtable add to the set
                        hashtable.add (sum);
                }
            }
        }
        return hashtable;
    }
}

