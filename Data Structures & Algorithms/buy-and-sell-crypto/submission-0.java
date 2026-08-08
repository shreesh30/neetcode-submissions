class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;

        int profit=0;

        int buyPrice=Integer.MAX_VALUE;
        for(int price:prices){
            buyPrice=Math.min(buyPrice,price);
            profit=Math.max(profit, price-buyPrice);
        }

        return profit;
    }
}
