/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PriorityQueue;

/**
 *
 * @author owen
 */
public interface PriorityQueueInterface {
    public void enqueue(int k, Object d);
    public Object poll();
    public boolean isEmpty();
    public void printPQ();
}
