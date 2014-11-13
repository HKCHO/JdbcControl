package groovy01

//자바 스크립트의 each() 흉내
scores = ["홍길동",100,90,80]
//메서드 호출할 때 괄호'()'생략할 수 있다.

scores.each({value -> println value})  //중괄호 열고 왼쪽은 파라미터 , 왼쪽은 order
println"\n--------------------"
scores.eachWithIndex {value,index -> println value+","+index}  //groovy에서는 ()를 생략해도 된다.
println"\n--------------------"

//메서드 정의
def plus(x,y){
	x + y //맨 끝의 문장의 실행 결과가 리턴된다.
}

int minus(int x, int y){
	return x - y;
}

println(plus(10,20))   //메서드 호출 시 '()'사용 => 고유문법
println plus(100,200)  //메서드 호출 시 '()'생략 => groovy 기본 문법
result = minus 100, 50  //'()'생략 예제
println result

println"------------------"
//closure 정의하는 방법
multiple = {x,y ->
	println "이것이 클로저다"
	println "오호라! 그렇군!"
	x * y
}

//자바 스크립트로 위의 문장을 표현한다면,
/*multiple = function(x,y) {
	console.log("이것이 클로저다")
	console.log("오호라 그렇군")
	return x * y
}*/

println multiple(30,20)

