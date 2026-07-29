class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val n = position.size
        val indices = (0 until n).sortedByDescending { position[it] }

        var fleet = 1
        var leaderDist = (target - position[indices[0]]).toLong()
        var leaderSpeed = speed[indices[0]].toLong()

        for (k in 1 until indices.size) {
            val i = indices[k]
            val dist = (target - position[i]).toLong()
            val spd = speed[i].toLong()

            // so sánh dist/spd > leaderDist/leaderSpeed
            // <=> dist * leaderSpeed > leaderDist * spd
            if (dist * leaderSpeed > leaderDist * spd) {
                fleet++
                leaderDist = dist
                leaderSpeed = spd
            }
        }

        return fleet
    }
}