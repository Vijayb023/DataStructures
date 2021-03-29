import java.util.Stack;
public class Lab3 {
    public static void main (String[] args){ String
            s1 = "DataStructuresIssss###Fun"; String
            s2 = "DataStructuresIszwp###Fun"; boolean
            ans = backspaceCompare(s1,s2);
        System.out.println(ans); // Should be True
    }
        public static boolean backspaceCompare(String s1, String s2) {
            Stack<Character> s1_stack=new Stack<Character>();
            Stack<Character> s2_stack=new Stack<Character>();

            //if # is present pop if not push
            for(int i=0;i<s1.length();i++)// loop for going through the index of the string
            {

                if(s1.charAt(i)=='#'){

                    s1_stack.pop();//pop if # is present
                }
                else
                {
                    s1_stack.push(s1.charAt(i));// //push to stack if its not there
                }
            }

            //Same process for String 2 as well
            for(int i=0;i<s2.length();i++)
            {
                if(s2.charAt(i)=='#') {
                    s2_stack.pop();
                }
                else{

                    s2_stack.push(s2.charAt(i));
                }
            }

            while(!s1_stack.isEmpty())//run this function if stack 1 is empty
            {
                if(s1_stack.peek() == s2_stack.peek())//peek is used to retrieve the top element in the stack. and its seeing if s1 and s2 same
                {
                    s1_stack.pop();//remove from stack 1 the element
                    s2_stack.pop();// remove from stack 2 the element
                }
                else
                    return false;
            }
            return s2_stack.isEmpty();
        }
}