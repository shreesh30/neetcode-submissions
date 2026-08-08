class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;

        if(n==0) return 0;

        Set<Integer> set=new HashSet<>();
        
        for(int num:nums){
            set.add(num);
        }

        int maxCount=Integer.MIN_VALUE;

        for(int num:nums){
            int count=1;
            int x=num+1;
            while(set.contains(x)){
                count++;
                x=x+1;
            }

            maxCount=Math.max(count,maxCount);
        }

        return maxCount;
    }
}
