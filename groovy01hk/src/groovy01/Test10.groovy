package groovy01

//문자열 다루기
println"BIT's lecture"
println'BIT"s lecture'  //중간에 있는 쌍따옴표는 문자처리가 된다
println'BIT\' lecture'
println(/Bit's lecture/) 
/*괄호안에 있는 슬래쉬에 감싸진 요소는 문자열 처리가 된다*/

//멀티라인처리

println """오호라..
정말이네..
헐...
자바에서는 + 연산자를 사용해야하는데
끝내주네...
"""

//포맷팅 문자열 다루기 =>  GString
name = '홍길동'
println "안녕하세요. $name 님 반갑습니다."
println "2 + 3의 결과는 ${2+3} 입니다."  //문자열 중간에  closure 넣기
println "2 + 3dml 결과는 ${println '헐...'; 2+3}입니다."
