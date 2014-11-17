package java02.test21.spring.exam12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[]{"java02/test21/spring/exam12/application-context.xml"});
	
		
		Tire t01 = (Tire)ctx.getBean("t01");
		System.out.println(t01);
		Tire t02 = (Tire)ctx.getBean("t02");
		System.out.println(t02);
		
	}
}
