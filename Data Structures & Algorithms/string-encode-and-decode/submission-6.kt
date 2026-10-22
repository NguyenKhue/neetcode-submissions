class Solution {

    fun encode(strs: List<String>): String {
        if(strs.isEmpty()) return ""
        
        val str = strs.joinToString("ê") {
            if(it.isEmpty()) "ô"
            else it
        }

        return str
    }

    fun decode(str: String): List<String> {
        if(str.isEmpty()) return emptyList()

        val strs = mutableListOf<String>()

        for(s in str.split("ê")) {
            if(s == "ô") strs.add("")
            else strs.add(s)
        }

        return strs
    }
}
