class Solution {
    fun fib(n: Int): Int {
        var f0 = 0
        var f1 = 1
        var c : Int;
        if(n == 0){
            return 0
        }else{
            for (i in 2..n){
                c = f0 + f1
                f0 = f1
                f1 = c
            }
        }
        return f1
    }
}
