class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val track = hashMapOf<Char, Int>()
        var l = 0
        var r = 0
        var max = 0

        for(c in s) {
            if(track[c] != null) {
                val index = track[c]!!

                // println("found $c at $index")

                while(l <= index) {
                    track.remove(s[l++])
                }

                // println("new l: $l")
            }

            track.put(c, r)
            max = maxOf(max, r - l + 1)
            // println("put $c at $r")
            // println("max: $max")

            r++
        }
        
        return max
    }
}
