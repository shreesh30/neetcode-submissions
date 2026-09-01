class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;

        int low=0, high=n-1;
        int mid;

        int result= Integer.MAX_VALUE;

        while(low<=high){
            mid=(low+high)/2;
            if(nums[low]<=nums[high]){
		        result=Math.min(result,nums[low]);
		        break;
            }

            if(nums[low]<=nums[mid]){
                result=Math.min(result,nums[low]);
                low=mid+1;
            }else{
                result=Math.min(result, nums[mid]);
                high=mid-1;
            }
        }

        return result;
    }
}
