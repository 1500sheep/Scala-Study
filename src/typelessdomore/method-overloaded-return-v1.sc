object StringUtilV1{
    def joiner(strings: String*): String = strings.mkString("-")

    // 위의 함수를 overriding한 함수, : String을 명시적으로 써줘야 한다!
    // strings:_*는 컴파일러에 주는 힌트, strings라는 리스트를 가변 인자 목록으로 다루되,
    // 타입은 알 수 없지만 추론한 타입(:_)을 사용하라는 뜻, 왜 이러는거임? 후, 추론 언어구나
    def joiner(strings: List[String]): String = joiner(strings :_*)
}
println( StringUtilV1.joiner(List("Programming","Scala")))
