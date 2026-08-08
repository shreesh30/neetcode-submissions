class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;

        List<Integer> result=new ArrayList<>();
        
        /* BRUTE FORCE APPROACH:
        TIME COMPLEXITY: O(N^2)
        SPACE COMPLEXITY: O(N)
        for(int i=0;i<=n-k;i++){
            int max=nums[i];

            for(int j=1;j<k;j++){
                max=Math.max(max,nums[i+j]);
            }
            result.add(max);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
        */


        int left=0,right=0;
        Deque<Integer> deque=new ArrayDeque<>();

        while(right<n){
            while(!deque.isEmpty() && deque.peekFirst()<right-k+1){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[right]){
                deque.pollLast();
            }

            deque.addLast(right);

            if(right>=k-1){
                result.add(nums[deque.peekFirst()]);
            }
            right++;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
