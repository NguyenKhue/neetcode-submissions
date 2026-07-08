class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        var hashSet = new HashSet<Integer>();
        var starts = new ArrayList<Integer>();

        for(int i : nums) {
            if(hashSet.contains(i - 1) == false) starts.add(i);
            hashSet.add(i);
        }

        int count = 1;
        int maxCount = 0;

        for(int i : starts) {
            int start = i;
            while(hashSet.contains(start + 1)) {
                count++;
                start++;
            }

            maxCount = Math.max(count, maxCount);
            count = 1;
        }
        
        return Math.max(count, maxCount);
    }
}
