class MinStack() {
    val stack = ArrayDeque<Pair<Int, Int>>()

    fun push(`val`: Int) {
        if(stack.isEmpty()) {
            stack.addLast(`val` to `val`)
        } else {
            val last = stack.last()
            stack.addLast(`val` to minOf(last.second, `val`))
        }
    }

    fun pop() {
        stack.removeLast()
    }

    fun top(): Int {
        return stack.last().first
    }

    fun getMin(): Int {
        return stack.last().second
    }
}
