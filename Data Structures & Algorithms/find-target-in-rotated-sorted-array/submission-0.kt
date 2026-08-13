class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val minIndex = findMinIndex(nums)

        if(nums[minIndex] == target) return minIndex
        else if(target in nums[minIndex]..nums[nums.size - 1]) {
            return binarySearch(nums, minIndex, nums.size - 1, target)
        } else {
            return binarySearch(nums, 0, minIndex, target)
        }
    }

    fun binarySearch(nums: IntArray, start: Int, end: Int, target: Int): Int {
        var l = start;
        var r = end

        while(l <= r) {
            val mid = (r - l)/2 + l

            if(target == nums[mid]) return mid
            if(target > nums[mid]) l = mid + 1
            else r = mid - 1
        }

        return -1
    }

    fun findMinIndex(nums: IntArray): Int {
        var l = 0;
        var r = nums.size - 1

        while(l < r) {
            val mid = (r - l)/2 + l

            if(nums[mid] > nums[r]) l = mid + 1
            else r = mid
        }

        return l
    }
}
