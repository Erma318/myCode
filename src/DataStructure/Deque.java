package DataStructure;

public class Deque {
    int cap;
    int[] array;
    int head;
    int tail;
    int size = 0;
    public Deque(int cap) {
        array = new int[cap];
        head = tail = cap / 2;
    }
    // head and tail mark the point we will put the number

    public boolean offerFirst(int ele) {
        if (size == cap) return false;
        if (size == 0) {
            array[head] = ele;
            head = --head == -1 ? cap - 1 : --head;
            tail = ++tail == cap ? 0 : ++tail;
            return true;
        }
        array[head] = ele;
        head = --head == -1 ? cap - 1 : --head;
        size++;
        return true;
    }

    public boolean offerLast(int ele) {
        if (size == cap) return false;
        array[tail] = ele;
        tail = ++tail == cap ? 0 : ++tail;
        size++;
        return true;
    }

    public Integer pollFirst(int ele) {
        if (size == 0) return null;
        int res = array[head];
        head = ++head == cap ? 0 : ++head;
        size--;
        return res;
    }

    public Integer pollLast(int ele) {
        return 0;
    }

    public int peekFirst() {
        return 0;
    }

    public int peekLast() {
        return 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
