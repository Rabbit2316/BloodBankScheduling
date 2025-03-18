package DoubleLinkedList;

//My double linked list class.
public class MyDoubleLinkedList implements DoubleLinkedListInterface {
    private Node head;
    private Node tail;//Keep track of tail for fast insertion.
    private Node previous;
    private Node current;
    private int size;

    //Interface implementation.
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object get(int index) {
        setCurrent(index);
        return current.getData();
    }
    
    //Adding to list
    @Override
    public void add(Node newNode) {
        //If list is empty
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } 
        //Otherwise, set the new node as the tail and the old tail as its previous pointer. And the old tails next pointer to new node.
        else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    //Removing from the list.
    @Override
    public void remove(int index) {
        //Traverse to item to be removed.
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
        //Reassigning pointers of previous and next nodes.
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

    //Simple traversal.
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
