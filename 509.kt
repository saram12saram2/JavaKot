class Solution {
    fun fib(n: Int): Int {
        var previous = 0  
        var current = 1   
        var next: Int     

        if (n == 0) {
            return previous
        } else {
            for (i in 2..n) {
                next = previous + current
                previous = current
                current = next
            }
        }
        return current
    }
}
