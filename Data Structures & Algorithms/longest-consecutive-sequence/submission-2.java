class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;

        if(n==0) return 0;

        Set<Integer> set=new HashSet<>();
        
        for(int num:nums){
            set.add(num);
        }

        int maxLength=Integer.MIN_VALUE;

        for(int num:nums){
            if(!set.contains(num-1)){
                int current=num;
                int length=1;

                while(set.contains(current+1)){
                    current+=1;
                    length+=1;
                }
                maxLength=Math.max(length,maxLength);
            }
        }

        return maxLength;
    }
}
