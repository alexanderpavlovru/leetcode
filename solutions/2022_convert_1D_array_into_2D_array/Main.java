import java.util.*;

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }

        final int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[i * n + j];
            }
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int[] original = new int[]{5, 4};
        final int m = 1;
        final int n = 2;
        final int[][] result = solution.construct2DArray(original, m, n);
        System.out.println(Arrays.deepToString(result));
    }
}