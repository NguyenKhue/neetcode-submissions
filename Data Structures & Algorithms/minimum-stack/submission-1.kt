class MinStack() {
    val stack = mutableListOf<Pair<Int, Int>>()

    fun push(`val`: Int) {
        if(stack.isEmpty()) {
            stack.add(`val` to `val`)
        } else {
            val last = stack.last()
            stack.add(`val` to minOf(last.second, `val`))
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
