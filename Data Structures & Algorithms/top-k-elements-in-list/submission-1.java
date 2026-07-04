class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> counts = new HashMap<>();
        

        for(int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
         Map<Integer, Integer> sortedMap = counts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new // Maintains insertion/sorted order
                ));

        int[] arr = new int[k];
        int i = 0;
        
        for(int key: sortedMap.keySet()) {
            if(i == k) return arr;

            arr[i] = key;
            i++;
        }

        return arr;
    }
}
