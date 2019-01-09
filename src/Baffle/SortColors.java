package Baffle;

import java.util.Arrays;

public class SortColors {
    public int[] rainbowSort(int[] array) {
        if (array.length == 0) return array;
        int red = 0;
        int green = 0;
        int blue = array.length - 1;

        while (green <= blue) { // pay attention to the stop condition
            if (array[green] == -1) {
                swap(array, red++, green++);
            } else if (array[green] == 0) {
                green++;
            } else {
                swap(array, blue--, green);
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
// -1,1,1,1,0,0,-1
//  r
//  g
//               b
    public static void main(String[] args) {
        SortColors here = new SortColors();
        int[] input = {-1,1,1,1,0,0,-1};
        System.out.println(Arrays.toString(here.rainbowSort(input)));
    }
}
