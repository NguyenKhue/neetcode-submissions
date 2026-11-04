class Solution {
    fun minWindow(s: String, t: String): String {
        val tmap = hashMapOf<Char, Int>()

        for(c in t) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1)
        }

        var l = 0
        var count = t.length
        var minSubString = ""

        for(r in 0 until s.length) {
            val rC = s[r]
            val freq = tmap[rC]

            freq?.let {
                if(it > 0) count--
                tmap.put(rC, it - 1)
            }

            while(count == 0) {
                val rl = s[l]
                val rlFreq = tmap[rl]

                rlFreq?.let {
                    if(it == 0) count++
                    tmap.put(rl, it + 1)
                }

                val newMinWindow = s.substring(l, r + 1)

                //println(newMinWindow)

                if(newMinWindow.length < minSubString.length || minSubString.isEmpty()) {
                    minSubString = newMinWindow
                }

                l++
            }
        }

        return minSubString
    }
}