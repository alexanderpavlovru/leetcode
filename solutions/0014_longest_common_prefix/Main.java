import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        final String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            final char c = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || c != strs[j].charAt(i)) {
                    return first.substring(0, i);
                }
            }
        }

        return first;
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final String result = solution.longestCommonPrefix(new String[] {"flower", "flower"});
        System.out.println(result);
    }
}