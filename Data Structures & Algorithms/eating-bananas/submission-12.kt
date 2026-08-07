class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        if(piles.isEmpty()) return 0

        var left = 1
        var right = piles.max()
        var rk = 0

        while(left <= right) {
            val k = (right - left) / 2 + left
            var time = 0


            for(p in piles) {
                time += (k  + p - 1) / k
            }

            
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
