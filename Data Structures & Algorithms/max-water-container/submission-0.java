class Solution {
    public int maxArea(int[] heights) {
        int n=heights.length;

        int result=0;
        
        for(int left=0;left<n;left++){
            for(int right=left+1;right<n;right++){
                int area=(right-left)*Math.min(heights[left],heights[right]);
                result=Math.max(result, area);
            }
        }

        return result;
    }
}
