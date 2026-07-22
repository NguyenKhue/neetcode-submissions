class Solution {
    fun minWindow(s: String, t: String): String {
        if(t.length > s.length) return ""

        val map = mutableMapOf<Char, Int>()
        var count = 0

        for(c in t) {
            map.put(c, map.getOrDefault(c, 0) + 1)
        }

        var l  = 0;
        var r = 0;
        var result = ""

        val map2 = mutableMapOf<Char, Int>()

        for((index, c) in s.withIndex()) {

            if(map.containsKey(c)) {
                count -= minOf(map[c]!!, map2.getOrDefault(c, 0))
                map2.put(c, map2.getOrDefault(c, 0) + 1)
                count += minOf(map[c]!!, map2[c]!!)
                r = index
            }

            if(count == t.length && map.size == map2.size) {
                while(l < index) {
                    if(map.containsKey(s[l]) && map2.containsKey(s[l])) {
                        if(map2[s[l]]!! > map[s[l]]!!) {
                            map2[s[l]] = map2[s[l]]!! - 1
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
