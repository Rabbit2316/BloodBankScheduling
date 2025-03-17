package BinarySearchTree;

public class MyBinarySearchTree implements BinarySearchTreeInterface {

    BinarySearchTreeNode root;

    @Override
    public void insert(BinarySearchTreeNode newNode) {
        if (newNode.getValue() < root.getValue()) {
            if (root.leftChild == null) {
                root.leftChild = newNode;
            } else {
                insert(root.leftChild, newNode);
            }
        } else {
            if (root.rightChild == null) {
                root.rightChild = newNode;
            } else {
                insert(root.rightChild, newNode);
            }
        }
    }
    //Use of abstraction here to provide classes with access to an insert method with just the new Node as an argument,
    //And an internal insert method to allow for the recursion traversal.
    protected void insert(BinarySearchTreeNode root, BinarySearchTreeNode newNode) {
        if (newNode.getValue() < root.getValue()) {
            if (root.leftChild == null) {
                root.leftChild = newNode;
            } else {
                insert(root.leftChild, newNode);
            }
        } else {
            if (root.rightChild == null) {
                root.rightChild = newNode;
            } else {
                insert(root.rightChild, newNode);
            }
        }
    }

    @Override
    public Object delete(BinarySearchTreeNode root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.getValue()) {
            root.leftChild = (BinarySearchTreeNode) delete(root.leftChild, value);
        } else if (value > root.getValue()) {
            root.rightChild = (BinarySearchTreeNode) delete(root.rightChild, value);
        } else {
            if (root.leftChild == null && root.rightChild == null) {
                return null;
            } else if (root.leftChild == null) {
                return root.rightChild;
            } else if (root.rightChild == null) {
                return root.leftChild;
            } else {
                BinarySearchTreeNode successor = findMin(root.rightChild);
                root.setValue(successor.getValue());
                root.rightChild = (BinarySearchTreeNode) delete(root.rightChild, successor.getValue());
            }
        }

        return root;
    }

    private BinarySearchTreeNode findMin(BinarySearchTreeNode node) {
        while (node.leftChild != null) {
            node = node.leftChild;
        }

        return node;
    }

    @Override
    public boolean search(int value) {
        return false;
    }

    @Override
    public void preOrderTraversal() {

    }

    @Override
    public void inOrderTraversal() {

    }

    @Override
    public void postOrderTraversal() {

    }
}
