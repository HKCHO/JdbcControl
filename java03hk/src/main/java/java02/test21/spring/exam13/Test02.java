package java02.test21.spring.exam13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {

  @SuppressWarnings({ "unused", "resource" })
  public static void main(String[] args) {
    //Car c = new Car();
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext(
            new String[]{"java02/test21/spring/exam13/application-context02.xml"});
    
    Car2 c01= (Car2)ctx.getBean("c01");
    System.out.println(c01);
    
    Car3 c02= (Car3)ctx.getBean("c02");
    System.out.println(c02);
    
    Car4 c03= (Car4)ctx.getBean("c03");
    System.out.println(c03);
    
  }

}


















