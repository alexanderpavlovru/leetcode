import java.util.*;
/**
 * 3217. Delete Nodes From Linked List Present in Array.
 *
 * https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array
 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        final Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

         while (head != null && set.contains(head.val)) {
             head = head.next;
         }

         if (head == null) {
             return null;
         }

         ListNode curr = head;
         while (curr.next != null) {
             if (set.contains(curr.next.val)) {
                 curr.next = curr.next.next;
             } else {
                curr = curr.next;
             }
         }

        return head;
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final ListNode head = new ListNode(3);
        head.next = new ListNode(7);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(1);
        final int[] nums = new int[]{1, 7, 6, 2, 4};
        ListNode result = solution.modifiedList(nums, head);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}