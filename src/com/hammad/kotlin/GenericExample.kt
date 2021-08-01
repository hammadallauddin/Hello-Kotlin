package com.hammad.kotlin

class GenericExample {

    // T is a type parameter with upper bound Any

    // Explicitly typed code mean define types
    fun <T> defaultUpper() { // default upper bound is Any? -> <T: Any?>
        // Todo
    }

    fun <T: Any> explicitUpperBound() {
        // Todo
    }

    interface Animal
    interface Fuzzy

    fun <T: Fuzzy> getFuzzyAnimal () { // If we have single constrain we will write like this
        // Todo
    }

    fun <T> getFuzzyAnimal2() where T: Animal, T: Fuzzy { // if we have multiple constants we will write it like that
        // Todo
    }

    //////////////////////////////////////////////////////////////////////
    ////////////////////////////TYPE ERASURE /////////////////////////////
    //////////////////////////////////////////////////////////////////////

    // at runtime you can't query type
    fun <T> simpleProg(list: Collection<T>) {
//        if(list is List<Int>) // This will get error because we are getting generic type from caller

        if(list is List<*>) {// this will work
            val unsafe = list as List<Int> // Will succeed at runtime but you can get error later
            val mightCrash = unsafe.first() // can crash
        }
    }


    //////////////////////////////////////////////////////////////////////
    ///////////////////////// IN / OUT Variance //////////////////////////
    //////////////////////////////////////////////////////////////////////

//    if we have in we can't return if we have out we cant get value
    interface InOutExample<T> {
        fun fun1(t: T)
        fun fun2(): T
        fun fun3(t: T): T
    }

    //////////////////////////////////////////////////////////////////////
    ///////////////////////////// Variance ///////////////////////////////
    //////////////////////////////////////////////////////////////////////

    // How Types with same base types but different argument types are related to each other.
    // Foo<A> vs Foo<B>
    // A vs B

    open class One
    open class Two: One()
    open class Three: Two()

    class Both<T> {
        fun both(t: T): T {
            // TODO
        }
    }

    class Producer<out T> {
        fun producer(): T {
            // Todo
        }
    }

    class Consumer<in T> {
        fun consumer(t: T) {
            // Todo
        }
    }

    val var1: Both<Two> = Both<One>()
    val var2: Both<Two> = Both<Two>()  // Invariant
    val var3: Both<Two> = Both<Three>()

    // Covariant: Subtyping is preserved
    // if A is subtype of B Foo<A> is subtype of Foo<B>
    val var4: Producer<Two> = Producer<One>()
    val var5: Producer<Two> = Producer<Two>()  // Covariant
    val var5: Producer<Two> = Producer<Three>()

    // Covariant: Subtyping is inverted
    // if B is subtype of A Foo<A> is subtype of Foo<B> <- here i the reversal
    val var7: Consumer<Two> = Consumer<One>()
    val var8: Consumer<Two> = Consumer<Two>()  // Covariant
    val var9: Consumer<Two> = Consumer<Three>()

    // The above in / out work is to protect us from external work it doest work in constructor
    class GenericClass<in T, out R, S>(contravariant: T, covariant: R, invariant: S) {
        val field1: T = contravariant // coz it need getter
        val field2: R = covariant
        val field3: S = invariant

        var field4: T = contravariant // coz it need getter
        var field5: R = covariant // coz it need setter
        var field6: S = invariant

        // Everything will work if internal fields are private
        private val field11: T = contravariant
        private val field21: R = covariant
        private val field31: S = invariant

        private var field41: T = contravariant
        private var field51: R = covariant
        private var field61: S = invariant
    }

    //////////////////////////////////////////////////////////////////////
    /////////////////////////// Inline ///////////////////////////////////
    //////////////////////////////////////////////////////////////////////

    // It injects the code directly into the calling function we do it for performance

    // if we have
    inline fun foo() {
        println("hwllo world")
    }

    // and have
    fun fun2() {
        foo()
    }

    // then fun2 will become
    fun fun2() {
        println("hwllo world")
    }
}