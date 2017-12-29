def hello(name: String) = s"""Welcome!
    Hello, $name!
    * *(Gratuitous Start!!)
    |We're glad you're here.
    |   Have some extra whilespace.""".stripMargin

 hello("Programming Scala")
