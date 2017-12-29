## TypeLessDoMore Scala



### 기본 개념



- 스칼라에서는 변수가 불변인지 아닌지 선언 시 지정 가능!
  - val : 변경 불가능 , e.g. val array:Array[String] = new Array(5) <- 이렇게 선언시 초기화 해줘야 한다!
  - var : 변경 가능, 선언할 때 초기화! e.g. var s:Dobule = 2.0 <- 타입은 변경 불가능 하다!

- 범위

  - 증분 값을 표시 : to(끝 값 포함) , until(끝 값 제외), to by ~  e.g. 1 to 10 by 3

- 부분 함수(PartialFunction클래스 이용!)

  - 함수 pf1, pf2일 때 val pf = pf1 orElse pf2 라 하면 "연쇄 호출"이라 하여 pf1과 일치하지 않으면 pf2를 시도하는 것!
  - 부분 함수 안에는 case 절만 들어갈 수 있고 반드시 전체를 중괄호로 묶어야 한다.

- 메서드의 기본 인자와 이름 붙은 인자 

  - copy 메서드 사용하면 케이스 클래스의 기존 인스턴스를 복사하면서 일부 필드를 변경해서 새로운 객체를 만들 수 있다. 
    - e.g. val p2 = p1.copy( y = 6.6)

- *인자 목록이 여럿 있는 메서드 : 함수 리터럴이 더 길어질수록 (...) 대신 {...}을 쓰자!

  - 인자 목록을 하나에 다 때려 박는게 아니라 여럿으로 만들면 마지막 인자 목록을 암시적 인자를 위해 사용할 수 있다. e.g. def m1[A] (a:A,f:A=>String) , def m2[A] (a:A)(f:A=>String) 이런식으로 인자 목록을 여러개로 나누면 마지막 인자 목록이 인자를 추론할 수 있다!

- 내포된 메서드 정의와 재귀(factorial.sc)

  - 아래는 재귀 함수를 구현, 내포된 메서드인 fact의 매개변수 i는 factorial의 매개변수 i를 가린다. 
  - fact 내부에선 바깥쪽 i의 값을 알지 못하게 된다.
  - factorial에 관해 반환 타입을 굳이 안 써줘도 추론한다(다만 값이 커지니 Long으로 한 것!)
  - 그러나 fact의 반환 타입은 **꼭, 반드시!** 명시해야 한다. fact가 재귀적이고, 스칼라의 지역 영역 타입 추론은 재귀 함수의 반환 타입을 추론할 수 없기 때문이다!
  - 재귀 함수위에 *@tailrec* 을 써주면 꼬리 재귀에 의한 컴파일 오류가 나지 않을 것이다(?, 스택 관련 처리 라는데?!)

  > def factorial(i: Int): Long = {
  >
  > ​	def fact(i: Int, accumulator: Long): Long = {
  >
  > ​		if(i<=1) accumulator
  >
  > ​		else fact(i-1, i * accumulator)
  >
  > ​	}
  >
  > ​	fact(i,1)
  >
  > }

  ​	

- 타입 정보 추론

  - 명시적으로 타입을 표기해야 할 때 (다 안적음, 매우 간추려서)

    - 변경 가능한 var나 변경 불가능한 val 선언에서 값을 대입하지 않는 경우
    - 모든 메서드 매개변수
    - 메서드 안에서 return을 명시적으로 호출하는 경우
    - ...

  - 아래 두 함수의 차이는 위의 함수는 반환값을 =을 안 했기 때문에 Unit을 반환한다. 아래 함수는 제대로 동작.

    - > def double(i: Int) { 2* i } 
      >
      > def double(i: Int) = { 2 * i }

- 예약어

  - 종류(Java와 다른 것들, 혹은 내가 잘 모르는 것들) : forSome , implicit(써본적이 없드아) , lazy , match , requires , sealed , trait , with , yield ...

- 리터럴 값

  - 3중 큰따옴표로 둘러싸인 문자열 리터럴은 여러 줄 문자열 리터럴이라고 부른다.

  - 튜플 리터럴 : 메서드에 둘 또는 그 이상의 값을 반환할 때!! : TupleN 클래스 e.g.Tuple3은 원소가 3개인 튜플!

    - > val t = ("123",1,2.3) 

- Option, Some, None : null 사용 피하기... (여기전 까지 함)