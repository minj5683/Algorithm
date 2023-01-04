package LeetCode;

/**
 * [LeetCode] 11. Container With Most Water
 */

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxArea(new int[] {1,8,6,2,5,4,8,3,7});
        sol.maxArea(new int[] {1,1});
    }

    static class Solution {
        public int maxArea(int[] height) {
            int maxArea = Integer.MIN_VALUE;
            int left = 0;
            int right = height.length - 1;

            while(left < right) {
                int width = right - left;
                int area = width * Math.min(height[left], height[right]);
                maxArea = Math.max(area, maxArea);

                if(height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }

            /*
            for(int i=0; i<height.length - 1; i++) {
                for(int j=i + 1; j<height.length; j++) {
                    int area = (j - i) * Math.min(height[i], height[j]);
                    maxArea = Math.max(area, maxArea);
                }
            }
            */

            System.out.println(maxArea);
            return maxArea;
        }
    }
}
