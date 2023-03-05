fun main() {
    val number = generateNumber()
    var count = 0

    while (true) {
        print("Enter a 4-digit number with no repeating digits: ")
        val guess = readLine()?.takeIf { it.length == 4 && it.toSet().size == 4 } ?: continue // checks if user typed a 4-digit number or else it will ask the user to try again

        count++
        val result = getResult(guess, number)   // calculates the number of digits guessed correctly regardless of their position and the number of digits guessed correctly at their correct position.
        println("Result: $result")

        if (guess == number) {
            println("Congratulations! You guessed the number $number in $count attempts.")  // print if guessed correctly
            break
        }
    }
}

fun generateNumber(): String {      // generates numbers from given list 'mutableListOf'
    val digits = mutableListOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
    digits.shuffle()
    return digits.subList(0, 4).joinToString("")
}

fun getResult(guess: String, number: String): String {      // function to get the results
    val n = guess.count { it in number }                    // counting the attempts
    val m = guess.withIndex().count { it.value == number[it.index] }       // checks the correct digits in the correct place
    return "$n:$m"


    // learning diary 1
}
