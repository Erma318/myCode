package Baffle;

import java.util.Arrays;

public class KSmallestInUnsortedArray {
    public int[] kSmallest(int[] array, int k) {
        if (k == 0) return new int[0];
        int index = kSmallest(array, k, 0, array.length - 1);
        int[] res = new int[index + 1];
        for (int i = 0; i <= index; i++) {
            res[i] = array[i];
        }
        Arrays.sort(res);
        return res;
    }

    private int kSmallest(int[] array, int k, int left, int right) {
        int pivot = getPivot(left, right);
        swap(array, right, pivot);
        int i = left; int j = right - 1;
        while (i <= j) {
            if (array[i] < array[right]) {
                i++;
            } else if (array[j] > array[right]) {
                j--;
            } else {
                swap(array, i++, j--);
            }
        }
        swap(array, i, right);
        if (i + 1 == k) {
            return i;
        } else if (i + 1 > k) {
            return kSmallest(array, k, left, i);
        } else {
            return kSmallest(array, k, i + 1, right);
        }
    }

    private int getPivot(int left, int right) {
        return (int) (Math.random() * (right - left + 1)) + left;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        KSmallestInUnsortedArray here = new KSmallestInUnsortedArray();
        int[] array = {1};
        System.out.println(Arrays.toString(here.kSmallest(array, 1)));

    }
}
