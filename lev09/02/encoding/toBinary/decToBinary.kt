/*
десятичное число в его двоичное представление
*/

class Solution {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val decimalNumber = 31
            println("Decimal number $decimalNumber is equal to binary number ${decToBinary(decimalNumber)}")
        }

        fun decToBinary(decimalNumber: Int): String {
            var binaryNumber = ""
            var tempDecimal = decimalNumber
            if (tempDecimal <= 0) {
                return binaryNumber
            }


            while (tempDecimal != 0) {
                binaryNumber = (tempDecimal % 2).toString() + binaryNumber
                tempDecimal /= 2
                
                // println("binaryNumber: ${binaryNumber}")
                // println("tempDecimal:  ${tempDecimal}")
            }
            return binaryNumber
        }

        
    }
}

/*
Output:
​
binary: 
temp: 31

binaryNumber: 1
tempDecimal:  15
binaryNumber: 11
tempDecimal:  7
binaryNumber: 111
tempDecimal:  3
binaryNumber: 1111
tempDecimal:  1
binaryNumber: 11111
tempDecimal:  0

Decimal number 31 is equal to binary number 11111
*/


/*

Ex: tempDecimal 7, binaryNumber  "11"

остаток от деления  7 % 2 = 1, toString() = "1"
binaryNumber "11" + "1" = "111"
*/

