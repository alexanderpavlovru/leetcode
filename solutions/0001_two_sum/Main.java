import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            final int n = target - nums[i];
            if (map.containsKey(n)) {
                final int idx = map.get(n);
                if (idx != i) {
                    return new int[]{i, idx};
                }
            }
        }
        return new int[]{0};
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        final int[] r = s.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(r));
    }
}