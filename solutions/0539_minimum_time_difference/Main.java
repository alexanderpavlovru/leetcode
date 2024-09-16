import java.util.*;
/**
 * 539. Minimum Time Difference.
 *
 * https://leetcode.com/problems/minimum-time-difference
 */

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int result = Integer.MAX_VALUE;
        final int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            final int h = Integer.parseInt(timePoints.get(i).substring(0, 2));
            final int m = Integer.parseInt(timePoints.get(i).substring(3));
            minutes[i] = h * 60 + m;
        }

        Arrays.sort(minutes);

        for (int i = 1; i < minutes.length - 1; i++) {
            final int diff = minutes[i + 1] - minutes[i];
            result = Math.min(result, diff);
        }

        return Math.min(result, 24 * 60 - minutes[minutes.length - 1] + minutes[0]);
    }
}

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final List<String> timePoints = Arrays.asList("23:59", "00:00");
        final int result = solution.findMinDifference(timePoints);
        System.out.println(result);
    }
}