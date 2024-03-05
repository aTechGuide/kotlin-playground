package guide.atech.basics

/**
 * rockthejvm -> Expressions & Instructions - Basics
 * rockthejvm -> Expressions & Instructions - When Clauses
 * rockthejvm -> Expressions & Instructions - Loops
 */
fun main() {

    // expressions = structures that are turned into a value
    val meaningOfLife = 40 + 2

    // bitwise operators: shr, shl. ushr, and, or, xor, inv
    val bitExpr = 2 shl 2

    // comparison: ==, !=, ===, ==!

    // boolean: !. &&, ||

    // instructions and expressions
    // instructions are EXECUTED (Telling computer what to do) - Imperative Programming
    // expression are EVALUATED to a value - Functional Programming

    // if structure as instruction
    val aCondition = false
    if (aCondition) {
        println("Condition is true")
    } else {
        println("Condition is false")
    }

    // if structure as expression
    val anIfExpression = if (aCondition) 42 else 999

    /**
     * when - "switch on steroids"
     */
    // when INSTRUCTION
    when (meaningOfLife) {
        42 -> println("The meaning of Life from HGG")
        43 -> println("Not the meaning of life")
        else -> print("Something else")
    }

    // when EXPRESSION
    val meaningOfLifeMessage =
        when (meaningOfLife) {
            42 -> "The meaning of Life from HGG"
            43 -> "Not the meaning of life"
            else -> "Something else"
        }

    // a branch in when with multiple values
    val meaningOfLifeMessageV2 =
        when (meaningOfLife) {
           42, 43 -> "The meaning of life or close enough"
            else -> "Something else"
        }

    // branches can be arbitrary expressions
    val meaningOfLifeMessageV3 =
        when (meaningOfLife) {
            40 + 2 -> "The meaning of life computed"
            else -> "Something else"
        }

    // conditions in branches
    val meaningOfLifeMessageV4 =
        when {
            meaningOfLife < 42 -> "Meaning of life is too small"
            meaningOfLife > 100 -> "Meaning of life is too big"
            else -> "Close Enough"
        }

    // Test for types in a when clause
    val something: Any = 42
    val someExpression = when (something) {
        is Int -> "It's an integer, may be the meaning of life!"
        is String -> "Its a string, may be not the meaning of life!"
        else -> "Not sure what this can be"
    }

    /**
     * Loops
     * - They are instructions
     */
    // For Loops
    println("inclusive range")
    for (i in 1 .. 10) {
        println(i)
    }

    println("exclusive range v1")
    for (i in 1 ..< 10) {
        println(i)
    }

    println("exclusive range v2")
    for (i in 1 until 10) {
        println(i)
    }

    println("inclusive range, step 2")
    for (i in 1 .. 10 step 2) {
        println(i)
    }

    println("descending range")
    for (i in 10 downTo 1) {
        println(i)
    }

    // arrays
    val anArray = arrayOf(1,2,3,4,5,6,7)
    for (elem in anArray) {
        println(elem)
    }

    // while loops
    var i = 1
    while (i <= 10) {
        println(i)
        i += 1
    }

    // do while loops
    var j = 10
    do {
        println(j)
        j -= 1
    } while (j >= 1)
}