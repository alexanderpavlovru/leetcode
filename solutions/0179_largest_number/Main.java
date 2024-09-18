import java.util.*;

/**
 * 179. Largest Number.
 *
 * https://leetcode.com/problems/largest-number/
 */

class Solution {
    public String largestNumber(int[] nums) {
        final String[] numStrings = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(numStrings, (a, b) -> (b + a).compareTo(a + b));

        if (numStrings[0].startsWith("0")) {
            return "0";
        }

        final StringBuilder sb = new StringBuilder();
        for (String s : numStrings) {
            sb.append(s);
        }

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int[] nums = new int[] {10, 2};
        final String result = solution.largestNumber(nums);
        System.out.println(result);
    }
}