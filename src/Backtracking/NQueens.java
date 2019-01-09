package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(0, res, temp, -1, n);
        return res;
    }
    private void helper(int index, List<List<Integer>> res, List<Integer> temp, int prev, int n) {
        if (index == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (prev == -1 || (i != prev - 1 && i != prev && i != prev + 1)) {
                temp.add(i);
                helper(index + 1, res, temp, i, n);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        NQueens here = new NQueens();
        System.out.println(here.nqueens(4));
    }
}
