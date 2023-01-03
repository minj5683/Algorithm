package LeetCode;

/**
 * [LeetCode] 33. Search in Rotated Sorted Array
 */

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.search(new int[] {4,5,6,7,0,1,2}, 0));
        System.out.println(sol.search(new int[] {4,5,6,7,0,1,2}, 3));
        System.out.println(sol.search(new int[] {1}, 0));
    }

    static class Solution {
        public int search(int[] nums, int target) {
            int leftIdx = 0;
            int rightIdx = nums.length -1;

            /* binary search */
            while(leftIdx <= rightIdx) {
                int mid = leftIdx + (rightIdx - leftIdx) / 2;

                if(nums[mid] == target) return mid;

                if(nums[mid] >= nums[leftIdx]){
                    /* left half sorted */
                    if(target >= nums[leftIdx] && target < nums[mid])
                        rightIdx = mid-1;
                    else
                        leftIdx = mid+1;
                }
                else{
                    /* right half is sorted */
                    if(target > nums[mid] && target <= nums[rightIdx])
                        leftIdx = mid+1;
                    else
                        rightIdx = mid-1;
                }
            }

            /*
            while(leftIdx <= rightIdx) {
                if(nums[leftIdx] == target) {
                    return leftIdx;
                }
                if(nums[rightIdx] == target) {
                    return rightIdx;
                }
                leftIdx++;
                rightIdx--;
            }
            */

            return -1;
        }
    }
}
