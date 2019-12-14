package Tree;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ConvertSortedListtoBinarySearchTree {
    private ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        node = head;
        int size = getSize(head);
        System.out.println(head.val);
        return inorderHelper(0, size - 1);
    }

    private int getSize(ListNode head) {
        head.val = 10;
        int size = 0;
        // 不用新建一个头来移动，外界并不会改变
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    private TreeNode inorderHelper(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = inorderHelper(start, mid - 1);
        TreeNode root = new TreeNode(node.val);
        root.left = left;
        node = node.next;
        TreeNode right = inorderHelper(mid + 1, end);
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(-10);
        ListNode two = new ListNode(-3);
        ListNode three = new ListNode(0);
        ListNode four = new ListNode(5);
        ListNode five = new ListNode(9);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        ConvertSortedListtoBinarySearchTree cr = new ConvertSortedListtoBinarySearchTree();
        cr.sortedListToBST(one);
        while (one  != null) {
            System.out.println(one.val);
            one = one.next;
        }

    }
}
