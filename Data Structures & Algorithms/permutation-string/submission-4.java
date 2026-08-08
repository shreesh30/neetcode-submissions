class Solution {
    public boolean checkInclusion(String s1, String s2) {
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
    }
}
