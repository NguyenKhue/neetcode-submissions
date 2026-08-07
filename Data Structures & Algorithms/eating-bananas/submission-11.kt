class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        if(piles.isEmpty()) return 0

        var left = 1
        var right = piles.max()
        var rk = 0

        while(left <= right) {
            val k = (right - left) / 2 + left
            println("k: $k, right: $left, right: $right")
            var time = 0


            for(p in piles) {
                time += (k  + p - 1) / k
            }

            println("time: $time")
            
            if(time <= h) {
                right = k - 1
                rk = k
            }
            else left = k + 1

            time = 0
        }
        
        return rk
    }
}
