package Sort;

import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        combine(array, left, mid, right);
    }

    private void combine(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                temp[index++] = array[i++];
            } else {
                temp[index++] = array[j++];
            }
        }
        if (j > right) {
            while (i <= mid) {
                temp[index++] = array[i++];
            }
        } else {
            while (j <= right) {
                temp[index++] = array[j++];
            }
        }

        // if (i == mid), as the right part already in the locations,
        // so don't need to set them.
        for (int k = left; k <= right; k++) {
            array[k] = temp[k - left];
        }

    }

    public static void main(String[] args) {
        MergeSort here = new MergeSort();
        int[] input = {3,5,1,2,4,8};
        System.out.println(Arrays.toString(here.mergeSort(input)));
    }
}
