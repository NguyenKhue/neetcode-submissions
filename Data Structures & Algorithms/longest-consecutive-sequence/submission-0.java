class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> sets = new TreeSet<>();

        for(int i : nums) {
            sets.add(i);
        }

        int maxCount = 0;
        int count = 0;
        Integer prevNum = null;
        
        for(Integer i : sets) {
            if(prevNum != null) {
                if(prevNum + 1 == i) count++;
                else {
                    maxCount = Math.max(count, maxCount);
                    count = 0;
                }
            }
            // System.out.println(prevNum + ":" + i + "->" + count + ":" + maxCount);
            prevNum = i;
        }

        // System.out.println(maxCount);

        return Math.max(count, maxCount) + 1;
    }
}
