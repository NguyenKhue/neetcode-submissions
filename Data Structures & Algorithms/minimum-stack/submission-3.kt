class MinStack() {
    val stack = mutableListOf<Long>()

    fun push(`val`: Int) {
        if(stack.isEmpty()) {
            stack.add(pack(`val`, `val`))
        } else {
            val min = getMin()
            stack.add(pack(`val` , minOf(min, `val`)))
        }
    }

    fun pop() {
        stack.removeLast()
    }

    fun top(): Int {
        return unpackFirst(stack.last())
    }

    fun getMin(): Int {
        return unpackSecond(stack.last())
    }

    private fun pack(a: Int, b: Int): Long {
        return (a.toLong() shl 32) or (b.toLong() and 0xFFFFFFFFL)
    }

    private fun unpackFirst(packed: Long): Int {
        return (packed shr 32).toInt()
    }

    private fun unpackSecond(packed: Long): Int {
        return packed.toInt()
    }
}
