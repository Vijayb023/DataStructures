import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
public class Lab4 {
    public static void main (String[] args){
      String s1 = "radar";

        boolean ans = checkPalindrome(s1);
        System.out.println(ans); // Should be True
    }
    public static boolean checkPalindrome(String s1){
        Stack<Character> s = new Stack<Character>();
        Queue<Character> q = new LinkedList<Character>();
        s1=s1.toLowerCase();// In case some inputs have capital letters
        for (int i = 0; i < s1.length(); i++) {  // looping through the characters in s1 until the characters are in stack and queue

            s.push(s1.charAt(i));// pushing the first character into the top of the stack

            q.add(s1.charAt(i));//add to queue

        }


        // loop until no more characters in both q and s

        while (!s.isEmpty()) if (s.pop() != q.poll()) {//.pop removes the end character from stack and compares to first character from queue
            //.pop if empty throws in a EmptyStackExepection will .poll throws in null

            return false;

        }

        // Return true if values do match

        return true;

    }

}