package LeetCode;

import java.util.Arrays;

/**
 * [LeetCode] 238. Product of Array Except Self
 */

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.productExceptSelf(new int[] {1,2,3,4});
        sol.productExceptSelf(new int[] {-1,1,0,-3,3});
    }

    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] answer = new int[nums.length];
            int[] prefix = new int[nums.length];
            int[] suffix = new int[nums.length];
            int preProd = 1;
            int sufProd = 1;

            for(int i=0; i<nums.length-1; i++) {
                preProd *= nums[i];
                prefix[i+1] = preProd;
                sufProd *= nums[nums.length - i - 1];
                suffix[nums.length - i - 2] = sufProd;
            }
            prefix[0] = 1;
            suffix[nums.length-1] = 1;

            for(int i=0; i<nums.length; i++) {
               answer[i] = prefix[i] * suffix[i];
            }

            System.out.println(Arrays.toString(answer));
            return answer;
        }
    }
}
