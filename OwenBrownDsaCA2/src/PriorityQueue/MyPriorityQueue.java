package PriorityQueue;

import java.util.ArrayList;

public class MyPriorityQueue {

    public ArrayList<PQElement> theQueue;

    public MyPriorityQueue() {
        this.theQueue = new ArrayList<>();
    }

    // Enqueue with priority
    public void enqueue(int priority, Object data) {
        PQElement newElement = new PQElement(priority, data);
        int i = 0;
        while (i < theQueue.size() && theQueue.get(i).getPriority() >= priority) {
            i++;
        }
        theQueue.add(i, newElement); // Add the element at the correct position
    }

    // Dequeue to return the highest priority element
    public Object dequeue() {
        if (isEmpty()) return null;
        return theQueue.remove(0).getData(); // Remove and return the data of the highest priority element
    }

    // Check if the priority queue is empty
    public boolean isEmpty() {
        return theQueue.isEmpty();
    }

    // Print the contents of the priority queue for debugging
    public void printPQ() {
        for (PQElement elem : theQueue) {
            System.out.println("Priority: " + elem.getPriority() + ", Data: " + elem.getData());
        }
    }
}
