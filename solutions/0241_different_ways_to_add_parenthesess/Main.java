import java.util.*;
/**
 * 241. Different Ways to Add Parenthesess.
 *
 * https://leetcode.com/problems/different-ways-to-add-parentheses
 */

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        final int n = expression.length();

        // Двумерный массив списков, чтобы хранить результаты всех возможных выражений.
        // Каждый элемент dp[i][j] - это список всех возможных значений, которые можно получить
        // для подстроки expression[i][j]
        final List<Integer>[][] dp = new ArrayList[n][n];

        initializeBaseCases(expression, dp);

        for (int length = 3; length <= n; length++) {
            for (int start = 0; start + length - 1 < n; start++) {
                final int end = start + length - 1;
                processSubexpression(expression, dp, start, end);
            }
        }

        return dp[0][n - 1];
    }

    private void initializeBaseCases(String expression, List<Integer>[][] dp) {
        final int n = expression.length();

        // сначала заполняем dp пустыми списками
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < n; i++) {
            if (Character.isDigit(expression.charAt(i))) {
                final int digit1 = expression.charAt(i) - '0';
                if (i + 1 < n && Character.isDigit(expression.charAt(i + 1))) {
                    final int digit2 = expression.charAt(i + 1) - '0';
                    final int num = digit1 * 10 + digit2;
                    dp[i][i + 1].add(num);
                }
                dp[i][i].add(digit1);
            }
        }
    }

    private void processSubexpression(String expression, List<Integer>[][] dp, int start, int end) {
        for (int split = start; split <= end; split++) {
            if (Character.isDigit(expression.charAt(split))) continue;
            final List<Integer> leftResult = dp[start][split - 1];
            final List<Integer> rightResult = dp[split + 1][end];

            computeResults(expression.charAt(split), leftResult, rightResult, dp[start][end]);
        }
    }

    private void computeResults(char op, List<Integer> leftResult, List<Integer> rightResult, List<Integer> results) {
        for (int leftVal : leftResult) {
            for (int rightVal : rightResult) {
                switch (op) {
                    case '+' -> results.add(leftVal + rightVal);
                    case '-' -> results.add(leftVal - rightVal);
                    case '*' -> results.add(leftVal * rightVal);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final String expression = "2-1-1";
        final List<Integer> result = solution.diffWaysToCompute(expression);
        System.out.println(result.toString());
    }
}