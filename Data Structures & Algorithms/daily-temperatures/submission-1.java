class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // This is a variation of Next Greater Element Problem

        int n=temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] result=new int[n];

        for(int i=0;i<n;i++){
            int temp=temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()]<temp){
                int idx=stack.pop();
                result[idx]=i-idx;
            }

            stack.push(i);
        }

        return result;
    }
}
