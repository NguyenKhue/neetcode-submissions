class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var maxCount = 0
        var l = 0
        var r = 0
        val track = hashMapOf<Char, Int>()
        var longest = 0

        while(r < s.length) {
            val c = s[r]

            track[c] = track[c]?.plus(1) ?: 1
            maxCount = maxOf(maxCount, track[c]!!)

            // println("$r -> $l, maxCount: $maxCount, ${r - l - maxCount + 1}")

            if(r - l - maxCount + 1 > k) {
                track[s[l]] = track[s[l]]!! - 1
                maxCount = maxOf(maxCount, track[s[l]]!!)
                l++
            } else  {
                longest = maxOf(longest, r - l + 1)
                // println("got max: $longest")
            }

            r++
        }


        return longest
    }
}
