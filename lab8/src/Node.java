
// A binary tree node
class Node {
    int data;
    Node left, right;
    Node(int d)
    {
        data = d;
        left = right = null;
    }
}
class BinarySearchTree {
    // Root of BST
    Node root;
    // Constructor
    BinarySearchTree()
    {
        root = null;
    }
    // function to insert nodes
    public void insert(int data)
    {
        this.root = this.insertRec(this.root, data);
    }
    /* A utility function to insert a new node
    with given key in BST */
    Node insertRec(Node node, int data)
    {
        // if tree is empty return new node
        if (node == null) {
            this.root = new Node(data);
            return this.root;
        }
        if (data == node.data) return node;
        // helped to place the tree in order
        if (data < node.data) node.left = this.insertRec (node.left, data);
        else {
            node.right = this.insertRec(node.right, data);
        }
        return node;
    }


    // class that stores the value of count
    public class count {
        int c = 0;
    }
    // utility function to find kth largest node in a given tree
    void kthLargestUtil(Node node, int k, count C)
    {
// Base cases, the second condition is important to
// avoid unnecessary recursive calls
        if (node == null || C.c >= k)
            return;
        // we follow inorder traversal  inreverse order so that the largest element is visited first
        this.kthLargestUtil(node.right, k, C);

        // Increment count of nodes whcih are being visted
        C.c++;

        // If c is equal to k now, then return the answer
        if (C.c == k) {
            System.out.println( "k = " + k + ", largest Node in the Binary Search Tree " +
                    node.data);
            return;
        }

        //this is for recursing the code to the left
        this.kthLargestUtil(node.left, k, C);
    }

    // Method to find the kth largest no in given BST
    void kthLargest(int k)
    {
        count c = new count(); // object of class count
        this.kthLargestUtil(this.root, k, c);
    }
    // Driver function
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        int k=3;
        tree.kthLargest(k);

    }
}
