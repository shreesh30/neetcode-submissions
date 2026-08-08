class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Length=s1.length();
        int s2Length=s2.length();

        if(s1Length>s2Length){
            return false;
        }

        Map<Character, Integer> s1Freq=new HashMap<>();

        for(char c:s1.toCharArray()){
            s1Freq.put(c, s1Freq.getOrDefault(c,0)+1);
        }

        for(int i=0;i<=s2Length-s1Length;i++){
            
            Map<Character, Integer> substringFreq=new HashMap<>();

            for(int j=i;j<i+s1Length;j++){
                char c=s2.charAt(j);
                substringFreq.put(c, substringFreq.getOrDefault(c,0)+1);
            }

            if(s1Freq.equals(substringFreq)){
                return true;
            }
        }

        return false;
    }
}
