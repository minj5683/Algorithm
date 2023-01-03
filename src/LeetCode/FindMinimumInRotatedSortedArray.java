package LeetCode;

/**
 * [LeetCode] 153. Find Minimum in Rotated Sorted Array
 */

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findMin(new int[] {3,4,5,1,2}));
        System.out.println(sol.findMin(new int[] {4,5,6,7,0,1,2}));
        System.out.println(sol.findMin(new int[] {4}));
    }

    static class Solution {
        public int findMin(int[] nums) {
            int len = nums.length;

            if(len == 1 || nums[0] < nums[len - 1]) return nums[0];

            int left = nums[0];
            int right = nums[len - 1];

            for(int i=1; i<len; i++) {
                if(left > nums[i]) {
                    return nums[i];
                } else {
                    left = nums[i];
                }

                if(right < nums[len - i - 1]) {
                    return right;
                } else {
                    right = nums[len - i - 1];
                }
            }
            return nums[0];
        }
    }
}
