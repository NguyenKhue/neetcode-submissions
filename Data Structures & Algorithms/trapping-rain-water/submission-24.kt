class Solution {
    fun trap(height: IntArray): Int {
        var l = 0
        var maxHL = height[l]
        var r = height.size - 1
        var maxHR = height[r]
        var w = 0

        while(l < r) {

            if(maxHL < maxHR) {
                w += (maxHL - height[l])
                l++
                maxHL = maxOf(maxHL, height[l])
            } else {
                w += (maxHR - height[r])
                r--
                maxHR = maxOf(maxHR, height[r])
            }
        }

        return w
    }
}
