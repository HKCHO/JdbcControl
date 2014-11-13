Gradle 프로젝트 폴더 구조

src/main/java		Production Java source : 프로그래밍용 자바 소스
src/main/resources		Production resources : 프로그래밍용 자원
src/test/java		Test Java source : 테스트 자바 소스
src/test/resources		Test resources : 테스트 자원  
src/sourceSet/java		Java source for the given source set : 소스셋에 주어진 자바소스 
src/sourceSet/resources		Resources for the given source set : 소스셋에 주어진 자원

build/  =>  

.gradle/  =>  gradle 설정 파일 및 의존 라이브러리 파일

build.gradle/  =>  groovy로 작성된 빌드 설정 파일




[그래들 빌드하기]

1. 그래들 빌드 실행
 1) 컴파일하기
	프로젝트 > 컨텍스트 메뉴 > Run AS > Gradle Build ... 클릭

2.build.gradle설정
  1) java 그래들 플러그인 임포트
  	 apply plugin : 'java'
  	 
[그래들 java 플러그인 명령어]

1.clean
 - build 폴더를 제거한다.
 
2.compileJava
-/src/main/java 소스파일 컴파일
-/build/classes/main 폴더에 클래스 파일 복사

3.compileTestJava
-/src/test/java 소스파일 컴파일
-/build/classes/test 폴더에 클래스 파일 복사

4.processResources
-/src/main/resources폴더의 모든 파일을
	/build/resources/main폴더에 복사한다.

5.processTestResources
-/src/main/resources폴더의 모든 파일을
	/build/resources/test폴더에 복사한다.
	
6.classes
-/compileJava와 processResources 작업을 모두 실행
- 기타 컴파일 관련 작업을 추가

7.jar
-classes 작업을 수행한 후, 클래스 파일과 기타 자원파일을 묶어서 .jar파일로 만든다.

8.build
-모든 작업수행