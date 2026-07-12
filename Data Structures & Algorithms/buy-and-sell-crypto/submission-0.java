class Solution {
    public int maxProfit(int[] prices) {
        int buyI = 0;
        int profit = 0;

        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < prices[buyI]) {
                buyI = i;
            } else {
                profit = Math.max(prices[i] - prices[buyI], profit);
            }
        }

        return profit;
    }
}
