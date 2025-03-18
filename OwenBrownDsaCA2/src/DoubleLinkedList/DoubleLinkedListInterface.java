package DoubleLinkedList;

//DLL Interface
public interface DoubleLinkedListInterface {

    public boolean isEmpty();
    public Object get(int index);
    public void add(Node newNode);
    public void remove(int index);
    public int size();
    public void printList();
    public void setCurrent(int index);
}
