package Queue;

import java.util.ArrayList;

public class MyQueue implements QueueInterface {

    public ArrayList<Object> theQueue;
    
    public MyQueue() {
        theQueue = new ArrayList<>();
    }

    @Override
    public void enqueue(Object obj) {
        theQueue.add(obj);
    }

    @Override
    public Object dequeue() {
        if(theQueue.isEmpty())
            return null;
        else {
            Object toReturn = theQueue.get(0);
            theQueue.remove(0);
            return toReturn;
        }
    }

    @Override
    public int size() {
        return theQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return theQueue.isEmpty();
    }

    @Override
    public Object frontElement() {
        return theQueue.get(0);
    }
}
