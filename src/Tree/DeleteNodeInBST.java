package Tree;

public class DeleteNodeInBST {
    static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }
    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        }
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }


        TreeNode delete = deleteSmallest(root.right);
        delete.left = root.left;
        delete.right = root.right;
        return delete;
    }

    private TreeNode deleteSmallest(TreeNode cur) {
        TreeNode prev = null;
        while (cur.left != null) {
            prev = cur;
            cur = cur.left;
        }
        prev.left = cur.right;
        return cur;
    }
}