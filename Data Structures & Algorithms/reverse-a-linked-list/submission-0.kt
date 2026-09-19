/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if(head == null) return null

        var nodes = ListNode(head.`val`)
        var newHead = head.next


        while(newHead != null) {
            val next = newHead.next

            val newNode = newHead.apply {
                this.next = nodes
            }

            nodes = newNode

            newHead = next
        }

        return nodes
    }
}
