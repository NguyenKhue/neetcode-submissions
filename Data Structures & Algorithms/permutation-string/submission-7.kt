class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if(s1.length > s2.length) return false

        val s1F = IntArray(26)

        for(c in s1) {
            s1F[c - 'a']++
        }

        val s2F = IntArray(26)
        var l = -s1.length

        for(i in s2.indices) {
            s2F[s2[i] - 'a']++

            if(l >= 0) s2F[s2[l] - 'a']--
            l++

            if(s2F.contentEquals(s1F)) return true
        }

        return false;
    }
}
