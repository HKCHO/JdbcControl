package groovy01

//조건
age = 70
if(age > 18){
	println "성인"
} else {
	println "청소년"
}

//조건 연산자 (조건) ? a : b
println age > 18 ? "성인" : "청소년"

println "-------------------------------"

//switch => 숫자, 문자열, 논리값, 객체도 가능
x = 3.15f
result = ""

switch(x) {
	case "aaa" :
		println "aaa이다"
	case "123" :
			println "123이다"; break
	case [1,20,"홍길동",true, 3.14f] :  //이 중에 한가지 값을 가지고 있으면 실행하라
		println"헐!! 자바에서는 불가능!!"
		break
}
