class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val haft = (nums1.size + nums2.size + 1) / 2

        var l = 0
        var r = minOf(nums1.size, nums2.size)
        val a = if(nums1.size <= nums2.size) nums1 else nums2
        val b = if(nums1.size <= nums2.size) nums2 else nums1
        var median = 0.0

        while(l <= r) {
            val x = (l + r) / 2
            val y = haft - x

            val maxLB = b.getOrElse(y - 1) { Int.MIN_VALUE }
            val minRA = a.getOrElse(x) { Int.MAX_VALUE }

            val maxLA = a.getOrElse(x - 1) { Int.MIN_VALUE }
            val minRB = b.getOrElse(y) { Int.MAX_VALUE }


            if(maxLB > minRA) l = x + 1
            else if(maxLA >  minRB) r = x - 1
            else {
                median = if((nums1.size + nums2.size) % 2 == 0) {
                    (maxOf(maxLB, maxLA) + min(minRB , minRA)) / 2.0
                } else maxOf(maxLB, maxLA) * 1.0
                break
            }
        }


        return median
    }
}
