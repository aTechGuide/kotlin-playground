package guide.atech.basics

/**
 * rockthejvm -> Functions
 */

// Unit == "void"
fun simpleFunction(arg: String): Unit {
    println("Just passed an argument: $arg") // string "template" ir "interpolation"
}

// Special Syntax for Single Expression Functions
fun combineStrings(strA: String, strB: String): String = "$strA---$strB"

// recursion (functional programming)
fun concatenateString(aString: String, count: Int): String =
    if (count <= 0) ""
    else aString + concatenateString(aString, count - 1)

// default args
fun demoDefaultArg(regularArg: String = "Kotlin", intArg: Int = 0) = "$regularArg-----$intArg"

// nested function calls
fun complexFunction(someArg: String) {
    //very complex code

    fun innerFunction(innerArg: Int) {
        println("Outer Arg: $someArg, inner arg: $innerArg")
    }

    innerFunction(45)
}

/**
 * Exercises
 */
// 1
fun greeting(name: String, age: Int) = "Hi, my name is $name and I am $age years old."

// 2
fun factorial(n: Int): Long =
    if (n <= 0) 0
    else if (n == 1) 1
    else n * factorial(n - 1)

// 3
fun fibonacci(n: Int): Int =
    if (n <= 0) -1
    else if (n == 1) 1
    else if (n == 2) 2
    else fibonacci(n - 1) + fibonacci(n - 2)

// 4:  1 < d < (n / 2), n % d == 0 => n is NOT a prime
tailrec fun testPrime(n: Int, d: Int = 2): Boolean =
    if (n % d == 0) false
    else if (d > n/2) true
    else testPrime(n, d + 1) // no stack frames to allocate because the recursive call is computed LAST on this branch
    // ^^^^^^^^^^^^^^^^^^^^^^^^ tail position == TAIL Recursion



fun main() {
    //default Args
    demoDefaultArg(intArg = 3)
}