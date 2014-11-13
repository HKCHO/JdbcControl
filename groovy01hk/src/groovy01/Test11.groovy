package groovy01

def m01 (x) {
	println x
}

//m01("홍길동")  //그래들은 뒤의 ;를 생략할 수 있다.
//m01 "홍길동"

def m02(map){
	println map.name
	println map.age
}

//m02(["name" : "홍길동", "age" : 20])
//m02 "name" : "홍길동", "age" : 20  //맵 객체를 던질 때에는 괄호 생략이 가능

m02 "name":"오호라"

def apply(map){
	println map.plugin
}

//apply (['plugin':'java'])
//apply 'plugin' : 'java'
apply plugin : 'java'

def jar(closure) {
	closure()
}

//jar({println 'okok'})  아래처럼 줄일 수 있다.
jar {
	println 'okok'
}