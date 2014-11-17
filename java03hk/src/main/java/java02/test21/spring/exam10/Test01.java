package java02.test21.spring.exam10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[]{"java02/test21/spring/exam10/application-context.xml"});


		Engine e01 = (Engine)ctx.getBean("e01");
    System.out.println(e01);

    Engine e02 = (Engine)ctx.getBean("e02");
    System.out.println(e02);
    
    Engine e03 = (Engine)ctx.getBean("e03");
    System.out.println(e03);
	}
}
