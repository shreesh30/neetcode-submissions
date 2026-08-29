class Solution {
    public class Pair{
        int temp;
        int index;

        Pair(int temp, int index){
            this.temp=temp;
            this.index=index;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        // This is a variation of Next Greater Element Problem

        int n=temperatures.length;
        Stack<Pair> stack = new Stack<>();
        int[] result=new int[n];

        for(int i=0;i<n;i++){
            int temp=temperatures[i];
            while(!stack.isEmpty() && stack.peek().temp<temp){
                Pair pair=stack.pop();
                result[pair.index]=i-pair.index;
            }

            stack.push(new Pair(temp, i));
        }

        return result;
    }
}
