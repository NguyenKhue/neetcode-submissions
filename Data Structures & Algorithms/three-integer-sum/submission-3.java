class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        var triples = new ArrayList<List<Integer>>();
        var set = new HashSet<String>();

        for(int i = 0; i < nums.length - 2; i++) {
            var results =  twoSum(nums, i + 1, 0 - nums[i]);

            if(!results.isEmpty()) {
                for(List<Integer> result : results) {
                    if(result.isEmpty()) continue;

                    String key = nums[i] + "" + result.get(0) + "" + result.get(1);

                    if(!set.contains(key)) {
                        var triple = new ArrayList<Integer>(result);

                        triple.add(0, nums[i]);
                        triples.add(triple);
                        set.add(key);
                    }
                }
            }
        }

        return triples;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int i = start;
        int j = nums.length - 1;
        var results = new ArrayList<List<Integer>>();

        while(i < j) {
            int sum = nums[i] + nums[j];

            if(sum == target) {
                results.add(List.of(nums[i], nums[j]));
                i++;
                j--;
            }
            else if(sum > target) j--;
            else if(sum < target) i++;
        }

        return results;
    }
}
