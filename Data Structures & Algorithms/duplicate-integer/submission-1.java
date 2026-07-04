class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> counts = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(counts.contains(nums[i])) return true;
            else {
                counts.add(nums[i]);
            }
        }

        return false;
    }
}