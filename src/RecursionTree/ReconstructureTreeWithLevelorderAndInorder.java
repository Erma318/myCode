package RecursionTree;

import java.util.*;

public class ReconstructureTreeWithLevelorderAndInorder {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
        Map<Integer, Integer> inIndex = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inIndex.put(inOrder[i], i);
        }
        List<Integer> levelList = new ArrayList<>();
        for (int x : levelOrder) {
            levelList.add(x);
        }
        return helper(inIndex, levelList);
    }

    private TreeNode helper(Map<Integer, Integer> inIndex, List<Integer> levelList) {
        if (levelList.isEmpty()) return null;
        TreeNode root = new TreeNode(levelList.get(0));
        int rootIndex = inIndex.get(levelList.get(0));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int x : levelList) {
            if (inIndex.get(x) > rootIndex) {
                right.add(x);
            } else if (inIndex.get(x) < rootIndex){
                left.add(x);
            }
        }
        root.left = helper(inIndex, left);
        root.right = helper(inIndex, right);
        return root;
    }

    public static void main(String[] args) {
        ReconstructureTreeWithLevelorderAndInorder here = new ReconstructureTreeWithLevelorderAndInorder();
        int[] inorder = {1,6,5,7,4,10,9};
        int[] levelorder = {4,1,10,5,9,6,7};
        here.reconstruct(inorder, levelorder);
    }
}
