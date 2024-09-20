import java.util.*;

/**
 * 214. Shortest Palindrome.
 *
 * https://leetcode.com/problems/shortest-palindrome
 */

class Solution {
    public String shortestPalindrome(String s) {
        final String reversedString = new StringBuilder(s).reverse().toString();
        final String combinedString = s + "#" + reversedString;
        final int[] prefixTable = buildPrefixTable(combinedString);

        final int palindromeLen = prefixTable[combinedString.length() - 1];
        final StringBuilder suffix = new StringBuilder(s.substring(palindromeLen)).reverse();

        return suffix.append(s).toString();
    }

    private int[] buildPrefixTable(String s) {
        final int[] prefixTable = new int[s.length()];
        int len = 0;  // длина предыдущего совпавшего префикса

        for (int i = 1; i < s.length(); i++) {
            while (len > 0 && s.charAt(i) != s.charAt(len)) {
                len = prefixTable[len - 1];
            }
            if (s.charAt(i) == s.charAt(len)) {
                len++;
            }
            prefixTable[i] = len;
        }

        return prefixTable;
    }
}

public class Main {
    public static void main(String args[]) {
        final Solution solution = new Solution();
        final String s = "abcd";
        final String result = solution.shortestPalindrome(s);
        System.out.println(result);
    }
}