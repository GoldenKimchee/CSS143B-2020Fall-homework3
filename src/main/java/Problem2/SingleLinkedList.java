package Problem2;

// all functions assume using dummy node
public class SingleLinkedList {
    // do not add member variables
    private ListNode head;
    private int size;

    public SingleLinkedList() {
        head = new ListNode();  // dummy node
    }

    // copy constructor
    public SingleLinkedList(SingleLinkedList list) {
        //followed instructor's code. if you would like to see my original solution,
        //please check the first commit! (changed it because this looks less messy)
        if (list == null) {
            return;
        }

        //create dummy node
        ListNode p1 = new ListNode();
        head = p1;

        //use pointer to point to first read node of the list
        ListNode p2 = list.head.next;

        while (p2 != null) {
            p1.next = new ListNode(p2.val);
            p1 = p1.next;
            p2 = p2.next;
        }
        size = list.size;
    }

    public int removeAll(int valueToRemove) {
        if (head == null) {
            return 0;
        }
        while (head.val == valueToRemove) { //if head or first values are value to remove
            head = head.next;
        }
        int removed = 0;
        ListNode current = head;
        while (current.next != null) {      //check rest of the list
            if (current.next.val == valueToRemove) {    //if matches, then
                current.next = current.next.next;   //set next to skip over a node
                size--;
                removed++;
            } else {
                current = current.next;
            }
        }
        return removed;
    }

    // reverse the linked list nodes iteratively (no recursion)
    public void reverse() {
        if (size > 1) { //thank you so much to prof peng du for helping me on this question!!
            ListNode p1 = head.next;
            ListNode p2 = head.next.next;
            while (p2 != null) {
                p1.next = p2.next; //set the pointer to point at the next value BEFORE I delete it!!
                p2.next = head.next; //now is not referencing null, but the value that head.next points to
                head.next = p2;
                p2 = p1.next;
            }
        }
    }

    public SingleLinkedList(int[] data) {
        this();
        if (data == null) {
            return;
        }
        ListNode ptr = head;
        for (int datum : data) {
            ptr.next = new ListNode(datum);
            ptr = ptr.next;
            size++;
        }
    }

    // Appends the specified element to the end of this list
    public void add(int val) {
        size++;
        ListNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new ListNode(val);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode ptr = head.next;
        while (ptr != null) {
            builder.append(ptr.val).append(ptr.next == null ? " -> end " : " -> ");
            ptr = ptr.next;
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof SingleLinkedList)) {
            return false;
        }

        SingleLinkedList otherList = (SingleLinkedList) obj;

        if (this.size != otherList.size) {
            return false;
        }
        ListNode n1 = head.next;
        ListNode n2 = otherList.head.next;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return (n1 == null && n2 == null);
    }

    public int getSize() {
        return size;
    }
}
