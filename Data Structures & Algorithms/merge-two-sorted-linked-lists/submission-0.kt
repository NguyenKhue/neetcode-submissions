/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val mergeNodes = ListNode(0)
        var n1 = list1
        var n2 = list2
        var merge = mergeNodes
        
        while(n1 != null && n2 != null) {
            if(n1.`val` <= n2.`val`) {
                merge.next = n1
                merge = n1
                n1 = n1.next
            } else {
                merge.next = n2
                merge = n2
                n2 = n2.next
            }

        }

        while(n1 != null) {
            merge.next = n1
            merge = n1
            n1 = n1.next
        }

        while(n2 != null) {
            merge.next = n2
            merge = n2
            n2 = n2.next
        }

        return mergeNodes.next
    }
}
