class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val n = position.size
        val indices = (0 until n).sortedByDescending { position[it] }

        var fleet = 0
        var leaderTime  = -1.0

        for(i in indices) {
            val time = (target - position[i]).toDouble()/speed[i]

            if(time > leaderTime) {
                fleet++
                leaderTime = time
            }
        }

        return fleet
    }
}
