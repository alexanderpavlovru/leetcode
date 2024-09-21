import java.util.*;

/**
 * 386. Lexicographical Numbers.
 *
 * https://leetcode.com/problems/lexicographical-numbers
 */

class Solution {
    public List<Integer> lexicalOrder(int n) {
        final List<Integer> result = new ArrayList<>();
        int current = 1;

        for (int i = 0; i < n; i++) {
            result.add(current);

            if (current * 10 <= n) {
                current *= 10;
            } else {
                while (current % 10 == 9 || current >= n) {
                    current /= 10;
                }
            }
            current++;
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int n = 13;
        final List<Integer> result = solution.lexicalOrder(n);
        System.out.println(result.toString());
    }
}