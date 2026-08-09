class Solution {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        var min = 1001

        while(l <= r) {
            val mid = (r - l)/2 + l
            min = minOf(min, nums[mid])
            println("$min $l, $r")

            if(nums[mid] >= nums[r]) l = mid + 1
            else r = mid - 1
        }

        return min
    }
}
