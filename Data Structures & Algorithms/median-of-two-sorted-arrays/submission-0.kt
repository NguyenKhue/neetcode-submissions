class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        // println(merge(intArrayOf(1,2,3), intArrayOf(4,5,6)).toList())
        // println(merge(intArrayOf(1,2,3), intArrayOf(0,5,6)).toList())
        // println(merge(intArrayOf(1,2,3), intArrayOf(2,5,6)).toList())
        // println(merge(intArrayOf(1,2,3,8,9), intArrayOf(2,5,6)).toList())
        // println(merge(intArrayOf(4,5,6), intArrayOf(1,2,3)).toList())
        // println(merge(intArrayOf(4,5,6), intArrayOf(1,2,3,4,7,8)).toList())

        val nums = merge(nums1, nums2)

        if(nums.size % 2 != 0) {
            return nums[nums.size/2] * 1.0
        } else {
            return (nums[nums.size/2] + nums[nums.size/2 - 1])/2.0
        }
    }

    fun merge(nums1: IntArray, nums2: IntArray): IntArray {
        val nums = IntArray(nums1.size + nums2.size)

        var k = 0
        var i = 0;
        var j = 0;

        while(i < nums1.size && j < nums2.size) {
            if(nums1[i] <= nums2[j]) {
                nums[k++] = nums1[i++]
            } else {
                nums[k++] = nums2[j++]
            }
        }

        while(i < nums1.size) {
            nums[k++] = nums1[i++]
        }

        while(j < nums2.size) {
            nums[k++] = nums2[j++]
        }

        return nums
    }
}
