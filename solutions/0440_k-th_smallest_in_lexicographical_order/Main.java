/**
 * 440. K-th Smallest in Lexicographical Order
 *
 * https://leetcode.com/problems/k-th-smallest-in-lexicographical-order
 */

class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while (k > 0) {
            int step = countSteps(n, curr, curr + 1);

            // if steps (numbers between 1 and 2 or 10 and 20) less than k, then move to the next number 1->2
            if (step <= k) {
                curr++;
                k -= step;
            } else { // if steps (numbers) more than k, then k-th is inside the current prefix (for example starts with 1)
                // in this case we go inside this prefix by adding 0 to the current number.
                curr *= 10;
                k--;
            }

            // we repeat this process decreminting k and moving either to the next number or go inside prefix
        }

        return curr;
    }


    // count how many steps between 1 and 2 or 10 and 20.
    private int countSteps(int n, long prefix1, long prefix2) {
        int steps = 0;

        while (prefix1 <= n) {
            steps += Math.min(n + 1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }

        return steps;
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int n = 13;
        final int k = 2;
        final int result = solution.findKthNumber(n, k);
        System.out.println(result);
    }
}