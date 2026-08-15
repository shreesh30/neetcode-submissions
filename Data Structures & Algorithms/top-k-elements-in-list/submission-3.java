class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //    return getTopKFrequentUsingMap(nums, k);
        // return getTopKFrequentUsingPQ(nums, k);
        return getTopKFrequentUsingBucketSort(nums, k);
    }

    // BRUTE FORCE:
    // TIME COMPLEXITY: O(N log N)
    public int[] getTopKFrequentUsingMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = map.entrySet()
                                   .stream()
                                   .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                   .map(Map.Entry::getKey)
                                   .limit(k)
                                   .toList();
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // OPTIMIZED:
    // TIME COMPLEXITY: O(N log N)
    public int[] getTopKFrequentUsingPQ(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        List<Integer> result = new ArrayList<>();

        while (result.size() < k) {
            result.add(pq.poll().getKey());
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // OPTIMIZED(BUCKET SORT):
    // TIME COMPLEXITY: O(N)

    public int[] getTopKFrequentUsingBucketSort(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> bucket = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            bucket.get(freq).add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int i = nums.length; i >= 1 && index<k; i--) {
            for (int num : bucket.get(i)) {
                result[index++]=num;

                if (index == k) {
                    break;
                }
            }
        }

        return result;
    }
}
