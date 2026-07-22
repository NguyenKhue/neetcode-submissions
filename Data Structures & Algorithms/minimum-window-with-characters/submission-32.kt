class Solution {
    fun minWindow(s: String, t: String): String {
        if (t.length > s.length) return ""

        val need = IntArray(128)
        for (c in t) need[c.code]++

        var required = t.length  // số ký tự còn thiếu để thỏa điều kiện
        var l = 0
        var bestLen = Int.MAX_VALUE
        var bestStart = 0

        for (r in s.indices) {
            val c = s[r].code
            if (need[c] > 0) required--
            need[c]--

            while (required == 0) {
                if (r - l + 1 < bestLen) {
                    bestLen = r - l + 1
                    bestStart = l
                }
                need[s[l].code]++
                if (need[s[l].code] > 0) required++
                l++
            }
        }

        return if (bestLen == Int.MAX_VALUE) "" else s.substring(bestStart, bestStart + bestLen)
    }
}