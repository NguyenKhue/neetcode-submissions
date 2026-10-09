/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        val hashTable = mutableMapOf<Node, Node?>()
        var newHead: Node? = Node(0)
        val returnHead = newHead
        var i = head

        while(i != null) {
            val node = Node(i.`val`)
            hashTable.put(i, node)
            newHead?.next = node
            newHead = newHead?.next
            i = i?.next
        }

        i = head

        while(i != null) {
            val ref = hashTable.get(i)
            
            i?.random?.let {
                ref?.random = hashTable.get(it)
            }

            i = i?.next
        }
        
        return returnHead?.next
    }
}
