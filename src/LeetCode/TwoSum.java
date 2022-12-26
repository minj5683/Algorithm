package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * [LeetCode] 1. Two Sum
 */

public class TwoSum {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {2,7,11,15};
        sol.twoSum(nums, 9);

        int[] nums2 = {3,2,4};
        sol.twoSum(nums2, 6);

        int[] nums3 = {3,3};
        sol.twoSum(nums3, 6);
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<nums.length; i++) {
                if(map.containsKey(target - nums[i])) {
                    return new int[] { map.get(target - nums[i]), i };
                } else {
                    map.put(nums[i], i);
                }
            }
            return null;
        }
    }
}
