class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();

        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        System.out.println(map);

        List<Integer> result=map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(Map.Entry::getKey).limit(k).toList();
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
