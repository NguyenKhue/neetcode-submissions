/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val minQueue = PriorityQueue<ListNode>(compareBy { it.`val`})

        for(node in lists) {
            var i = node

            while(i != null) {
                minQueue.add(i)
                i = i?.next
            }
        }

        val head = ListNode(-1)
        var i = head

        while(minQueue.isNotEmpty()) {
            val minNode = minQueue.poll()

            i.next = minNode
            i = minNode
        }


        return head.next
    }
}
