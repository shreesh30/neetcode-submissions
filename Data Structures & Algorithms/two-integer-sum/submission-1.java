class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m=new HashMap<>();

        int diff;
        for(int i=0;i<nums.length;i++){
            diff=target-nums[i];

            if(m.containsKey(diff)){
                return new int[]{m.get(diff),i};
            }
            m.put(nums[i],i);
        }
       return null;
    }
}
