package Stack;

import java.util.ArrayList;

public class MyStack implements StackInterface{

    protected ArrayList<Object> theStack;
    
    public MyStack() {
        theStack = new ArrayList<Object>();
    }

    @Override
    public void push(Object obj) {
        theStack.add(obj);
    }

    @Override
    public Object peek() {
        if(theStack.isEmpty())
            return null;
        else
            return theStack.get(theStack.size()-1);
    }

    @Override
    public Object pop() {
        if(theStack.isEmpty())
            return null;
        else {
            Object toReturn = theStack.get(theStack.size()-1);
            theStack.remove(theStack.size()-1);
            return toReturn;
        }
    }

    @Override
    public boolean isEmpty() {
        return theStack.isEmpty();
    }

    @Override
    public int size() {
        return theStack.size();
    }

    @Override
    public void displayStack() {
        for (Object obj : theStack) System.out.println(obj.toString());
    }

    @Override
    public Object peekAtBottom() {
        if(theStack.isEmpty())
            return null;
        else
            return theStack.get(0);
    }

    @Override
    public void emptyStack() {
        theStack.clear();
    }
}
