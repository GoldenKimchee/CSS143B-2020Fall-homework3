package Problem1;

public class ArrayStack<T> implements Stack<T> {
    // do not change member variables
    private T[] data;
    private int size;

    private ArrayStack() {
    }

    //Creates empty stack with capacity from parameter
    public ArrayStack(int capacity) {
        if (capacity > 0) {
            data = (T[]) new Object[capacity];
        }
        size = 0;
    }

    //Adds the element to the top of the stack
    @Override
    public boolean push(T val) {
        if (val == null || data.length == 0 || size == data.length) {
            return false;
        }
        data[size] = val;
        size++;
        return true;
    }

    //Removes element on top of the stack
    @Override
    public T pop() {
        if (data != null && data.length != 0) {
            size--;
            T val = data[size];
            return val;
        }
        return null;
    }

    //Returns value of element at top of stack
    @Override
    public T peek() {
        if (data == null || data.length == 0 || size == 0) {
            return null;
        }
        T val = data[size - 1];
        return val;
    }

    @Override
    public int size() {
        return size;
    }
}
