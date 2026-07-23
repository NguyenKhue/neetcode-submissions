class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = IntArray(nums.size - k + 1)
        val deque = ArrayDeque<Int>()  // lưu INDEX, không lưu giá trị

        for (i in nums.indices) {
            // 1. Loại bỏ index đã ra khỏi cửa sổ (ở đầu deque)
            if (deque.isNotEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst()
            }

            // 2. Loại bỏ mọi phần tử ở cuối deque nhỏ hơn hoặc bằng phần tử mới
            //    (vì chúng không còn cơ hội là max nữa)
            while (deque.isNotEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast()
            }

            // 3. Thêm index hiện tại vào cuối deque
            deque.offerLast(i)

            // 4. Khi cửa sổ đã đủ kích thước k, đầu deque chính là index của max
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()]
            }
        }

        return result
    }
}