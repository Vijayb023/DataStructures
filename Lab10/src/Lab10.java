import java.util.Arrays;
import java.util.HashSet;
public class Lab10 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        int k = 3;
        long start = System.currentTimeMillis ();
        System.out.println ("Count is " + solve_with_Hash (arr, k)); // should be 2
        System.out.println ("Total execustion time (taken by solve_with_Hash):"
                + (System.currentTimeMillis () - start));
        start = System.currentTimeMillis ();
        System.out.println ("\n\nCount is " + solve_with_Sort (arr, k)); // should be
        System.out.println ("Total execustion time (taken by solve_with_Sort):"
                + (System.currentTimeMillis () - start));
    }

    public static int solve_with_Sort(int[] arr, int
            k) {
        int counter = 0;
// INSERT CODE HERE
        int left = 0, right = 0;

        Arrays.sort (arr);

        if (right < arr.length) do {

            int diff = arr[right] - arr[left];

            if (diff < k) {
                right++;
            } else if (diff == k) {
                left++;
                right++;
                counter++;
            } else {
                left++;
            }
        } while (right < arr.length);
        return counter;
    }

    public static int solve_with_Hash(int[] arr, int k)
    {
        int counter = 0;
        HashSet<Integer> hash = new HashSet<Integer> ();
// INSERT CODE HERE
        int i = 0, arrLength = arr.length;
        while (i < arrLength) {
            int x = arr[i];
            hash.add (x);
            i++;
        }

        // check all elements of array
        int j = 0;
        int length = arr.length;
        if (j < length) {
            do {
                int x = arr[j];
                if (hash.contains (x + k) || hash.contains (x - k)) {
                    counter++;
                }
                hash.remove (x);
                j++;
            } while (j < length);
        }
        return counter;
    }
}