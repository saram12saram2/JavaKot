class solution {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val decimalNumber = 21
            println("Decimal number $decimalNumber is equal to octal number ${toOctal(decimalNumber)}")
            val octalNumber = 25
            println("Octal number $octalNumber is equal to decimal number ${toDecimal(octalNumber)}")
        }

        fun toOctal(decimalNumber: Int): Int {
            var octalNumber = 0
            if (decimalNumber <= 0) {
                return octalNumber
            }

            var i = 0
            var tempDecimal = decimalNumber
            while (tempDecimal != 0) {
                octalNumber += (tempDecimal % 8 * Math.pow(10.0, i.toDouble())).toInt()
                tempDecimal /= 8
                i++
            }
            return octalNumber
        }

        fun toDecimal(octalNumber: Int): Int {
            var decimalNumber = 0
            if (octalNumber <= 0) {
                return decimalNumber
            }

            var i = 0
            var tempOctal = octalNumber
            while (tempOctal != 0) {
                decimalNumber += (tempOctal % 10 * Math.pow(8.0, i.toDouble())).toInt()
                tempOctal /= 10
                i++
            }
            return decimalNumber
        }
    }
}


/*
Output: 
Decimal number 21 is equal to octal number 25
Octal number 25 is equal to decimal number 21
*/