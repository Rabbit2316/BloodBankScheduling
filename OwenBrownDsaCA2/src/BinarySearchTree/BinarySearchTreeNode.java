package BinarySearchTree;

//Node class for the BST.
public class BinarySearchTreeNode {
    private Object data;
    private int value;
    BinarySearchTreeNode leftChild;
    BinarySearchTreeNode rightChild;

    public BinarySearchTreeNode(Object data, int value) {
        this.data = data;
        this.value = value;
        leftChild = null;
        rightChild = null;
    }
    
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BinarySearchTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinarySearchTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public BinarySearchTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinarySearchTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
