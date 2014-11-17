package java02.test21.spring.exam03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[]{"java02/test21/spring/exam03/application-context.xml"});


		Car c1 = (Car)ctx.getBean("b01");
		Car c2 = (Car)ctx.getBean("b02");
		Car c3 = (Car)ctx.getBean("b03");
		Car c4 = (Car)ctx.getBean("b04");
		Car c5 = (Car)ctx.getBean("b05");
		
		
		System.out.println(c1.getModel());
		System.out.println(c2.getModel());
		System.out.println(c3.getModel());
		System.out.println(c4.getModel());
		System.out.print(c5.getModel() + ", ");
		System.out.println(c5.getCc());
	}
	
}
