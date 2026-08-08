class Solution {
    public String minWindow(String s, String t) {
        /* BRUTE FORCE APPROACH:
        TIME COMPLEXITY: O(N^2*K)~O(N^2)
        SPACE COMPLEXITY: O(N)


        int n=s.length();
        int m=t.length();

        Map<Character, Integer> freqT=new HashMap<>();

        for(char c:t.toCharArray()){
            freqT.put(c, freqT.getOrDefault(c, 0)+1);
        }

        int minLength=Integer.MAX_VALUE;

        String result="";

        for(int i=0;i<n;i++){
            Map<Character, Integer> freqMap=new HashMap<>();

            for(int j=i;j<n;j++){
                char c=s.charAt(j);
                freqMap.put(c,freqMap.getOrDefault(c,0)+1);

                boolean valid=true;

                for(Map.Entry<Character,Integer> entry:freqT.entrySet()){
                    if(freqMap.getOrDefault(entry.getKey(),0)<entry.getValue()){
                        valid=false;
                        break;
                    }

                }
                  if(valid && (j-i+1)<minLength){
                        minLength=j-i+1;
                        result=s.substring(i,j+1);
                    }
            }
        }

        return result;
        */

        /* SLIGHTLY OPTIMIZED:
        TIME COMPLEXITY: O(N^2)
        SPACE COMPLEXITY: O(N)

        int n = s.length();
        int m = t.length();

        Map<Character, Integer> tFreq = new HashMap<>();

        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        String result = "";

        for (int i = 0; i < n; i++) {
            int required = m;
            Map<Character, Integer> windowFreq=new HashMap<>();

            for (int j = i; j < n; j++) {
                char c = s.charAt(j);

                windowFreq.put(c, windowFreq.getOrDefault(c,0)+1);

                if (windowFreq.get(c)<=tFreq.getOrDefault(c,0)) {
                    required -= 1;
                }

                if (required == 0 && (result.isBlank() || (j - i + 1) < result.length())) {
                        result = s.substring(i, j + 1);
                        break;
                }
            }
        }

        return result;
        */

        int m = s.length();
        int n = t.length();

        Map<Character, Integer> tFreq = new HashMap<>();

        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;

        Map<Character, Integer> windowFreq = new HashMap<>();
        int required = n;

        String result = "";

        while (right < m) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            if (windowFreq.get(c) <= tFreq.getOrDefault(c, 0)) {
                required--;

                while(required==0){
                    if(result.isBlank()||(right-left+1)<result.length()){
                        result=s.substring(left,right+1);
                    }

                    char leftChar=s.charAt(left);
                    windowFreq.put(leftChar,
                    windowFreq.get(leftChar)-1);

                    if(windowFreq.get(leftChar)<tFreq.getOrDefault(leftChar,0)){
                        required++;
                    }
                    left++;
                }
            }
            right++;
        }

        return result;
    }
}
