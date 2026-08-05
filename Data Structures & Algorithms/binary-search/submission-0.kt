class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if(nums.isEmpty()) return -1
        var left = 0;
        var right = nums.size - 1

        while(left <= right) {
            val i = (right - left)/2 + left

            if(nums[i] == target) return i
            if(nums[i] > target) right = i - 1
            else left = i + 1

        }

        return -1
    }
}
