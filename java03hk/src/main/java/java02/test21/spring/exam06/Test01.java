package java02.test21.spring.exam06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[]{"java02/test21/spring/exam06/application-context.xml"});


		Car c1 = (Car)ctx.getBean("b01");
    System.out.println(c1);
    
    Car c2 = (Car)ctx.getBean("b02");
    System.out.println(c2);
    
    Car c3 = (Car)ctx.getBean("b03");
    System.out.println(c3);
    
    if (c1.getEngine() == c2.getEngine()) 
      System.out.println("c1의 엔진과 c2의 엔진이 같다!");
    
    if (c1.getEngine() == c3.getEngine()) 
      System.out.println("c1의 엔진과 c3의 엔진이 같다!");
    
    Car c4 = (Car)ctx.getBean("b04");
    System.out.println(c4);
    
    Car c5 = (Car)ctx.getBean("b05");
    System.out.println(c5);
		
	}
}
