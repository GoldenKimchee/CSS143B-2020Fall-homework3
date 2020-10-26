package Problem1;

public class MinStack extends ArrayStack<Integer> {
    private int[] minimum;
    private int minSize;

    public MinStack(int capacity) {
        super(capacity);
        minimum = new int[capacity];
        minSize = 0;
    }

    @Override
    public boolean push(Integer val) {
        super.push(val);
        if (minSize == 0) {
            minimum[minSize] = val;
            minSize++;
        } else if (super.peek() < minimum[minSize - 1]) {
            minimum[minSize] = val;
            minSize++;
        }
        return true;
    }
    //[1,0]
    //0
    @Override
    public Integer pop() {
        int val = super.pop();
        if (minSize > 0) {
            if (val == minimum[minSize - 1]) {
                minSize--;
            }
        }
        return val;
    }

    public Integer getMin() {
        if (minSize == 0) {
            return null;
        }
        return minimum[minSize - 1];
    }
}

