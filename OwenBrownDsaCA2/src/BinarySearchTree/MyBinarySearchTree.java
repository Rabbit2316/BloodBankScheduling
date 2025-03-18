package BinarySearchTree;

import ApplicationLogic.Patient;
import java.util.ArrayList;

//My binary search tree.
public class MyBinarySearchTree implements BinarySearchTreeInterface {

    BinarySearchTreeNode root;//Root node.

    //Constructor
    public MyBinarySearchTree(Patient p) {
        root = new BinarySearchTreeNode(p, p.getPpsn());
        
    }
    
    //Implementation of interface
    @Override
    public void insert(BinarySearchTreeNode newNode) {
        root = InsertHelper(root, newNode);
    }

    private BinarySearchTreeNode InsertHelper(BinarySearchTreeNode current, BinarySearchTreeNode newNode) {
        if (current == null) {//If current root is null
            return newNode;
        }

        if (newNode.getValue() < current.getValue()) {//If going left
            current.leftChild = InsertHelper(current.leftChild, newNode);//Call helper with left child
        } 
        else {//if going right.
            current.rightChild = InsertHelper(current.rightChild, newNode);//Call helper with right child
        }

        return current; //Return the node were at 
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
        } 
        else {
            if (root.rightChild == null) {
                root.rightChild = newNode;
            } else {
                insert(root.rightChild, newNode);
            }
        }
        System.out.println("Adding node to binary search tree");
    }

    @Override
    public Object delete(BinarySearchTreeNode root, int value) {
        return null;
    }

    //Public facing interface for searching BST - used by GP for logging in patients. 
    @Override
    public Object search(int value) {
        return search(root, value);//Use helper function to search by the value.
    }

    //Search helper function.
    private Object search(BinarySearchTreeNode node, int value) {
        //If tree is null.
        if (node == null) {
            return false;
        }
        
        //If node matches the search query/
        if (node.getValue() == value) {
            return node.getData();
        }             
        
        //If going down left path
        if(value < node.getValue()) {
            return search(node.leftChild, value);
        }
        
        //If going down right path.
        else {
            return search(node.rightChild, value);
        } 
    }

    //Traversal methods from class with public interfaces and private helpers.
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
    
    //Method for getting all patients for making appointments.
    public ArrayList<Patient> getAllPatients() {
        ArrayList<Patient> patients = new ArrayList<>();
        inOrderTraverseAndAddPatients(root, patients);
        return patients;
    }

    private void inOrderTraverseAndAddPatients(BinarySearchTreeNode node, ArrayList<Patient> patients) {
        if (node == null) {
            return;
        }
        inOrderTraverseAndAddPatients(node.leftChild, patients);//Traverse far left
        patients.add((Patient) node.getData());//Add patient at this call
        inOrderTraverseAndAddPatients(node.rightChild, patients);//Traverse right options
    }

}

