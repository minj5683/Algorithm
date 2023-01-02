package LeetCode;

/**
 * [LeetCode] 53. Maximum Subarray
 */

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
        sol.maxSubArray(new int[] {1});
        sol.maxSubArray(new int[] {5,4,-1,7,8});
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int sum = 0;
            int maxSum = nums[0];

            for(int i=0; i<nums.length; i++) {
                sum += nums[i];
                if(maxSum < sum) maxSum = sum;
                if(sum < 0) sum = 0;
            }
            System.out.println(maxSum);
            return maxSum;
        }
    }
}
