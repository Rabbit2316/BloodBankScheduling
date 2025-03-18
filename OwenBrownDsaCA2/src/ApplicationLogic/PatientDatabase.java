/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApplicationLogic;

import BinarySearchTree.BinarySearchTreeNode;
import BinarySearchTree.MyBinarySearchTree;
import java.time.LocalDate;


/**
 *
 * @author owen
 */

public class PatientDatabase {
    public MyBinarySearchTree DB;

    public PatientDatabase() {
        // Creating hard-coded patients
        Patient patient1 = new Patient("Owen Brown", 1, new GP(), LocalDate.of(1999, 8, 10));
        Patient patient2 = new Patient("John Doe", 223281, new GP(), LocalDate.of(1985, 3, 14));
        Patient patient3 = new Patient("Jane Smith", 129691, new GP(), LocalDate.of(1992, 7, 22));
        Patient patient4 = new Patient("Emily Davis", 543871, new GP(), LocalDate.of(2000, 12, 5));
        Patient patient5 = new Patient("Michael Johnson", 291332, new GP(), LocalDate.of(1988, 11, 2));
        Patient patient6 = new Patient("Chris Lee", 420671, new GP(), LocalDate.of(1995, 9, 30));
        Patient patient7 = new Patient("Sarah Wilson", 454299, new GP(), LocalDate.of(1983, 6, 18));
        Patient patient8 = new Patient("David White", 847994, new GP(), LocalDate.of(1999, 1, 25));
        Patient patient9 = new Patient("Rachel Martin", 828422, new GP(), LocalDate.of(1997, 4, 11));
        Patient patient10 = new Patient("Daniel Clark", 894854, new GP(), LocalDate.of(2001, 2, 16));

        // Initialize the BST with the first patient
        DB = new MyBinarySearchTree(patient1);

        // Insert the rest of the patients into the BST
        DB.insert(new BinarySearchTreeNode(patient2, patient2.getPpsn()));
        DB.insert(new BinarySearchTreeNode(patient3, patient3.getPpsn()));
        DB.insert(new BinarySearchTreeNode(patient4, patient4.getPpsn()));
        DB.insert(new BinarySearchTreeNode(patient5, patient5.getPpsn()));
        DB.insert(new BinarySearchTreeNode(patient6, patient6.getPpsn()));
        DB.insert(new BinarySearchTreeNode(patient7, patient7.getPpsn()));
        DB.insert(new BinarySearchTreeNode(patient8, patient8.getPpsn()));
        DB.insert(new BinarySearchTreeNode(patient9, patient9.getPpsn()));
        DB.insert(new BinarySearchTreeNode(patient10, patient10.getPpsn()));
    }
}
