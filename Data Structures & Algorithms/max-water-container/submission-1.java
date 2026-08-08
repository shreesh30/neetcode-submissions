class Solution {
    public int maxArea(int[] heights) {
        int n=heights.length;

        int result=0;
        /* BRUTE FORCE:

        for(int left=0;left<n;left++){
            for(int right=left+1;right<n;right++){
                int area=(right-left)*Math.min(heights[left],heights[right]);
                result=Math.max(result, area);
            }
        }
        */

        int left=0,right=n-1;

        int area=0;

        while(left<right){
            area=(right-left)*Math.min(heights[left],heights[right]);
            result=Math.max(result,area);

            if(heights[left]<heights[right]){
                left++;
            }else{
                right--;
            }
        }

        return result;
    }
}
