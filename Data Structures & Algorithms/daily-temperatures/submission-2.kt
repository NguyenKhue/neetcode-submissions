class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)

        val stack = ArrayDeque<Int>()

        for(i in 0 until temperatures.size) {
            if(stack.isEmpty() || temperatures[i] <= temperatures[stack.first()]) {
                stack.addFirst(i)
            } else {
                while(stack.isNotEmpty() && (temperatures[i] > temperatures[stack.first()])) {
                    result[stack.first()] = i - stack.first()
                    stack.removeFirst()
                }

                stack.addFirst(i)
            }
        }

        return result
    }
}
