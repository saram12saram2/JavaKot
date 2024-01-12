
class Solution {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val decimalNumber = 31
            val binaryNumber = "11110"
            println("Binary number $binaryNumber is equal to decimal number ${toDecimal(binaryNumber)}")

        }


        fun toDecimal(binaryNumber: String?): Int {
            var decimalNumber = 0
            binaryNumber?.let {
                for (i in binaryNumber.indices) {  
                    
                    val index = binaryNumber.length - 1 - i
                    
                    val value = Character.getNumericValue(binaryNumber[index])  // char to int ('1' to 1)
                    decimalNumber += value * Math.pow(2.0, i.toDouble()).toInt()
                    
                   
                    // println("index:  ${index}, binaryNumber[index]: ${binaryNumber[index]} == value:  ${value}")                    
                    // println("i:  ${i}, decimalNumber: ${decimalNumber}")

                    
                    
                }
            }
            return decimalNumber
        }

        
    }
}

/*
 * it.indices:  0..4
 * it.length:  5
 * index  4 = value "_ _ _ _ 0 "
 * index  3 = value "_ _ _ 1 _ "
 * index  2 = value "_ _ 1 _ _ "
 * index  1 = value "_ 1 _ _ _ "

*/

/*
Output: 

index:  4, binaryNumber[index]: 0 == value:  0
i:  0, decimalNumber: 0
index:  3, binaryNumber[index]: 1 == value:  1
i:  1, decimalNumber: 2
index:  2, binaryNumber[index]: 1 == value:  1
i:  2, decimalNumber: 6
index:  1, binaryNumber[index]: 1 == value:  1
i:  3, decimalNumber: 14

index:  0, binaryNumber[index]: 1 == value:  1
i:  4, decimalNumber: 30

Binary number 11110 is equal to decimal number 30

*/
