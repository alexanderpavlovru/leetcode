class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int i = 0;
        int len = chalk.length;

        while (k > 0) {
            k = k - chalk[i];
            if (k < 0) {
                return i;
            }
            i++;
            if (i == len) {
                i = 0;
            }
        }

        return i;
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int[] chalk = new int[]{3, 4, 1, 2};
        final int k = 25;
        final int result = solution.chalkReplacer(chalk, k);
        System.out.println(result);
    }
}