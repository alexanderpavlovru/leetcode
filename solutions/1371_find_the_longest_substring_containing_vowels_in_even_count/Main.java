/**
 * 1371. Find The Longest Substring Containing Vowels in Even Order.
 *
 * https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts
 */

class Solution {
    public int findTheLongestSubstring(String s) {
        int size = 0;
        int prefixXOR = 0;
        final int[] characterMap = new int[26];
        final int[] mp = new int[32];

        characterMap['a' - 'a'] = 1;
        characterMap['e' - 'a'] = 2;
        characterMap['i' - 'a'] = 4;
        characterMap['o' - 'a'] = 8;
        characterMap['u' - 'a'] = 16;

        for (int i = 0; i < mp.length; i++) {
            mp[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            prefixXOR = prefixXOR ^ characterMap[s.charAt(i) - 'a'];
            if (mp[prefixXOR] == -1 && prefixXOR != 0) {
                mp[prefixXOR] = i;
            }
            size = Math.max(size, i - mp[prefixXOR]);
        }

        return size;
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final String s = "eleetminicoworoep";
        final int result = solution.findTheLongestSubstring(s);
        System.out.println(result);
    }
}