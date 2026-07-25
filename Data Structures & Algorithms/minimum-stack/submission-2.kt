class MinStack() {
    private var min: Long = Long.MAX_VALUE
    private val stack = ArrayDeque<Long>()

    fun push(`val`: Int) {
        val valAsLong = `val`.toLong()
        if (stack.isEmpty()) {
            stack.addLast(0L)
            min = valAsLong
        } else {
            stack.addLast(valAsLong - min)
            if (valAsLong < min) {
                min = valAsLong
            }
        }
    }

    fun pop() {
        if (stack.isEmpty()) return
        val pop = stack.removeLast()
        if (pop < 0) {
            min -= pop
        }
    }

    fun top(): Int {
        val top = stack.last()
        return if (top > 0) (top + min).toInt() else min.toInt()
    }

    fun getMin(): Int {
        return min.toInt()
    }
}