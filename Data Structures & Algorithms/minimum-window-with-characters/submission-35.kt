class Solution {
    fun minWindow(s: String, t: String): String {
        if (s.length < t.length || t.isEmpty()) return ""

        val map = IntArray(128)

        for (c in t) {
            map[c.code]++
        }

        var left = 0
        var missing = t.length

        var minStart = 0
        var minLength = Int.MAX_VALUE

        for (right in s.indices) {
            val rc = s[right].code

            if (map[rc] > 0) {
                missing--
            }
            map[rc]--

            while (missing == 0) {
                val windowLength = right - left + 1

                if (windowLength < minLength) {
                    minLength = windowLength
                    minStart = left
                }

                val lc = s[left].code
                map[lc]++

                if (map[lc] > 0) {
                    missing++
                }

                left++
            }
        }

        return if (minLength == Int.MAX_VALUE) {
            ""
        } else {
            s.substring(minStart, minStart + minLength)
        }
    }
}