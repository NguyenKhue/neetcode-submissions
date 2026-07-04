class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(maps.containsKey(nums[i])) {
                return new int[]{maps.get(nums[i]), i};
            }

            maps.put(target - nums[i], i);
        }

        return new int[] {};
    }
}
