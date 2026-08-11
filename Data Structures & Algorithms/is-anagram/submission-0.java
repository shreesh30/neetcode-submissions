class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n != m) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char sChar = s.charAt(i);
            map.put(sChar, map.getOrDefault(sChar, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            char tChar = t.charAt(i);

            if ((!map.containsKey(tChar)) || (map.containsKey(tChar) && map.get(tChar) <= 0)) {
                return false;
            }

            map.put(tChar, map.get(tChar) - 1);
        }

        return true;
    }
}
