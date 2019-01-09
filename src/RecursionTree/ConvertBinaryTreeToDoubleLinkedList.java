package RecursionTree;

import sun.reflect.generics.tree.Tree;

public class ConvertBinaryTreeToDoubleLinkedList {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }


    static TreeNode prev = null;
    static TreeNode head = null;
    public void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        convert(root.left);
        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        convert(root.right);
    }

    public static void main(String[] args) {
        ConvertBinaryTreeToDoubleLinkedList here = new ConvertBinaryTreeToDoubleLinkedList();
        //        1
        //     /    \
        //    2     3
        //  /  \   /  \
        // 4   5   6   7
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        one.left = two; one.right = three;
        two.left = four; two.right = five;
        three.left = six; three.right = seven;
        here.convert(one);
        while (head!= null) {
            System.out.print(head.val + ", ");
            head = head.right;
        }
    }

}
