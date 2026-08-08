class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;

        int[] result =new int[n];

        int[] left=new int[n];
        Arrays.fill(left,1);

        int leftProd=1;
        for(int i=0;i<n;i++){
            left[i]=leftProd*left[i];
            leftProd*=nums[i];
        }

        int[] right=new int[n];
        Arrays.fill(right, 1);

        int rightProd=1;
        for(int i=n-1;i>=0;i--){
            right[i]=rightProd*right[i];
            rightProd=rightProd*nums[i];
        }

        for(int i=0;i<n;i++){
            result[i]=left[i]*right[i];
        }

        return result;
    }
}  
