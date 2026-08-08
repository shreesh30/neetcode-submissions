class Solution {
    public int trap(int[] height) {
        int n=height.length;

        /* BRUTE FORCE:
        TIME COMPLEXITY:O(N)
        SPACE COMPLEXITY:O(N)

        int[] leftMax=new int[n];
        int[] rightMax=new int[n];

        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }

        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }

        int totalWater=0;
        for(int i=0;i<n;i++){
            totalWater+=(Math.min(leftMax[i],rightMax[i])-height[i]);
        }

        return totalWater;
        */


        /*OPTIMAL SOLUTION:
        TIME COMPLEXITY: O(N)
        SPACE COMPLEXITY: O(1)*/

        int totalWater=0;

        int left=0, right=n-1;
        int leftMax=height[left],rightMax=height[right];

        while(left<right){
            leftMax=Math.max(leftMax,height[left]);
            rightMax=Math.max(rightMax,height[right]);
           
           if(leftMax<rightMax){
            totalWater+=leftMax-height[left];
             left++;
           }else{
            totalWater+=rightMax-height[right];
             right--;
           }
        }

        return totalWater;
    }
}
