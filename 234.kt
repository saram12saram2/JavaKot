/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        // Initialize two pointers: 'slow' and 'fast'
        var slow = head
        var fast = head

        // Step 1: Find the middle of the linked list
        // Fast moves twice as fast as slow, so slow will be at the midpoint
        while (fast != null && fast.next != null) {
            fast = fast.next?.next
            slow = slow?.next
        }

        // Step 2: Reverse the second half of the list starting from the middle
        // 'prev' will point to the head of the reversed portion
        var prev: ListNode? = null
        while (slow != null) {
            val temp = slow.next  // Store the next node temporarily
            slow.next = prev      // Reverse the pointer of the current node
            prev = slow           // Move 'prev' to the current node
            slow = temp           // Advance 'slow' to the next node
        }

        // Step 3: Compare the left and right halves to check if they form a palindrome
        var left = head    // Pointer to the start of the first half
        var right = prev   // Pointer to the start of the reversed second half
        while (right != null) {
            // If corresponding values do not match, the list is not a palindrome
            if (right.`val` != left?.`val`) return false
            left = left.next   // Move to the next node in the first half
            right = right.next // Move to the next node in the second half
        }

        // If all values match, the list is a palindrome
        return true
    }
}
