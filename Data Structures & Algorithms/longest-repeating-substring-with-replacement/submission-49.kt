class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val counts = hashMapOf<Char, Int>()
        var maxCount = 0
        var l = 0
        var maxRepeat = 0

        for((r, c) in s.withIndex()) {
            counts[c] = (counts[c] ?: 0) + 1
            maxCount = maxOf(maxCount, counts[c]!!)

            if(r - l + 1 - maxCount > k) {
                l++
                counts[s[l-1]] = counts[s[l-1]]!! - 1 
                maxCount = maxOf(maxCount, counts[s[l-1]]!!)
            }

            maxRepeat = r - l + 1
        }

        return maxRepeat;
    }
}
