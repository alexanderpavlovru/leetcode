import java.util.*;

/**
 * 2028. Finding missing observation.
 *
 * I couldn't solve it without reading solution, unfortunatelly.
 *
 * https://leetcode.com/problems/find-missing-observations
 */
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        final int[] result = new int[n];

        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }

        final int remainingSum = mean * (n + rolls.length) - sum;
        if (remainingSum > 6 * n || remainingSum < n) {
            return new int[0];
        }

        final int distributeMean = remainingSum / n;
        final int mod = remainingSum % n;

        Arrays.fill(result, distributeMean);
        for (int i = 0; i < mod; i++) {
            result[i]++;
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int[] rolls = new int[]{3, 2, 4, 3};
        final int mean = 4;
        final int n = 2;
        final int[] result = solution.missingRolls(rolls, mean, n);
        System.out.println(Arrays.toString(result));
    }
}