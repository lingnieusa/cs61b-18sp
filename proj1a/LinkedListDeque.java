public class LinkedListDeque<T> {


    private class Node {
        public T item;
        public Node pre;
        public Node next;

        public Node(T i, Node p, Node n) {
            item = i;
            pre = p;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private Node sentinel;
    private int size;

    /**
     * Creates an empty SLList.
     */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }

//    public LinkedListDeque(T x) {
//        this();
//        addFirst(x);
//        sentinel = new Node(null, null,null);
//        sentinel.next = new Node(x, sentinel,sentinel);
//        sentinel.pre=sentinel.next;
//        size = 1;
//    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T front) {
        Node tmp = new Node(front, sentinel, sentinel.next);
        sentinel.next.pre = tmp;
        sentinel.next = tmp;
        size++;
    }

    public int size() {
        return size;
    }

    public void addLast(T middle) {
        Node tmp = new Node(middle, sentinel.pre, sentinel);
        sentinel.pre.next = tmp;
        sentinel.pre = tmp;
        size++;
    }

    public void printDeque() {
        Node p = sentinel.next;
        for (int i = 0; i < size(); i++) {
            System.out.println(p.item);
            p = p.next;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            System.out.println("empty list!!!");
            return null;
        }
        Node second = sentinel.next.next;
        Node first = sentinel.next;
        first.next = null;
        first.pre = null;
        second.pre = sentinel;
        sentinel.next = second;
        size--;
        return first.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            System.out.println("empty list!!!");
            return null;
        }
        Node second = sentinel.pre.pre;
        Node first = sentinel.pre;
        first.next = null;
        first.pre = null;
        second.next = sentinel;
        sentinel.pre = second;
        size--;
        return first.item;
    }

    public T get(int index) {
        if (size() == 0 || index > size()) {
            return null;
        }
        Node ptr = sentinel.next;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    private T getIndex(int index, Node p) {
        if (index == 0) {
            return p.item;
        }
        return getIndex(index - 1, p.next);
    }

    public T getRecursive(int index) {
        if (size() == 0 || index > size()) {
            return null;
        }
        Node ptr = sentinel.next;
        return getIndex(index, ptr);
    }
}
