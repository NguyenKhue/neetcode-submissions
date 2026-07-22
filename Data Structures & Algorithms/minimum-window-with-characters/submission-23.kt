class Solution {
    fun minWindow(s: String, t: String): String {
        if(t.length > s.length) return ""

        val map = mutableMapOf<Char, Int>()
        var count = 0
        var count2 = 0

        for(c in t) {
            map.put(c, map.getOrDefault(c, 0) + 1)
        }

        var l  = 0;
        var r = 0;
        var result = ""

        val map2 = mutableMapOf<Char, Int>()

        for((index, c) in s.withIndex()) {

            if(map.containsKey(c)) {
                count2 -= minOf(map[c]!!, map2.getOrDefault(c, 0))
                map2.put(c, map2.getOrDefault(c, 0) + 1)
                count2 += minOf(map[c]!!, map2[c]!!)
                count++
                r = index
            }

            println("count2: $count2")
            if(count >= t.length && count2 == t.length && map.size == map2.size) {
                while(l < index) {
                    if(map.containsKey(s[l]) && map2.containsKey(s[l])) {
                        println("${s[l]}: ${map2[s[l]]} -> ${map[s[l]]}")
                        if(map2[s[l]]!! > map[s[l]]!!) {
                            count--
                            map2[s[l]] = map2[s[l]]!! - 1
                        }
                        else break
                    }

                    l++
                }

                println("left: $l")
                println("right ${s[r]}: $r")
                
                val substr = s.substring(l..r)

                println(substr)

                if(result.isEmpty() || result.length > substr.length) result = substr
            }
        }

        return result
    }
}
