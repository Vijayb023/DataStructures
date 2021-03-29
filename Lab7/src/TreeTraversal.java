

public class TreeTraversal {

    public static void main(String[] args) {
        BinaryTree<Character> tree1 = new BinaryTree("H");
        BinaryTree<Character> rightsubtree1 = new BinaryTree("X");
        rightsubtree1.attachRight('Y');
        BinaryTree<Character> leftsubtree1 = new BinaryTree("D");
        leftsubtree1.attachLeft('B');
        BinaryTree<Character> leftsubtree2 = new BinaryTree("F");
        leftsubtree2.attachRight('G');
        leftsubtree2.attachLeft('E');
        leftsubtree1.attachRightSubtree(leftsubtree2);
        tree1.attachLeftSubtree(leftsubtree1);
        tree1.attachRightSubtree(rightsubtree1);
        BinaryTree<Character> tree2 = new BinaryTree("F");

        BinaryTree<Character> rightSubtree1 = new BinaryTree("G");

        BinaryTree<Character> leftSubtree1 = new BinaryTree("B");
        leftSubtree1.attachLeft('A');

        BinaryTree<Character> rightSubtree2 = new BinaryTree("I");
        rightSubtree2.attachLeft('H');

        BinaryTree<Character> leftSubtree2 = new BinaryTree("D");
        leftSubtree2.attachRight('E');
        leftSubtree2.attachLeft('C');

        rightSubtree1.attachRightSubtree(rightSubtree2);
        leftSubtree1.attachRightSubtree(leftSubtree2);

        tree2.attachLeftSubtree(leftSubtree1);
        tree2.attachRightSubtree(rightSubtree1);

        System.out.println(checkSkipped(tree1)); // Should return true
        System.out.println(checkSkipped(tree2)); // Should return false
    }

    public static boolean checkSkipped(BinaryTree<Character> tree)
    {
        /* // To Iterate a tree using Inorder Traversal
        TreeIterator<Character> iter = new TreeIterator<Character>(tree);
        iter.setInorder();
        while (iter.hasNext()){
        System.out.print (iter.next());
        }
        */
        String inorderStr = tree.getInorderString();
        System.out.println("Input: "+inorderStr);
        if (inorderStr.length() <= 1) return true;
        int i = 1;
        char last = inorderStr.charAt (0);
        if (inorderStr.length () > i) do {
            char c = inorderStr.charAt (i);
            if (c - last != 1) return true;
            last = c;
            i++;
        } while (inorderStr.length () > i);
        return false;
    }
}

class TreeNode<T> {
    private T item;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public TreeNode(T newItem) {
        // Initializes tree node with item and no children.
        item = newItem;
        leftChild = null;
        rightChild = null;
    } // end constructor

    public TreeNode(T newItem, TreeNode<T> left, TreeNode<T> right) {
        // Initializes tree node with item and
        // the left and right children references.
        item = newItem;
        leftChild = left;
        rightChild = right;
    } // end constructor

    public T getItem() {
        // Returns the item field.
        return item;
    } // end getItem

    public void setItem(T newItem) {
        // Sets the item field to the new value newItem.
        item = newItem;
    } // end setItem

    public TreeNode<T> getLeft() {
        // Returns the reference to the left child.
        return leftChild;
    } // end getLeft

    public void setLeft(TreeNode<T> left) {
        // Sets the left child reference to left.
        leftChild = left;
    } // end setLeft

    public TreeNode<T> getRight() {
        // Returns the reference to the right child.
        return rightChild;
    } // end getRight

    public void setRight(TreeNode<T> right) {
        // Sets the right child reference to right.
        rightChild = right;
    } // end setRight
} // end TreeNode

abstract class BinaryTreeBasis<T> {
    protected TreeNode<T> root;

    public BinaryTreeBasis() {
        root = null;
    } // end default constructor

    public BinaryTreeBasis(T rootItem) {
        root = new TreeNode<T>(rootItem, null, null);
    } // end constructor

    public boolean isEmpty() {
        // Returns true if the tree is empty, else returns false.
        return root == null;
    } // end isEmpty

    public void makeEmpty() {
        // Removes all nodes from the tree.
        root = null;
    } // end makeEmpty

    public T getRootItem() throws TreeException {
        // Returns the item in the trees root.
        if (root == null) {
            throw new TreeException("TreeException: Empty tree");
        } else {
            return root.getItem();
        } // end if
    } // end getRootItem


    public String getInorderString() {
        return getInorderString(root);
    }

    private String getInorderString(TreeNode<T> tree) {
        if (tree == null) {
            return "";
        } else {
            return (
                    getInorderString(tree.getLeft()) +
                            tree.getItem().toString() +
                            getInorderString(tree.getRight())
            );
        }
    }
} // end BinaryTreeBasis

class TreeException extends RuntimeException {

    public TreeException(String s) {
        super(s);
    } // end constructor
} // end TreeException

class BinaryTree<T> extends BinaryTreeBasis<T> {

    public BinaryTree() {} // end default constructor

    public BinaryTree(T rootItem) {
        super(rootItem);
    } // end constructor

    public BinaryTree(
            T rootItem,
            BinaryTree<T> leftTree,
            BinaryTree<T> rightTree
    ) {
        root = new TreeNode<T>(rootItem, null, null);
        attachLeftSubtree(leftTree);
        attachRightSubtree(rightTree);
    } // end constructor

    public void setRootItem(T newItem) {
        if (root != null) {
            root.setItem(newItem);
        } else {
            root = new TreeNode<T>(newItem, null, null);
        } // end if
    } // end setRootItem

    public void attachLeft(T newItem) {
        if (!isEmpty() && root.getLeft() == null) {
            // assertion: nonempty tree; no left child
            root.setLeft(new TreeNode<T>(newItem, null, null));
        } // end if
    } // end attachLeft

    public void attachRight(T newItem) {
        if (!isEmpty() && root.getRight() == null) {
            // assertion: nonempty tree; no right child
            root.setRight(new TreeNode<T>(newItem, null, null));
        } // end if
    } // end attachRight

    public void attachLeftSubtree(BinaryTree<T> leftTree) throws TreeException {
        if (isEmpty()) {
            throw new TreeException("TreeException:  Empty tree");
        } else if (root.getLeft() != null) {
            // a left subtree already exists; it should have been
            // deleted first
            throw new TreeException(
                    "TreeException: " + "Cannot overwrite left subtree"
            );
        } else {
            // assertion: nonempty tree; no left child
            root.setLeft(leftTree.root);
            // don't want to leave multiple entry points into
            // our tree
            leftTree.makeEmpty();
        } // end if
    } // end attachLeftSubtree

    public void attachRightSubtree(BinaryTree<T> rightTree) throws TreeException {
        if (isEmpty()) {
            throw new TreeException("TreeException:  Empty tree");
        } else if (root.getRight() != null) {
            // a right subtree already exists; it should have been
            // deleted first
            throw new TreeException(
                    "TreeException: " + "Cannot overwrite right subtree"
            );
        } else {
            // assertion: nonempty tree; no right child
            root.setRight(rightTree.root);
            // don't want to leave multiple entry points into
            // our tree
            rightTree.makeEmpty();
        } // end if
    } // end attachRightSubtree




}