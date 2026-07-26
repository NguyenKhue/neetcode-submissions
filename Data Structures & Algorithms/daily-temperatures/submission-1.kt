class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)

        for(i in 0 until (temperatures.size - 1)) {
            var j = i + 1

            while(temperatures[j] <= temperatures[i]) {
                j++

                if(j == temperatures.size) {
                    j = i
                    break
                }
            }

            result[i] = j - i
        }

        return result
    }
}
