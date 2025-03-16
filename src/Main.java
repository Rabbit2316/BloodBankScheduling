public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(new Node("root"));
        tree.insert(new Node("root-left"));
        tree.insert(new Node("root-right"));
        tree.insert(new Node("root-left-left"));
        tree.insert(new Node("root-right-right"));
        tree.preOrderTraversal();
    }
}
