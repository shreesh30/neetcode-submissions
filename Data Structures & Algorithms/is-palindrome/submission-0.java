class Solution {
    public boolean isPalindrome(String s) {
        int n=s.length();
        s=s.toLowerCase();

        int left=0,right=n-1;

        while(left<right){
            char leftChar=s.charAt(left);
            char rightChar=s.charAt(right);

            if(!Character.isLetterOrDigit(leftChar)){
                left++;
            }else if(!Character.isLetterOrDigit(rightChar)){
                right--;
            }else{
                if(leftChar!=rightChar){
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }
}
