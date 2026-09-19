/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head?.next?.next

        while(slow != null && fast != null) {
            if(slow === fast) return true

            slow = slow.next
            fast = fast?.next?.next
        }

        return false
    }
}
