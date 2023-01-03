package LeetCode;

/**
 * [LeetCode] 152. Maximum Product Subarray
 */

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxProduct(new int[] {2,3,-2,4});
        sol.maxProduct(new int[] {-2,0,-1});
        sol.maxProduct(new int[] {-3,-1,-1});
        sol.maxProduct(new int[] {0,2});
        sol.maxProduct(new int[] {3,-1,4});
        sol.maxProduct(new int[] {-1,0,-2});
    }

    static class Solution {
        public int maxProduct(int[] nums) {
            int leftProd = 1, rightProd = 1;
            int answer = nums[0];

            for(int i=0; i<nums.length; i++) {
                leftProd = (leftProd == 0) ? 1 : leftProd;
                rightProd = (rightProd == 0) ? 1 : rightProd;

                leftProd *= nums[i];
                rightProd *= nums[nums.length - i - 1];

                answer = Math.max(answer, Math.max(leftProd, rightProd));
            }

            System.out.println(answer);
            return answer;

            /*
            int max = nums[0], min = nums[0], answer = nums[0];

            for(int i=1; i<nums.length; i++) {
                if(nums[i] < 0) {
                    int temp = max;
                    max = min;
                    min = temp;
                }
                max = Math.max(nums[i], max*nums[i]);
                min = Math.min(nums[i], min*nums[i]);

                answer = Math.max(answer, max);
            }

            System.out.println(answer);
            return answer;
            */
        }
    }
}
