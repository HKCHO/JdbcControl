package java02.test21.spring.exam02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*   Spring 설정
 * 
 */
public class Test01 {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[]{"java02/test21/spring/exam02/application-context.xml"});
		
		
		Car c1 = (Car) ctx.getBean("b01");
		Car c2 = (Car) ctx.getBean("b02");
		Car c3 = (Car) ctx.getBean("b03");
		Car c4 = (Car) ctx.getBean("b04");
		Car c5 = (Car) ctx.getBean("b05");
		
		Car c10 = (Car) ctx.getBean("b10");
		Car c11 = (Car) ctx.getBean("b11");
		Car c12 = (Car) ctx.getBean("b12");
		Car c20 = (Car) ctx.getBean("b20");
		Car c21 = (Car) ctx.getBean("b21");
		Car c22 = (Car) ctx.getBean("b22");
		//Car c6 = (Car) ctx.getBean("b06");    빈을 찾지 못하면 오류 발생
		
		
		//빈을 설정할 때 이름을 지정하지 않으면
		//Package name + Class name + #Index를 이름으로 사용한다.
		//그리고 0번 빈의 별명은 "PackageName + ClassName"이 된다.
		Car c30 = (Car)ctx.getBean("java02.test21.spring.exam02.Car");
		Car c31 = (Car)ctx.getBean("java02.test21.spring.exam02.Car#0");
		
		Car c32 = (Car)ctx.getBean("java02.test21.spring.exam02.Car#1");
		Car c33 = (Car)ctx.getBean("java02.test21.spring.exam02.Car#2");
		//Car c34 = (Car)ctx.getBean("java02.test21.spring.exam02.Car#3");
		
		
		if (c30 == c31){
			System.out.println("c30 == c31");      //c30 == c31 을 출력함.
		}
	}
}
