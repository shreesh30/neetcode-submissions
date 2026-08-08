class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;


        /*
        int profit=0;

        int buyPrice=prices[0];

        for(int price:prices){
            buyPrice=Math.min(buyPrice,price);
            profit=Math.max(profit, price-buyPrice);
        }

        return profit;
        */

        int left=0,right=1;
        // left=buying point, right=selling point

        int maxProfit=0;

        while(right<n){
            if(prices[left]<prices[right]){
                maxProfit=Math.max(maxProfit, prices[right]-prices[left]);
            }else{
                left=right;
            }
            right++;
        }

        return maxProfit;
    }
}
