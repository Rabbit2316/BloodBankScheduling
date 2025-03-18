package PriorityQueue;

import java.util.ArrayList;

public class MyPriorityQueue {

    public ArrayList<PQElement> theQueue;

    public MyPriorityQueue() {
        this.theQueue = new ArrayList<>();
    }

    //Enqueue method, checks the values of priority, and inserts at correct index.
    public void enqueue(int priority, Object data) {
        PQElement newElement = new PQElement(priority, data);
        int i = 0;
        while (i < theQueue.size() && theQueue.get(i).getPriority() >= priority) {
            i++;
        }
        theQueue.add(i, newElement);
    }

    public Object dequeue() {
        if (isEmpty()) 
            return null;
        return theQueue.remove(0).getData();
    }

    public boolean isEmpty() {
        return theQueue.isEmpty();
    }

    // Print the contents of the priority queue
    public void printPQ() {
        for (PQElement elem : theQueue) {
            System.out.println("Priority: " + elem.getPriority() + ", Data: " + elem.getData());
        }
    }
}
