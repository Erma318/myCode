package DataStructure;

public class MyCircularDeque {
    int[] array;
    int head;
    int tail;
    int size;
    int cap;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        array = new int[k];
        head = tail = k / 2;
        size = 0;
        cap = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == cap) return false;
        if (size == 0) {
            array[head] = value;
            head = head - 1== -1 ? cap - 1 : head - 1;
            tail = tail + 1 == cap ? 0 : tail + 1;
        } else {
            array[head] = value;
            head = head - 1== -1 ? cap - 1 : head - 1;
        }
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == cap) return false;
        if (size == 0) {
            array[head] = value;
            head = head - 1== -1 ? cap - 1 : --head;
            tail = tail + 1 == cap ? 0 : tail + 1;
        } else {
            array[tail] = value;
            tail = tail + 1 == cap ? 0 : tail + 1;
        }
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) return false;
        if (size == 1) {
            head = head + 1== cap ? 0 : head + 1;
            tail = tail - 1 == -1 ? cap - 1 : tail - 1;
        } else {
            head = head + 1 == cap ? 0 : head + 1;
        }
        size--;
        return true;

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) return false;
        if (size == 1) {
            head = head + 1 == cap ? 0 : head + 1;
            tail = tail - 1== -1 ? cap - 1 : tail - 1;
        } else {
            tail = tail - 1 == -1 ? cap - 1 : tail - 1;
        }
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        int temp = head;
        temp = temp + 1 == cap? 0 : temp + 1;
        return array[temp];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        int temp = tail;
        temp = temp - 1 == -1 ? cap - 1 : temp - 1;
        return array[temp];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == cap;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // set the size to be 3
        circularDeque.insertLast(1);			// return true
        circularDeque.insertLast(2);			// return true
        circularDeque.insertFront(3);			// return true
        circularDeque.insertFront(4);			// return false, the queue is full
        circularDeque.getRear();  			// return 2
        circularDeque.isFull();				// return true
        circularDeque.deleteLast();			// return true
        circularDeque.insertFront(4);			// return true
        circularDeque.getFront();			// return 4
    }
}
