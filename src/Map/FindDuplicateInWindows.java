package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateInWindows {
    public List<int[]> find(int[] input, int w) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> res= new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(input[i])) {
                if ((i - map.get(input[i]) + 1) <= w) {
                    res.add(new int[]{input[i], map.get(input[i])});
                }
            }
            map.put(input[i], i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] input = {2,3,2,3,2};
        FindDuplicateInWindows here = new FindDuplicateInWindows();
        List<int[]> res = here.find(input, 3);
        for (int[] x : res) {
            System.out.print(x[0] + ",");
            System.out.print(x[1] + "\n");
        }

    }
}
