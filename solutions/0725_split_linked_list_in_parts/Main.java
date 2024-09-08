/**
 * 725. Split Linked List in Parts.
 *
 * https://leetcode.com/problems/split-linked-list-in-parts
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        final ListNode[] result = new ListNode[k];
        int size = 0;

        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        curr = head;

        final int partSize = size / k;
        int remainingParts = size % k;

        for (int i = 0; i < k; i++) {
            final ListNode part = new ListNode(0);
            ListNode tail = part;

            int currSize = partSize;
            if (remainingParts > 0) {
                remainingParts--;
                currSize++;
            }

            int j = 0;
            while (j < currSize) {
                tail.next = new ListNode(curr.val);
                tail = tail.next;
                j++;
                curr = curr.next;
            }
            result[i] = part.next;
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        final int k = 5;
        final ListNode[] result = solution.splitListToParts(head, k);

        for (ListNode node : result) {
            while (node != null) {
                System.out.println(node.val);
                node = node.next;
            }
        }
    }
}