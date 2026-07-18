class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val s1Map = mutableMapOf<Char, Int>()

        for(c in s1) {
            s1Map[c] = s1Map.getOrDefault(c, 0) + 1
        }

        var l = 0
        
        for((r, c) in s2.withIndex()) {
            if(s1Map.containsKey(c).not()) {
                while(l <= r) {
                    if(s1Map.containsKey(s2[l])) {
                        s1Map[s2[l]] = s1Map[s2[l]]!! + 1
                    }

                    l++
                }
            } else  {
                if(s1Map[c]!! == 0) {
                    while(s1Map[c]!! == 0) {
                        if(s1Map.containsKey(s2[l])) {
                            s1Map[s2[l]] = s1Map[s2[l]]!! + 1
                        }

                        l++
                    }
                }

                s1Map[c] = s1Map[c]!! - 1
            }

            if(r - l + 1 == s1.length) return true;
        }

        return false;
    }
}
