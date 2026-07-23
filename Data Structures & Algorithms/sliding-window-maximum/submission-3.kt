class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val maxs = IntArray(nums.size - k + 1)

        val set = PriorityQueue<Int>(compareByDescending { it })
        
        for(i in 0 until k) {
            set.add(nums[i])
        }

        maxs[0] = set.peek()

        for(i in k until nums.size) {
            // println("before $set")
            set.remove(nums[i - k])
            set.offer(nums[i])
            // println("add ${nums[i]} remove ${nums[i - k]} peek ${set.peek()}")
            maxs[i - (k - 1)] = set.peek()
        }

        return maxs
    }
}
