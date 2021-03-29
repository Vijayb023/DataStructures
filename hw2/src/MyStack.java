import java.util.Stack;

public class MyStack {
    Stack<Integer> s;
    // A   user defined stack that supports getMin() in
// addition to push() and pop()
    public MyStack() {
        s = new Stack<> ();// creating stack
    }

    // Prints the minimum element of MyStack
     void getMin() {

        // if stack empty no null value instead place string
        if(isEmpty()) {
            System.out.println("Empty Stack");
            return;
        }

        // initializing the max value to min variable
        int min = s.stream ().mapToInt (i -> i).min ().orElse (Integer.MAX_VALUE);
        System.out.println("Minimum Element in current stack : "+min);
    }
    // prints top element of MyStack
    private void peek() {

        // if stack is empty there is no top so we will return string
        if(isEmpty()) {
            System.out.println("Empty Stack");
            return;
        }

        System.out.println("Top of current stack : "+s.peek());
    }


    // Removes the top element from MyStack
    private void pop() {

        // if stack is empty we cannot pop so we return
        if(isEmpty()) {
            System.out.println("Empty Stack");
            return;
        }
        System.out.println("Popped Element : "+s.pop());

    }
    // Insert new number into MyStack
    private void push(int i) {
        s.push(i);

    }
    // check whether Stack is Empty
    public boolean isEmpty() {
        return s.size()==0;
    }
    // driver
    public static void main(String[] args)
    {   MyStack s = new MyStack();
        s.push(3);
        s.push(5);
        s.getMin();
        s.push(2);
        s.push(1);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.peek();
    }
}