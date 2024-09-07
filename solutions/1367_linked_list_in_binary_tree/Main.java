import java.util.*;

/**
 * 1367. Linked List in Binary Tree.
 *
 * https://leetcode.com/problems/linked-list-in-binary-tree
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isPath(ListNode head, TreeNode tree) {
        final Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(tree);

        while (!stack.isEmpty()) {
            final TreeNode node = stack.pop();

            if (isMatch(node, head)) {
                return true;
            }

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return false;
    }

    private boolean isMatch(TreeNode treeNode, ListNode listNode) {
        final Deque<Map.Entry<TreeNode, ListNode>> stack = new ArrayDeque<>();
        stack.push(new HashMap.SimpleEntry<>(treeNode, listNode));

        while (!stack.isEmpty()) {
            final Map.Entry<TreeNode, ListNode> entry = stack.pop();
            TreeNode currTreeNode = entry.getKey();
            ListNode currListNode = entry.getValue();

            while (currTreeNode != null && currListNode != null) {
                if (currTreeNode.val != currListNode.val) {
                    break;
                }
                currListNode = currListNode.next;

                if (currListNode != null) {
                    if (currTreeNode.right != null) {
                        stack.push(new HashMap.SimpleEntry<TreeNode, ListNode>(currTreeNode.right, currListNode));
                    }
                    if (currTreeNode.left != null) {
                        stack.push(new HashMap.SimpleEntry<TreeNode, ListNode>(currTreeNode.left, currListNode));
                    }
                    break; //?
                }
            }
            if (currListNode == null) {
                return true;
            }
        }

        return false;
    }
}

public class Main {
    private static ListNode head;
    private static TreeNode path;

    public static void main(String[] args) {
        final Solution solution = new Solution();
        test1();
        final boolean result = solution.isPath(head, path);
        System.out.println(result);
    }

    private static void test1() {
        head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);
        path = new TreeNode(1);
        path.left = new TreeNode(4);
        path.left.right = new TreeNode(2);
        path.left.right.left = new TreeNode(1);
        path.right = new TreeNode(4);
        path.right.left = new TreeNode(2);
        path.right.left.left = new TreeNode(6);
        path.right.left.right = new TreeNode(8);
        path.right.left.right.left = new TreeNode(1);
        path.right.left.right.right = new TreeNode(3);
    }
}
