package Stack;

import java.util.LinkedList;

public class SortWithTwoStacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        while (!s1.isEmpty()) {
            int local_min = Integer.MAX_VALUE;
            int count = 0;
            while (!s1.isEmpty()) {
                int temp = s1.pollFirst();
                if (temp < local_min) {
                    local_min = temp;
                    count = 1;
                } else if (temp == local_min) {
                    count++;
                }
                s2.offerFirst(temp);
            }
            while (!s2.isEmpty() && s2.peekFirst() >= local_min) {
                int temp = s2.pollFirst();
                if (temp != local_min) {
                    s1.offerFirst(temp);
                }
            }
            for (int i = 0; i < count; i++) {
                s2.offerFirst(local_min);
            }
        }

        while (!s2.isEmpty()) {
            s1.offerFirst(s2.pollFirst());
        }

    }

    public static void main(String[] args) {
        LinkedList s1 = new LinkedList();
        s1.offerFirst(2);
        s1.offerFirst(3);
        s1.offerFirst(1);
        s1.offerFirst(1);
        s1.offerFirst(2);
        s1.offerFirst(4);
        SortWithTwoStacks test = new SortWithTwoStacks();
        test.sort(s1);
        while (!s1.isEmpty()) {
            System.out.print(s1.pollFirst());
            System.out.print(", ");
        }


    }
}
