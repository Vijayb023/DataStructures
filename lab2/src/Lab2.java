import java.util.Stack;

public class Lab2{
    public static void main(String[] args){
        String str = "{}{{{{}}";
        boolean ans = isBalanced(str);//Check if str is balanced or not
        System.out.println("Answer " + ans);// Should be False
    }

    public static boolean isBalanced(String str){
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<str.length();i++)//helps loop through string
        {
            char x = str.charAt(i);// charAt is used to return character at index i
            if (x == '{')

                stack.push((char) i);// push character to top of stack

            else if (x == '}'){//else
                if (stack.isEmpty()) //Checking to see if the stack is balanced
                    return false;
                else
                    stack.pop();
            }//Else pop the top char to match }


        }// verify if stack is empty
        return stack.isEmpty(); //return true if stack is empty
    }
}
