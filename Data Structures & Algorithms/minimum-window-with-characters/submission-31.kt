class Solution {
    fun minWindow(s: String, t: String): String {
        if(t.length > s.length) return ""

        val map = IntArray(128)
        var count = 0

        for(c in t) {
            map[c.code]++
        }

        var l  = 0;
        var r = 0;
        var result = ""

        val map2 = IntArray(128)

        for((index, c) in s.withIndex()) {

            val cIndex = c.code
            count -= minOf(map[cIndex], map2[cIndex])
            map2[cIndex]++
            count += minOf(map[cIndex], map2[cIndex])

            if(map[cIndex] > 0) r = index

            
            if(count == t.length) {
                while(l < index) {
                    val lIndex = s[l].code
                    if(map[lIndex] > 0 && map2[lIndex] > 0) {
                        if(map2[lIndex]!! > map[lIndex]!!) {
                            map2[lIndex] = map2[lIndex]!! - 1
                        }
                        else break
                    }

                    l++
                }
                
                val substr = s.substring(l..r)
                if(result.isEmpty() || result.length > substr.length) result = substr
            }
        }

        return result
    }
}
