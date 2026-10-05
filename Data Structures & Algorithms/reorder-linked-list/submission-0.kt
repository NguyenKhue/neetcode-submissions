/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        var l1 = head
        var l2 = head

        while(l2?.next?.next != null) {
            l1 = l1?.next
            l2 = l2?.next?.next
        }

        var reverse = reverseList(l1?.next)

        l1?.next = null
        l2 = head

        while(l2 != null) {
            val nextL2 = l2?.next
            val nextReverse = reverse?.next

            l2?.next = reverse
            reverse?.next = nextL2

            l2 = nextL2
            reverse = nextReverse
        }
    }

    private fun reverseList(head: ListNode?): ListNode? {
        var i = head?.next

        head?.next = null

        var reverseHead: ListNode? = head

        while(i != null) {
            val nextNode = i.next
            val reverseNode = i

            reverseNode.next = reverseHead
            reverseHead = reverseNode

            i = nextNode
        }

        return reverseHead
    }
}
