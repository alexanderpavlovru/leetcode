/**
 * 2220. Minumum Bit Flips to Convert Number.
 *
 * https://leetcode.com/problems/minimum-bit-flips-to-convert-numbe
 */

class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        while (start > 0 || goal > 0) {
            if ((start & 1) != (goal & 1)) {
                count++;
            }
            start >>= 1;
            goal >>= 1;
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int start = 10;
        final int goal = 7;
        final int result = solution.minBitFlips(start, goal);
        System.out.println(result);
    }
}