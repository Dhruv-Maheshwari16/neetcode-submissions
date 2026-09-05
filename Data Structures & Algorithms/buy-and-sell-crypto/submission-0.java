class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int min_buy = prices[0];
        for(int i = 1; i < prices.length;i++) {
            int sell = prices[i];
            max_profit = Math.max(max_profit,sell - min_buy);
            min_buy = Math.min(min_buy,sell);
        }
        return max_profit;
    }
}
