class Solution {
    fun isValid(s: String): Boolean {
        val map = mapOf(
            '(' to ')', 
            '{' to '}', 
            '[' to ']'
        )

        val stack = ArrayDeque<Char>()

        for(c in s) {
            if(c == ')' || c == '}' || c == ']') {
                if(stack.isEmpty()) return false
                if(map[stack.last()] == c) stack.removeLast()
                else return false
            } else stack.addLast(c)
        }

        return stack.isEmpty()
    }
}
