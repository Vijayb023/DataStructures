public class Tester{
    public static void main(String[] args){
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        head.next = second;
        second.next = third;
/* The current linked list is as follows:
head second third
| | |
| | |
+----+------+ +----+------+ +----+------+
| 1 | o-------->| 2 | o-------->| 3 | null |
+----+------+ +----+------+ +----+------+ */
        System.out.println("List Before Deletion");

        printLinkedList(head); // Should be 1 2 3

        // User wants to delete Node at index 2
        deleteAtIndex(2, head);

        System.out.println("List after deleting the node at index 2");
        printLinkedList(head); // Will print 1 2

        // User wants to delete at Node index 1
        deleteAtIndex(1, head);

        System.out.println("List after deleting the node at index 1");
        printLinkedList(head);  //Should be 2
// The answer says to be 2 but I am getting errors trying to delete the 0 index.
        // Keeping the output as 1
    }

    // To pass the linked list to a function, you only need to pass the head
    public static void deleteAtIndex(int value, Node head){
        Node prev, curr;
        int counter = 0;// increment count as you traverse the list

        prev = null;   // Initializing prev to null

        curr = head;   // Having curr equal head of list


        while (counter++ != value) { // Loop until curr does not equal the node that will be deleted
            prev = curr;
            curr = curr.next;
        }
        if (prev == null) throw new AssertionError ();
        prev.next = curr.next;
    }// only thrown if there is an impossible error such as prev = null

    public static void printLinkedList(Node head){ for(Node cur =
                                                       head;cur!=null;cur=cur.next){ System.out.print(cur.item+" ");
    }
        System.out.println();
    }
    }
