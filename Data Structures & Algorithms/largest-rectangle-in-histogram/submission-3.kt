class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        if(heights.isEmpty()) return 0

        var maxRect = 0;
        val stack = ArrayDeque<Int>()

        for(i in 0 until heights.size) {
            while(stack.isNotEmpty() && heights[i] <= heights[stack.last()]) {
                val last = stack.removeLast()
                maxRect = maxOf(maxRect, (i - (stack.lastOrNull() ?: -1) - 1) * heights[last])
            }

            stack.addLast(i)
        }

        while(stack.isNotEmpty()) {
            val last = stack.removeLast()
            maxRect = maxOf(maxRect, (heights.size - (stack.lastOrNull() ?: -1) - 1) * heights[last])
        }

        return maxRect
    }
}
