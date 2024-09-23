import java.util.*;

/**
 * 2707. Extra Characters in a String.
 *
 * https://leetcode.com/problems/extra-characters-in-a-string/
 */

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        final int n = s.length();
        final int[] dp = new int[n + 1];
        final Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));

        for (int start = n - 1; start >= 0; start--) {
            dp[start] = dp[start + 1] + 1; // increments extra char counter for current pos by default
            System.out.println("dp = " + Arrays.toString(dp));
            for (int end = start; end < n; end++) {
                final String curr = s.substring(start, end + 1);
                System.out.println(curr);
                if (dictionarySet.contains(curr)) {
                    dp[start] = Math.min(dp[start], dp[end + 1]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final String s = "leetscode";
        final String[] dictionary = new String[] {"leet", "code", "leetcode"};
        final int result = solution.minExtraChar(s, dictionary);
        System.out.println(result);
    }
}