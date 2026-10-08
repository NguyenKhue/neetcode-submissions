/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var i = head
        var j = n
        var start = head

        while(j > 0 && i?.next != null) {
            i = i?.next
            j--
        }

        println(i?.`val`)

        while(i?.next != null) {
            i = i?.next
            start = start?.next
        }

        println(start?.`val`)
        println(j)

        if(j == 1) return head?.next

        start?.next = start?.next?.next
        

        return head
    }
}
