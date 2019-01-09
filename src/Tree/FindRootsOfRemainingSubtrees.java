package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindRootsOfRemainingSubtrees {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<TreeNode> find(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) return res;
        if (!shouldDelete(root)) {
            res.add(root);
        }
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (shouldDelete(root) && !shouldDelete(root.left)) {
                res.add(root.left);
                // cancel the connection
            }
            helper(root.left, res);
            if (shouldDelete(root.left)) {
                root.left = null;
            }
        }
        if (root.right != null) {
            if (shouldDelete(root) && !shouldDelete(root.right)) {
                res.add(root.right);
            }
            helper(root.right, res);
            if (shouldDelete(root.right)) {
                root.right = null;
            }
        }
    }

    private boolean shouldDelete(TreeNode node) {
        if ( node.val == 4) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        FindRootsOfRemainingSubtrees here = new FindRootsOfRemainingSubtrees();
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        six.left = two; six.right = four;
        two.left = one; two.right = three;
        four.right = five;
        List<TreeNode> res = here.find(six);
        System.out.println();


    }
}
