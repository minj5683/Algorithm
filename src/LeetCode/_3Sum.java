package LeetCode;

import java.util.*;

/**
 * [LeetCode] 15. 3Sum
 */

public class _3Sum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.threeSum(new int[] {-1,0,1,2,-1,-4});
        sol.threeSum(new int[] {0,1,1});
        sol.threeSum(new int[] {0,0,0});
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> result = new HashSet<>();

            Arrays.sort(nums);

            for(int i=0; i<nums.length - 2; i++) {
                int j = i+1;
                int k = nums.length - 1;

                while(j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    } else if(sum > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }

            System.out.println(Arrays.toString(result.toArray()));
            return new ArrayList<>(result);
        }
    }
}
