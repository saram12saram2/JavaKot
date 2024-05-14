class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        var dummy = ListNode(0, head)
        var prev = dummy
        var cur = head

        while (cur != null && cur.next != null) {
            val next = cur.next
            val nextNext = cur.next.next

            next.next = cur
            cur.next = nextNext
            prev.next = next

            prev = cur
            cur = nextNext
        }

        return dummy.next
    }
}
