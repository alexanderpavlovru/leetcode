/**
 * 1945. Sum of Digits of String After Convert
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 *
 * https://leetcode.com/problems/sum-of-digits-of-string-after-convert
 */
class Solution {
    public int getLucky(String s, int k) {
        String numbers = convert(s);

        while (k > 0) {
            numbers = transform(numbers);
            k--;
        }

        return Integer.parseInt(numbers);
    }

    private String convert(String s) {
        final StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int n = c - 'a' + 1;
            if (n > 9) {
                final int remain = n % 10;
                n /= 10;
                sb.append(n);
                sb.append(remain);
            } else {
                sb.append(n);
            }
        }
        return sb.toString();
    }

    private String transform(String numbers) {
        int sum = 0;
        for (char c : numbers.toCharArray()) {
            final long n = c - '0';
            sum += n;
        }

        return String.valueOf(sum);
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final String s = "hvmhoasabaymnmsd";
        final int k = 1;
        final int result = solution.getLucky(s, k);
        System.out.println(result);
    }
}