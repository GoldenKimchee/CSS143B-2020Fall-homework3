package Problem1;

import java.util.LinkedList;

public class LinkedListStack<T> implements Stack<T> {
    private LinkedList<T> data;

    public LinkedListStack() {
        data = new LinkedList<>();
    }

    @Override
    public boolean push(T val) {
        data.addFirst(val);
        return true;
    }

    @Override
    public T pop() {
        if (data.size() > 0) {
            T val = data.removeFirst();
            return val;
        }
        return null;
    }

    @Override
    public T peek() {
        if (data.size() > 0) {
            T val = data.peek();
            return val;
        }
        return null;
    }

    @Override
    public int size() {
        return data.size();
    }
}
