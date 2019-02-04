package Tree;

public class DeepCopyBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode copy(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = copy(root.left);
        newRoot.right = copy(root.right);
        return newRoot;
    }

    public static void main(String[] args) {
        DeepCopyBinaryTree here = new DeepCopyBinaryTree();
        //       1
        //     /  \
        //    2   3
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;
        TreeNode root = here.copy(one);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
}
