class Solution {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1

        while (l < r) {
            val mid = (r - l) / 2 + l
            if (nums[mid] > nums[r]) l = mid + 1
            else r = mid
        }

        return nums[l]
    }
}
