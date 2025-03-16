public class BinaryTree {
   public Node root;
    public void insert(Node newNode) {
        if(root == null) {
            root = newNode;
        } else {
            insertNode(root, newNode);
        }
    }
    private void insertNode(Node root, Node newNode) {
        if(root.leftChild == null) {
            root.leftChild = newNode;
        } else if(root.rightChild == null) {
            root.rightChild = newNode;
        } else {
            insertNode(root.leftChild, newNode);
        }
    }

    private void preorderTraversal(Node node) {
        if(node == null) return;
        else {
            System.out.println(node.data);
            preorderTraversal(node.leftChild);
            preorderTraversal(node.rightChild);
        }
    }

    public void preOrderTraversal() {
        preorderTraversal(this.root);
    }
}

