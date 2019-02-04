package DataStructure;

public class Stack {
    int[] array;
    int tail;
    public Stack(int cap) {
        array = new int[cap];
        tail = 0;
    }

    public boolean push(int ele) {
        if (tail == array.length - 1)
            return false;
        array[tail++] = ele;
        return true;
    }

    public Integer pop() {
        if (tail == 0) {
            return null;
        } else {
            return array[--tail];
        }
    }

    public Integer top() {
        if (tail == 0) {
            return null;
        } else {
            return array[tail - 1];
        }
    }

}
