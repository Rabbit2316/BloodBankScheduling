package DoubleLinkedList;

public class DoubleLinkedList implements DoubleLinkedListInterface {
    private Node head;
    private Node tail;
    private Node previous;
    private Node current;
    private int size;

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object get(int index) {
        setCurrent(index);
        return current.getData();
    }

    @Override
    public void add(Node newNode) {
        tail.setNext(newNode);
        newNode.setPrev(tail);
        tail = newNode;
        size++;
    }

    @Override
    public void remove(int index) {
        setCurrent(index);

        //If removing the head
        if(current == head) {
            head = head.getNext();
            if(head != null) {
                head.setPrev(null);
            }
        }

        //If removing the tail
        if(current == tail) {
            tail = previous;
        }
        this.previous.setNext(this.current.getNext());
        this.current.getNext().setPrev(previous);
        size--;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void printList() {
        while(current.getNext() != null) {
            System.out.println(current.getData().toString());
            previous = current;
            current = current.getNext();
        }
    }

    @Override
    public void setCurrent(int index) {
        int i = index;
        previous = null;
        current = head;
        for(int j = 0; j<i; j++) {
            previous = current;
            current = current.getNext();
        }
    }
}
