package RecursionTree;

import java.util.*;

public class BinaryTreePathSumToTargetIII {
    public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
      this.key = key;
    }
    }

    public boolean exist(TreeNode root, int target) {
        if (root == null) return false;
        Set<Integer> prefixSums = new HashSet<>();
        prefixSums.add(0); // important
        return exist(root, prefixSums, 0, target);
    }
    private boolean exist(TreeNode root, Set<Integer> prefixSums, int prefixSum, int target) {

        prefixSum += root.key;
        if (prefixSums.contains(prefixSum - target)) {
            return true;
        }
        boolean needRemove = prefixSums.add(prefixSum);

        if (root.left != null && exist(root.left, prefixSums,  prefixSum, target)) {
            return true;
        }
        if (root.right != null && exist(root.right, prefixSums,  prefixSum, target)) {
            return true;
        }
        if (needRemove) prefixSums.remove(prefixSum);
        return false;
    }
}
