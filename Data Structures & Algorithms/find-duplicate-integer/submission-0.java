class Solution {
    public int findDuplicate(int[] nums) {
        /*For this problem, think of each number at index i as a 
        pointer node pointing to another pointer 
        
        for example: [1,3,4,2,2]

        1 -> 3 -> 2 -> 4
                  ^    |
                  |____| 
        */

        int slow=0, fast=0;

        while(true){
            slow=nums[slow];
            fast=nums[nums[fast]];

            if(slow==fast){
                break;
            }
        }

        int slow2=0;
        while(true){
            slow=nums[slow];
            slow2=nums[slow2];

            if(slow==slow2){
                return slow;
            }
        }
    }
}
