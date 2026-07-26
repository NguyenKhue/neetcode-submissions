class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<String>()

        for(token in tokens) {
            if(token in "+-*/") {
                if(stack.isEmpty()) stack.addLast(token)
                else {
                    val b = stack.removeLast().toInt()
                    val a = stack.removeLast().toInt()

                    val result = when(token) {
                        "+" -> a + b
                        "-" -> a - b
                        "*" -> a * b
                        "/" -> a / b
                        else -> a + b
                    }

                    stack.addLast("$result")
                }
            } else {
                if(stack.isNotEmpty() && stack.peek() in "+-*/") {
                    if(stack.last() == "-") {
                        stack.removeLast()
                        stack.addLast("${-token.toInt()}")
                    } else {
                        stack.removeLast()
                        stack.addLast(token)
                    }
                } else stack.addLast(token)
            }
        }

        return stack.last().toInt()
    }
}
