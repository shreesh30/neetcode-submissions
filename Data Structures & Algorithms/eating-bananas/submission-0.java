class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=maximumPile(piles);

        int low=0,high=max;
        int mid;

        while(low<=high){
            mid=(low+high)/2;

            if(isPossible(piles, h, mid)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return low;
    }

    public int maximumPile(int[] piles){
        int max=Integer.MIN_VALUE;

        for(int pile:piles){
            max=Math.max(pile,max);
        }

        return max;
    }

    public boolean isPossible(int[] piles, int h, int speed){
        int timeRequired=0;
        
        for(int pile:piles){
            timeRequired+=Math.ceil((double)(pile)/(double)(speed));
        }

        return timeRequired<=h;
    }
}
