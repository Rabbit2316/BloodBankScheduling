package BinarySearchTree;

public interface BinarySearchTreeInterface {
        void insert(BinarySearchTreeNode newNode);
        Object delete(BinarySearchTreeNode node, int value);
        boolean search(int value);
        void preOrderTraversal();
        void inOrderTraversal();
        void postOrderTraversal();
}
