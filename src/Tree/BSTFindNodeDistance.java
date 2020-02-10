package Tree;

public class BSTFindNodeDistance {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public int findDistance(TreeNode root, int one, int two) {
        TreeNode lca = findLCA(root, one, two);
        int dOne = findDepth(lca, one);
        int dTwo = findDepth(lca, two);
        return dOne + dTwo;
    }

    private TreeNode findLCA(TreeNode root, int one, int two) {
        if (root == null || root.val == one || root.val == two) {
            return root;
        }
        TreeNode left = findLCA(root.left, one, two);
        TreeNode right = findLCA(root.right, one, two);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right: left;
    }

    private int findDepth(TreeNode root, int target) {
        return findDepth(root, target, 0);
    }

    private int findDepth(TreeNode root, int target, int depth) {
        if (root == null) {
            return 0;
        }
        if (root.val == target) {
            return depth;
        }
        int depthLeft = findDepth(root.left, target, depth + 1);
        if (depthLeft != 0) {
            return depthLeft;
        }
        return findDepth(root.right, target, depth + 1);
    }

    public static void main(String[] args) {
        //        1
        //     /    \
        //    2     3
        //  /  \   /  \
        // 4   5   6   7
        //        4
        //     /    \
        //    2     6
        //  /  \   /  \
        // 1   3   5   7
        TreeNode one = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(6);
        TreeNode four = new TreeNode(1);
        TreeNode five = new TreeNode(3);
        TreeNode six = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        one.left = two; one.right = three;
        two.left = four; two.right = five;
        three.left = six; three.right = seven;
        BSTFindNodeDistance here = new BSTFindNodeDistance();
        System.out.println(here.findDistance(one, 1, 3));
        int x = 10 ^ 9;
    }
}
