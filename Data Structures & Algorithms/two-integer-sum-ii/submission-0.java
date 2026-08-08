class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;

        int left=0, right=n-1;

        List<Integer> result=new ArrayList<>();

        while(left<right){
            int sum=numbers[left]+numbers[right];

            if(sum<target){
                left++;
            }else if(sum>target){
                right--;
            }else{
                result.add(left+1);
                result.add(right+1);
                break;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
