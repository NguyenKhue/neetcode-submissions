class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var slow = 0
        var fast = 0
        var secondSlow = 0

        while(true) {
            slow = nums[slow]
            fast = nums[nums[fast]]

            if(slow == fast) {
                while(true) {
                    slow = nums[slow]
                    secondSlow = nums[secondSlow]

                    if(slow == secondSlow) return slow
                }
            }
        }

        return -1
    }
}
