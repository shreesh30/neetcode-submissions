class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;

        Map<String, List<String>> map=new HashMap<>();

        for(String str:strs){
            char[] charFreq=new char[26];

            for(char c:str.toCharArray()) charFreq[c-'a']++;

            String mapKey=new String(charFreq);

        if (!map.containsKey(mapKey)) map.put(mapKey, new ArrayList<>());
        map.get(mapKey).add(str);
        }

        return map.values().stream().toList();
    }
}
