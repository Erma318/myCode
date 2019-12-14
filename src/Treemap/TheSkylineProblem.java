package Treemap;

import java.util.*;

public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], building[2]});
            heights.add(new int[]{building[1], -building[2]});
        }
        Collections.sort(heights, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];//同时间片  降序排列
                }
                return o1[0] - o2[0];//否则按照时间片排序
            }
        });
        List<int[]> result = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        //height   freq
        map.put(0, 1);//for tree map init 因为你第一次上来就要看最大值
        for (int[] height : heights) {
            boolean isStart = height[1] > 0;
            int curH = Math.abs(height[1]);

            if (isStart) {//L
                if (curH > map.firstKey()) {
                    result.add(new int[]{height[0], curH});
                }
                map.put(curH, map.getOrDefault(curH, 0) + 1);

            } else {//R
                Integer count = map.get(curH);
                if (count == 1) {
                    map.remove(curH);
                } else {
                    map.put(curH, count - 1);
                }
                if (curH > map.firstKey()) {
                    result.add(new int[]{height[0], map.firstKey()});
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TheSkylineProblem cr = new TheSkylineProblem();
        int[][] buildings = new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        for (int[] x : cr.getSkyline(buildings)) {
            for (int y : x) {
                System.out.print(y);
                System.out.println();
            }
        }
    }
}
