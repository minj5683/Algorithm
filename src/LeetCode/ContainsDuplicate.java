package LeetCode;

import java.util.*;

/**
 * [LeetCode] 217. Contains Duplicate
 */

public class ContainsDuplicate {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.containsDuplicate(new int[] {1,2,3,1});
        sol.containsDuplicate(new int[] {1,2,3,4});
        sol.containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2});
    }

    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for(int n : nums) {
                set.add(n);
            }

            return set.size() != nums.length;
        }
    }
}
