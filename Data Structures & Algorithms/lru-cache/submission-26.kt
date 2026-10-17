class Node(
    val key: Int,
    var value: Int,
    var prev: Node? = null, 
    var next: Node? = null
)

class LRUCache(capacity: Int) {
    private val maps = hashMapOf<Int, Node>()
    private var head: Node? = null
    private var tail: Node? = null
    private val maxCapacity = capacity

    // 1. Gỡ 1 node bất kỳ ra khỏi danh sách liên kết
    private fun removeNode(node: Node) {
        if (node.prev != null) {
            node.prev?.next = node.next
        } else {
            head = node.next // Nếu node là head
        }

        if (node.next != null) {
            node.next?.prev = node.prev
        } else {
            tail = node.prev // Nếu node là tail
        }

        node.prev = null
        node.next = null
    }

    // 2. Chèn 1 node vào vị trí đầu (head)
    private fun addToHead(node: Node) {
        node.next = head
        node.prev = null

        if (head != null) {
            head?.prev = node
        }
        head = node

        if (tail == null) {
            tail = head
        }
    }

    // 3. Đưa 1 node hiện có lên đầu
    private fun moveToHead(node: Node) {
        removeNode(node)
        addToHead(node)
    }

    fun get(key: Int): Int {
        val node = maps[key] ?: return -1
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = maps[key]

        if (node != null) {
            // Trường hợp Key ĐÃ tồn tại: Cập nhật giá trị & đưa lên Head
            node.value = value
            moveToHead(node)
        } else {
            // Trường hợp Key MỚI: Kiểm tra capacity
            if (maps.size == maxCapacity) {
                tail?.let {
                    maps.remove(it.key)
                    removeNode(it) // removeNode tự động xử lý đúng head/tail khi capacity = 1
                }
            }

            val newNode = Node(key, value)
            maps[key] = newNode
            addToHead(newNode)
        }
    }
}