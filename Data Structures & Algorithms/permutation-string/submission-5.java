class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
        int s1Length=s1.length();
        int s2Length=s2.length();

        if(s1Length>s2Length){
            return false;
        }

        char[] s1Freq=new char[26];

        for(char c:s1.toCharArray()){
            s1Freq[c-'a']++;
        }

        for(int i=0;i<=s2Length-s1Length;i++){
            
            char[] substringFreq=new char[26];

            for(int j=i;j<i+s1Length;j++){
                char c=s2.charAt(j);
                substringFreq[c-'a']++;
            }

            if(Arrays.equals(substringFreq, s1Freq)){
                return true;
            }
        }

        return false;
        */

        int n=s1.length();
        int m=s2.length();

        if(n>m) return false;

        int[] freq=new int[26];

        for(char c:s1.toCharArray()){
            freq[c-'a']++;
        }


        int left=0,right=0;

        int[] s2Freq=new int[26];
        while(right<m){
            s2Freq[s2.charAt(right)-'a']++;

            if((right-left+1)==n){
                if(Arrays.equals(freq,s2Freq)) return true;

                s2Freq[s2.charAt(left)-'a']--;
                left++;
            }
            right++;
        }

        return false;
    }
}
