package java02.test21.spring.exam13;

/* 스프링 설정
 * => 호출할 생성자 지정하기
 * 
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  @SuppressWarnings({ "unused", "resource" })
  public static void main(String[] args) {
    //Car c = new Car();
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext(
            new String[]{"java02/test21/spring/exam13/application-context.xml"});
    
    Car c01= (Car)ctx.getBean("c01");
    System.out.println(c01);
    
   
    
  }

}


















