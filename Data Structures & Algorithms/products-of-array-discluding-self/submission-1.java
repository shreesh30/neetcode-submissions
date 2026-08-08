class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        Time, Space Complexity = O(n)

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
        */

        /*Since we dont need to maintain left and right array
        separately, we can just use result array to store the products
        of left and right array together*/

        int n = nums.length;
        int[] result=new int[n];
        Arrays.fill(result, 1);

        int leftProd=1;
        for(int i=0;i<n;i++){
            result[i]=result[i]*leftProd;
            leftProd=leftProd*nums[i];
        }

        int rightProd=1;
        for(int i=n-1;i>=0;i--){
            result[i]=result[i]*rightProd;
            rightProd=rightProd*nums[i];
        }

    return result;
    }
}  
