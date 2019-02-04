package DFS;

import java.util.ArrayList;
import java.util.List;

public class Coins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(res, temp, coins, 0, target);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> temp, int[] coins, int index, int target) {
        if (index == coins.length) {
            if (target == 0) {
                res.add(new ArrayList<Integer>(temp));
            }
            return;
        }

        for (int i = 0; i <= target / coins[index]; i++) {
            temp.add(i);
            helper(res, temp, coins, index + 1, target - coins[index] * i);
            temp.remove(temp.size() - 1);
        }

    }

    public static void main(String[] args) {
        Coins here = new Coins();
        int target = 99;
        int[] coins = {1,5, 10, 25};
        System.out.println(here.combinations(target, coins));
    }
}
