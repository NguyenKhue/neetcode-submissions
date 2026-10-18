class Node(
    val key: Int,
    var value: Int,
    var prev: Node? = null, 
    var next: Node? = null
)

class LRUCache(capacity: Int) {
    private var head: Node = Node(-1, -1)
    private var tail: Node = Node(-1, -1)
    private val maps = hashMapOf<Int, Node>()
    private var maxCapacity = capacity

    init {
        head.next = tail
        tail.prev = head
    }

    private fun removeNode(node: Node) {
        node?.prev?.next = node?.next
        node?.next?.prev = node?.prev

        // node.prev = null
        // node.next = null
    }

    private fun addToHead(node: Node) {
        node.next = head.next
        head.next?.prev = node
        node.prev = head
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

        if(node != null) {
            node.value = value
            removeNode(node)
            addToHead(node) 
        } else {
            if(maps.size == maxCapacity) {
                maps.remove(tail.prev!!.key)
                removeNode(tail.prev!!)
            }

            val newNode = Node(key, value)  
            maps[key] = newNode
            addToHead(newNode)
        }
    }
}