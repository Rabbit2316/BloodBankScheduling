package Queue;

public interface QueueInterface {

    public void enqueue(Object obj);
    public Object dequeue();
    public int size();
    public boolean isEmpty();
    public Object frontElement();
}
