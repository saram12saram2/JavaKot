class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        // Initialize pointers to traverse the input lists
        var r1 = l1
        var r2 = l2

        // Create a dummy node to start the merged linked list
        val ll = ListNode(0)

        // Pointer to build the final merged list, starting at the dummy node
        var rr = ll

        // Iterate while at least one of the lists still has nodes
        while (true) {
            // If both lists are empty, stop the loop
            if (r1 == null && r2 == null) {
                break
            }

            // If the first list is empty, link remaining nodes from the second list and break
            if (r1 == null) {
                rr.next = r2
                break
            }

            // If the second list is empty, link remaining nodes from the first list and break
            if (r2 == null) {
                rr.next = r1
                break
            }

            // Compare the current nodes of both lists and add the smaller node to the merged list
            if (r1.`val` <= r2.`val`) {
                rr.next = r1  // Link the current node from the first list
                r1 = r1.next  // Move to the next node in the first list
            } else {
                rr.next = r2  // Link the current node from the second list
                r2 = r2.next  // Move to the next node in the second list
            }

            // Move the pointer to the last node of the merged list
            rr = rr.next!!
        }

        // Return the merged list, skipping the dummy head node
        return ll.next
    }
}
