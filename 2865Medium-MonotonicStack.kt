// My solution to
// 2865. Beautiful Towers I
// using Monotonic stack

class Solution {
    fun maximumSumOfHeights(heights: IntArray): Long {
        val n = heights.size
        val left = IntArray(n) { -1 }
        val right = IntArray(n) { n }
        val f = LongArray(n) { 0 }
        val g = LongArray(n) { 0 }

        // find the left limit for each i
        val stack1 = mutableListOf<Int>()
        for (i in heights.indices) {
            while (stack1.isNotEmpty() && heights[stack1.last()] > heights[i]) {
                stack1.removeAt(stack1.size - 1)
            }
            if (stack1.isNotEmpty()) {
                left[i] = stack1.last()
            }
            stack1.add(i)
        }

        // find the right limit for each i
        val stack2 = mutableListOf<Int>()
        for (i in heights.indices.reversed()) {
            while (stack2.isNotEmpty() && heights[stack2.last()] >= heights[i]) {
                stack2.removeAt(stack2.size - 1)
            }
            if (stack2.isNotEmpty()) {
                right[i] = stack2.last()
            }
            stack2.add(i)
        }

        // f array 
        for (i in heights.indices) {
            if (i > 0 && heights[i] >= heights[i - 1]) {
                f[i] = f[i - 1] + heights[i]
            } else {
                val j = left[i]
                f[i] = heights[i].toLong() * (i - j) + if (j != -1) f[j] else 0
            }
        }

        // g array 
        for (i in heights.indices.reversed()) {
            if (i < n - 1 && heights[i] >= heights[i + 1]) {
                g[i] = g[i + 1] + heights[i]
            } else {
                val j = right[i]
                g[i] = heights[i].toLong() * (j - i) + if (j != n) g[j] else 0
            }
        }

        // max sum 
        var maxSum = 0L
        for (i in heights.indices) {
            maxSum = maxOf(maxSum, f[i] + g[i] - heights[i])
        }

        return maxSum
    }
}
