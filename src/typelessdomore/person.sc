class Person(val name:String, var age: Int)
    val p = new Person("강석윤",26)
    println(p.name)
    println(p.age)
    
    p.age = 27

    println(p.name)
    println(p.age)
