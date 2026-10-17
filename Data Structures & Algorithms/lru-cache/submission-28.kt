class Node(
    val key: Int,
    var value: Int,
    var prev: Node? = null, 
    var next: Node? = null
)

class LRUCache(capacity: Int) {
    private val maps = hashMapOf<Int, Node>()
    private val maxCapacity = capacity

    // 2 Node giả làm mốc cố định, không chứa dữ liệu thực tế
    private val head = Node(-1, -1)
    private val tail = Node(-1, -1)

    init {
        head.next = tail
        tail.prev = head
    }

    private fun removeNode(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun addToHead(node: Node) {
        node.next = head.next
        node.prev = head
        head.next?.prev = node
        head.next = node
    }

    fun get(key: Int): Int {
        val node = maps[key] ?: return -1
        removeNode(node)
        addToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = maps[key]
        if (node != null) {
            node.value = value
            removeNode(node)
            addToHead(node)
        } else {
            if (maps.size == maxCapacity) {
                // Tail thật sự luôn nằm ngay trước tail giả
                val lru = tail.prev!!
                maps.remove(lru.key)
                removeNode(lru)
            }
            val newNode = Node(key, value)
            maps[key] = newNode
            addToHead(newNode)
        }
    }
}