/**
 * 1684. Count the Number of Consistent Strings.
 *
 * https://leetcode.com/problems/count-the-number-of-consistent-strings
 */

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int num = 0;

        final Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            set.put(c);
        }

        for (String word : words) {
            num++;
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    num--;
                    break;
                }
            }
        }

        return num;
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final String allowed = "ab";
        final String[] words = new String[] {"ab", "ad", "aaab", "baa", "badab"};
        final int result = solution.countConsistentStrings(allowed, words);
        System.out.println(result);
    }
}