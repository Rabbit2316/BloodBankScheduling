package Stack;

public interface StackInterface {

    public void push(Object obj);
    public Object peek();
    public Object pop();
    public boolean isEmpty();
    public int size();
    public void displayStack();
    public Object peekAtBottom();
    public void emptyStack();
}