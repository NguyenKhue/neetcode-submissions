class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var maxRect = 0;

        for(i in heights.indices) {
            var l = i
            var r = i

            while(l > 0 && heights[l - 1] >= heights[i]) {
                l--
            }

            while(r < (heights.size - 1) && heights[r + 1] >= heights[i]) {
                r++
            }

            maxRect = maxOf(maxRect, (r - l + 1) * heights[i])
        }

        return maxRect
    }
}
