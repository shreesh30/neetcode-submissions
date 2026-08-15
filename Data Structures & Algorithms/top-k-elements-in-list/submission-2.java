class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       
       return getTopKFrequentUsingMap(nums, k);
        // Map<Integer, Integer> map = new HashMap<>();

        // for (int num : nums) {
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        // PriorityQueue<Map.Entry<Integer, Integer>> pq =
        //     new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        // pq.addAll(map.entrySet());

        // List<Integer> result = new ArrayList<>();

        // while (result.size() < k) {
        //     result.add(pq.poll().getKey());
        // }

        // return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] getTopKFrequentUsingMap(int [] nums, int k){
Map<Integer, Integer> map=new HashMap<>();

        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        List<Integer>
    result=map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(Map.Entry::getKey).limit(k).toList();
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
