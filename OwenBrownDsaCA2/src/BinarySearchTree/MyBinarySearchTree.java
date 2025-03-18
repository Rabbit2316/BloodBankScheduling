package BinarySearchTree;

import ApplicationLogic.Patient;
import java.awt.List;
import java.util.ArrayList;

public class MyBinarySearchTree implements BinarySearchTreeInterface {

    BinarySearchTreeNode root;

    public MyBinarySearchTree(Patient p) {
        root = new BinarySearchTreeNode(p, p.getPpsn());
        
    }
    
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
    public Object search(int value) {
        return search(root, value);
    }

    private Object search(BinarySearchTreeNode node, int value) {
        if (node == null) {
            return false;
        }
        if (node.getValue() == value) {
            return node.getData();
        }
        return value < node.getValue() 
            ? search(node.leftChild, value) 
            : search(node.rightChild, value);
    }

    @Override
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(BinarySearchTreeNode node) {
        if (node == null) return;
        System.out.print(node.getValue() + " ");
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    @Override
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(BinarySearchTreeNode node) {
        if (node == null) return;
        inOrderTraversal(node.leftChild);
        System.out.print(node.getValue() + " ");
        inOrderTraversal(node.rightChild);
    }

    @Override
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(BinarySearchTreeNode node) {
        if (node == null) return;
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.print(node.getValue() + " ");
    }
public ArrayList<Patient> getAllPatients() {
    ArrayList<Patient> patients = new ArrayList<>();
    inOrderTraverseAndAddPatients(root, patients);
    return patients;
}

private void inOrderTraverseAndAddPatients(BinarySearchTreeNode node, ArrayList<Patient> patients) {
    if (node == null) {
        return;
    }
    inOrderTraverseAndAddPatients(node.leftChild, patients);  // Traverse left subtree
    patients.add((Patient) node.getData());  // Add the patient to the list
    inOrderTraverseAndAddPatients(node.rightChild, patients);  // Traverse right subtree
}

}

