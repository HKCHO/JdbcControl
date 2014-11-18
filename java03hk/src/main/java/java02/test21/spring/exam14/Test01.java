package java02.test21.spring.exam14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[]{"java02/test21/spring/exam14/application-context.xml"});
	
		
		Car c01 = (Car)ctx.getBean("car");
		System.out.println(c01);
		
		Engine c02 = (Engine)ctx.getBean("engine");
		System.out.println(c02);
		
	}
}
