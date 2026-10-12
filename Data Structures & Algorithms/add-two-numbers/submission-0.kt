/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if(l1 == null && l2 == null) return null

        val sum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0)
        // println("sum: $sum")
        val newNode = ListNode(sum % 10)
        val x = (sum/10).takeIf { it > 0 }
        // println("x: $x")
        val l1Next = x?.let {
            l1?.next?.apply {
                `val` += it
            } ?: ListNode(it)
        } ?: l1?.next

        // println(l1Next?.`val`)

        newNode?.next = addTwoNumbers(l1Next, l2?.next)
        
        return newNode
    }
}
