/**
 * 2419. Longest Subarray With Maximum Bitwise AND.
 *
 * If both bits in bitwise AND are 1 then result is 1, else result is 0.
 * Bitwise AND operations with a larger number and a smaller number will always result with a number less or equal to
 * the smallest number.
 * Therefore the maximum possible bitwise AND of a subarray can only be achieved when all the numbers in the subarray
 * are equal to the maximum number in the array.
 *
 * Time complexity O(n)
 * Space complexity O(1)
 *
 * https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and
 */

class Solution {
    public int longestSubarray(int[] nums) {
        int result = 0; // len of a subarray with highest bitwise AND value
        int maxVal = 0;
        int streak = 0;

        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
                result = 0;
                streak = 0;
            } else if (num == maxVal) {
                streak++;
            } else {
                streak = 0;
            }
            result = Math.max(result, streak);
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int[] nums = new int[]{1, 3};
        final int result = solution.longestSubarray(nums);
        System.out.println(result);
        System.out.println(1 & 5);
    }
}