package guide.atech.oop

/**
 * rockthejvm -> Object-Oriented Basics
 * rockthejvm -> Mutable Data Structures, Getters, Setters and Constructors
 */
class Person(val firstName: String, val lastName: String, age: Int) { // Primary Constructor
    // prefixing constructor arguments with val / var will make them properties.
    // Else once the Person object is constructed the constructor arguments will go away

    // can define PROPERTIES (DATA = vals, vars) and METHODS (behaviour = functions)

    val fullName = "$firstName $lastName" // <---- fullName is PROPERTY

    fun greet() = // METHOD
        "Hi everyone, my name is $firstName"

    // OVERLOADING
    fun greet(firstName: String) =
        "Hi $firstName, my name is ${this.firstName}, how do you do?"

    // secondary constructor: Must always invoke another constructor
    constructor(firstName: String, lastName: String): this(firstName, lastName, 0)
    constructor(): this("Jane", "Doe")

    // Getter and Setter
    // without backing field
    var favMovie: String
        // no backing field (= no memory zone for this var)
        get() = "Some Movie"
        set(value: String) {

        }

    // with backing field
    var favMovie2: String = "Some Movie"
        // no backing field (= no memory zone for this var)
        get() = field
        set(value: String) {
            field = value
        }

    /*
        Properties with get() and/or set(value) may or may not have backing fields (= memory zones for them).
        Create a backing field simply by using `field` in the implementation of get() or set().
        The compiler detects if you have a backing field or not.
        - if you have a backing field, you MUST initialize the property
        - if you don't have a backing field, you CANNOT initialize the property
     */

    // initialization
    /// 1
    lateinit var favLanguage: String
    fun initializeFavLanguage() {
        if (!this::favLanguage.isInitialized)
            favLanguage = "Kotlin"
    }

    /// 2
    init {
        // run arbitrary code when this class is being instantiated
        println("initializing a Person with the name $firstName $lastName")
    }

    // can run multiple init blocks, they run one after another in the order they're defined in the class
    init {
        println("some other arbitrary code")
    }


}

fun main() {
    val kamran = Person("Kamran", "Ali", 34)
    kamran.fullName

    // Getter and Setter
    println(kamran.favMovie) // calling the get() method on the favMovie property
    kamran.favMovie = "Mission Impossible" // calling the set("Mission Impossible") method on the favMovie property
}