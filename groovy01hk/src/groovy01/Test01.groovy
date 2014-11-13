/*클래스만들기
 * 1) class 키워드로 클래스를 정의하지 않으면
 * file명을 클래스 이름으로 사용한다.
 * 
 * 2) 작성된 명령어는 run() 메서드 안에 순서대로 들어간다.
 * 
 * 3) 메서드 선언은 해당 클래스로 복사된다.
 * 
 * 4)maim() 메서드를 자동으로 만든다.
 * 
 * 5)main()에서 run()을 호출한다.
 * 
 * 
 */
package groovy01

a=20
println a
println plus(10,20)
System.out.println(minus(10,20));

def plus(x,y) {
	x + y
}

public int minus(int x, int y) {
	return x - y;
}

println "실행완료"
