class Solution {
    fun isValid(s: String): Boolean {
        val map = mapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
        )
        val stack = ArrayDeque<Char>()

        for(c in s) {
            val last = stack.lastOrNull()

            if(last == map[c] && last != null) stack.removeLast()
            else stack.addLast(c)
        }

        return stack.isEmpty()
    }
}
