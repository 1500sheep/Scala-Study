val t = ("Hello",1,2.3)
println("asd : "+t)
println("asd : "+t._1)
println("asd : "+t._2)
println("asd : "+t._3)

val (t1,t2,t3)  = ("World",'!',0x22)
println(t1+", "+t2+", "+t3)
val (t4,t5,t6)  = Tuple3("World",'!',0x22)
println(t4+", "+t5+", "+t6)
