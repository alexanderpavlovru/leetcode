import java.util.*;
import java.util.stream.*;

/**
 * 884. Uncommon Words from Two Sentences.
 *
 * https://leetcode.com/problems/uncommon-words-from-two-sentences
 */

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        final Map<String, Integer> wordsCounts = new HashMap<>();
        final String[] arr = (s1 + " " + s2).split(" ");

        for (String s : arr) {
            wordsCounts.merge(s, 1, (v1, v2) -> v1 + v2);
        }

        return wordsCounts.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .toArray(String[]::new);
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final String s1 = "this apple is sweet";
        final String s2 = "this apple is sour";
        final String[] result = solution.uncommonFromSentences(s1, s2);

        for (String s : result) {
            System.out.println(s);
        }
    }
}