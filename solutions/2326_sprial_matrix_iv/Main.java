import java.util.*;

/**
 * 2326. Spiral Matrix IV.
 * <p>
 * https://leetcode.com/problems/spiral-matrix-iv/
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        final int[][] matrix = new int[m][n];
        final int[][] directions = new int[][]{
                {0, 1},  // right
                {1, 0},  // bottom
                {0, -1}, // left
                {-1, 0}  // up
        };

        for (int[] row : matrix) {
            Arrays.fill(row, -1);
        }

        int i = 0;
        int j = 0;
        int currentDirection = 0;
        while (head != null) {
            matrix[i][j] = head.val;

            final int nextI = i + directions[currentDirection][0];
            final int nextJ = j + directions[currentDirection][1];

            if (nextI >= m || nextJ >= n || Math.min(nextI, nextJ) < 0 || matrix[nextI][nextJ] != -1) {
                currentDirection = (currentDirection + 1) % directions.length;
            }

            i = i + directions[currentDirection][0];
            j = j + directions[currentDirection][1];

            head = head.next;
        }

        return matrix;
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int m = 3;
        final int n = 5;
        final ListNode head = new ListNode(3);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        final int[][] result = solution.spiralMatrix(m, n, head);

        for (int[] row : result) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}