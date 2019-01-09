package RecursionTree;

public class ReconstructBSTwithPreOrder {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }
    public TreeNode reconstruct(int[] pre) {
        int[] index = {0};
        return reconstruct(pre, index, Integer.MAX_VALUE);
    }

    private TreeNode reconstruct(int[] pre, int[] index, int max) {
        if (index[0] >= pre.length || pre[index[0]] > max) {
            return null; // mean we hit the leaves;
        }

        TreeNode root = new TreeNode(pre[index[0]++]);
        root.left = reconstruct(pre, index, root.key);
        root.right = reconstruct(pre, index, max);
        return root;
    }

    public static void main(String[] args) {
        ReconstructBSTwithPreOrder here = new ReconstructBSTwithPreOrder();
        int[] pre = {10, 5, 2, 7, 15, 12, 20};
        TreeNode root = here.reconstruct(pre);
        here.inorder(root);

    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.key + ", ");
        inorder(root.right);
    }

}
