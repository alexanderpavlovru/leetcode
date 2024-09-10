/**
 * 2807. Insert Greatest Common Divisors in Linked List
 *
 * https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode node = head;
        while (node.next != null) {
            final int gcd = findGcd(node.val, node.next.val);
            final ListNode next = node.next;
            final ListNode gcdNode = new ListNode(gcd);
            node.next = gcdNode;
            gcdNode.next = next;
            node = next;
        }
        return head;
    }

    private int findGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);
        final ListNode result = solution.insertGreatestCommonDivisors(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}