package Stack;

import java.util.LinkedList;

public class DequeWithThreeStack {
    LinkedList<Integer> left;
    LinkedList<Integer> right;
    LinkedList<Integer> buffer;

    public DequeWithThreeStack() {
        left = new LinkedList<>();
        right = new LinkedList<>();
        buffer = new LinkedList<>();
    }

    public void offerFirst(int element) {
        left.offerFirst(element);
    }

    public void offerLast(int element) {
        right.offerFirst(element);
    }

    private void balance(LinkedList<Integer> left, LinkedList<Integer> right) {
        if (left.isEmpty()) {
            int size = right.size() / 2;
            for (int i = 0; i < size; i++) {
                buffer.offerFirst(right.pollFirst());
            }
            while (!right.isEmpty()) {
                left.offerFirst(right.pollFirst());
            }
            while (!buffer.isEmpty()) {
                right.offerFirst(buffer.pollFirst());
            }
        }
    }

    public Integer pollFirst() {
        balance(left, right);
        return left.pollFirst();
    }

    public Integer pollLast() {
        balance(right, left);
        return right.pollFirst();
    }

    public Integer peekFirst() {
        balance(left, right);
        return left.peekFirst();
    }

    public Integer peekLast() {
        balance(right, left);
        return right.peekFirst();
    }

    public int size() {
        return left.size() + right.size();
    }

    public boolean isEmpty() {
        return left.isEmpty() && right.isEmpty();
    }

    public static void main(String[] args) {
        DequeWithThreeStack here = new DequeWithThreeStack();
        here.peekFirst();
        here.offerLast(74);
        System.out.println(here.peekFirst());
    }
}
