public class ArrayDeque<Item> implements Deque<Item> {
    private Item[] array;
    private int first = 0;
    private int last = 1;
    private int size = 0;
    private int capacity = 8;

    public ArrayDeque() {
        array = (Item[]) new Object[capacity];
    }
    @Override
    public void addFirst(Item item) {
        array[first] = item;
        first = first - 1 < 0 ? capacity - 1 : first - 1;
        size++;
        if (size == capacity) {
            resize();
        }
    }
    @Override
    public void addLast(Item item) {
//        if (size == 0) {
//            array[first] = item;
//            first = first - 1 < 0 ? capacity - 1 : first - 1;
//        } else {
        array[last] = item;
        last = (last + 1) % capacity;
//        }
        size++;
        if (size == capacity) {
            resize();
        }
    }


    private void copyTo(Item[] b) {
        int bIndex = 0;
        int index = (first + 1) % capacity;
        int tempSize = size;
        while ((tempSize--) > 0) {
            b[bIndex++] = array[index];
            index = (index + 1) % capacity;
        }
    }

    private void resize() {
        Item[] largerArray = (Item[]) new Object[size * 2];
        copyTo(largerArray);
        array = largerArray;
        capacity = size * 2;
        first = capacity - 1;
        last = size;
    }

    private void shrink() {
        Item[] smallerArray = (Item[]) new Object[capacity / 2];
        copyTo(smallerArray);
        array = smallerArray;
        capacity = capacity / 2;
        first = capacity - 1;
        last = size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        if (size == 0) {
            return;
        }
        int index = (first + 1) % capacity;
        int tempSize = size;
        while ((tempSize--) > 1) {
            System.out.print(array[index] + " ");
            index = (index + 1) % capacity;
        }
        System.out.println(array[index]);
    }
    @Override
    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        first = (first + 1) % capacity;
        Item res = array[first];
        array[first] = null;
        if ((size * 1.0 / capacity) < 0.251) {
            shrink();
        }
        return res;
    }
    @Override
    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        last = last - 1 < 0 ? capacity - 1 : last - 1;
        Item res = array[last];
        array[last] = null;
        if ((size * 1.0 / capacity) < 0.251) {
            shrink();
        }
        return res;
    }
    @Override
    public Item get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return array[(first + index + 1) % capacity];
    }

//
//    public static void main(String[] args) {
//        ArrayDeque<Integer> a = new ArrayDeque<>();
//        a.addLast(5);
//        a.addLast(6);
//        a.addLast(7);
//        a.addFirst(4);
//
//        a.addLast(8);
//        a.addLast(9);
//        a.addLast(10);
//        a.addFirst(3);
//        a.addFirst(2);
//        a.addFirst(1);
//
//        a.printDeque();
//
//        a.removeFirst();
//        a.removeLast();
//        a.removeLast();
//        a.removeLast();
//        a.removeLast();
//        a.removeLast();
//        a.printDeque();
//        System.out.println(a.capacity);
//    }
}
