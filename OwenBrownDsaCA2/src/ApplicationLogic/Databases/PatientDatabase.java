/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApplicationLogic.Databases;

import ApplicationLogic.GP;
import ApplicationLogic.Patient;
import BinarySearchTree.BinarySearchTreeNode;
import BinarySearchTree.MyBinarySearchTree;
import java.time.LocalDate;

//This is a binary search tree storing all patients. It serves as a database. It is sorted by patient's ppsn.
public class PatientDatabase {
    
    //The BST instance. Has to be public for displaying contents in GUI. 
    public MyBinarySearchTree DB;

    public PatientDatabase() {
       
        //Hardcoding some patients. AI used for details
        Patient patient1 = new Patient("Owen Brown", 15, new GP(), LocalDate.of(1999, 8, 10));
        Patient patient2 = new Patient("John Doe", 12, new GP(), LocalDate.of(1985, 3, 14));
        Patient patient3 = new Patient("Jane Smith", 23, new GP(), LocalDate.of(1992, 7, 22));
        Patient patient4 = new Patient("Emily Davis", 4, new GP(), LocalDate.of(2000, 12, 5));
        Patient patient5 = new Patient("Michael Johnson", 5, new GP(), LocalDate.of(1988, 11, 2));
        Patient patient6 = new Patient("Chris Lee", 6, new GP(), LocalDate.of(1995, 9, 30));
        Patient patient7 = new Patient("Sarah Wilson", 70, new GP(), LocalDate.of(1983, 6, 18));
        Patient patient8 = new Patient("David White", 82, new GP(), LocalDate.of(1999, 1, 25));
        Patient patient9 = new Patient("Rachel Martin", 9, new GP(), LocalDate.of(1997, 4, 11));
        Patient patient10 = new Patient("Daniel Clark", 10, new GP(), LocalDate.of(2001, 2, 16));

        //Initializing the BST with a root.
        DB = new MyBinarySearchTree(patient1);

        //Inserting everyone else.
        DB.insert(new BinarySearchTreeNode(patient2, patient2.getPpsn()));
        DB.insert(new BinarySearchTreeNode(patient3, patient3.getPpsn()));
        DB.insert(new BinarySearchTreeNode(patient4, patient4.getPpsn()));
        DB.insert(new BinarySearchTreeNode(patient5, patient5.getPpsn()));
        DB.insert(new BinarySearchTreeNode(patient6, patient6.getPpsn()));
        DB.insert(new BinarySearchTreeNode(patient7, patient7.getPpsn()));
        DB.insert(new BinarySearchTreeNode(patient8, patient8.getPpsn()));
        DB.insert(new BinarySearchTreeNode(patient9, patient9.getPpsn()));
        DB.insert(new BinarySearchTreeNode(patient10, patient10.getPpsn()));
        System.out.println("elements added to Patient Database BTS in order: 15, 12, 23, 4, 5, 6, 70, 82, 9, 10");
        System.out.println("\nPreorder traversal:");
        DB.preOrderTraversal();
        System.out.println("\nInorder traversal:");
        DB.inOrderTraversal();
        System.out.println("\nPostorder traversal:");
        DB.postOrderTraversal();
        System.out.println("\n");
    }
}
