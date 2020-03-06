package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallestInUnsortedArray {
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer num1, Integer num2) {
                if (num1.equals(num2)) {
                    return 0;
                }
                return num1 > num2 ? -1 : 1;
            }
        });
        int i = 0;
        for ( ; i < k; i++) {
            maxHeap.add(array[i]);
        }
        for ( ; i < array.length; i++) {
            if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(array[i]);
            }
        }
        int[] res = new int[k];
        for (int j = 1; j <= k; j++) {
            res[k - j] = maxHeap.poll();
        }
        return res;

    }

    public static void main(String[] args) {
        int[] array = {10, 11};
        int k = 2;
        KSmallestInUnsortedArray here = new KSmallestInUnsortedArray();
        System.out.println(Arrays.toString(here.kSmallest(array, k)));
    }
}
