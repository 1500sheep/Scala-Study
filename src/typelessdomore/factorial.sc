def factorial(i: Int): Long = {
    def fact(i: Int,accumulator: Long): Long = {
        if(i<=1) accumulator
        else fact(i-1,i*accumulator)
    }

    fact(i,1)
}
(0 to 10) foreach(i => println(factorial(i)))
