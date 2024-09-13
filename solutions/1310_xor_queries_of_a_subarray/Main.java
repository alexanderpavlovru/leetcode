/**
 * 1310. XOR Queries of a Subarray
 *
 * https://leetcode.com/problems/xor-queries-of-a-subarray
 */

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        final int[] result = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int sum = 0;
            for (int i = queries[q][0]; i <= queries[q][1]; i++) {
                sum = sum ^ arr[i];
            }
            result[q] = sum;
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int[] arr = new int[]{1, 3, 4, 8};
        final int[][] queries = new int[][] {
                {0, 1},
                {1, 2},
                {0, 3},
                {3, 3}
        };
        final int[] result = solution.xorQueries(arr, queries);

        for (int n : result) {
            System.out.println(n);
        }
    }
}