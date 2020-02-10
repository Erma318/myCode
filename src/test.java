import java.util.*;

public class test {
    public int[] largestSum(int[] array) {
        // Write your solution here
        int[] res = {array[0], 0, 0};
        int[] cur = {array[0], 0, 0};
        for (int i = 1; i < array.length; i++) {
            if (cur[0] < 0) {
                cur[0] = array[i];
                cur[1] = i;
            } else {
                cur[0] = array[i] + cur[0];
            }
            cur[2] = i;
            if (res[0] < cur[0]) {
                res[0] = cur[0];
                res[1] = cur[1];
                res[2] = cur[2];
            }
        }
        return res;
    }
}
