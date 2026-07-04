class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(counts.containsKey(nums[i])) return true;
            else {
                counts.put(nums[i], 0);
            }
        }

        return false;
    }
}