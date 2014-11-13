package groovy01

// 변수선언 
// 1) dynamic type binding
def a = 20   //값을 할당할 때, 타입을 결정한다.
a = "Ohora"
b = "Hahaha"  //def 생략 가능.

println a
println b


println "----------------------"

//2) static type binding
// => 변수를 선언할 때 타입을 지정한다. 변경 불가!

int a2;
char b2;

//a2 = "okok"; //error
//a2 = "20";   //error

a2 = 20;
b2 = 'A';
println a2
println b2

println "----------------------"

String a3;
a3 = "오호라"
println a3
a3 = 200       //숫자를 문자열로 자동 형변환 한다.
println a3

println "----------------------"

java.util.Date today = new java.util.Date()
println today

println "----------------------"

//java.util 패키지는 자동으로 임포트 했기 때문에
//굳이 패키지명을 지정하지 않아도 된다.binding

Date today2 = new Date();
println today2

println "----------------------"