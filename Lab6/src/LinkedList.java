public class LinkedList {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) //Node Constructor
        {
            data = d;
            next = null;
        }
    }

    /* Function to reverse the linked list */
    Node reverse(Node node)
    {
// Initializing 3 variables prev, current, and next

        Node prev= null;// the node before the current one
        Node curr = node;// the current is the one being reversed
        Node next;// the next one

        while (curr != null) {
            // we make the current next node = current
            next = curr.next;
            // we make the current node = previous one
            curr.next = prev; //here current node points to the previous node
            // make the previous node equal current
            prev = curr;
            // we make the current node = next
            curr = next;
        }
        node = prev;
        return node; //return new node
    }
    // prev      cur    null
    // 1          2      3  ---> Null
    // prints content of double linked list
    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);


        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }
}