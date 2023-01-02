package LeetCode;

/**
 * [LeetCode] 121. Best Time to Buy and Sell Stock
 */

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxProfit(new int[] {7,1,5,3,6,4});
        sol.maxProfit(new int[] {7,6,4,3,1});
        sol.maxProfit(new int[] {7,3,8,2,5});
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;

            for(int i=0; i<prices.length; i++) {
                if(prices[i] < minPrice) {
                    minPrice = prices[i];
                } else if(prices[i] - minPrice > maxProfit) {
                    maxProfit = prices[i] - minPrice;
                }
            }
            return maxProfit;

            /*
            int maxProfit = 0;
            for(int i=0; i<prices.length-1; i++) {
                for(int j=i+1; j<prices.length; j++) {
                    int profit = prices[j] - prices[i];
                    if(maxProfit < profit)
                        maxProfit = profit;
                }
            }
            return maxProfit;
            */
        }
    }
}

