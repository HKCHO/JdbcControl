package java63.servlets.test04;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@WebListener
public class ContextLoaderListener implements ServletContextListener {
	static ApplicationContext appCtx;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
      appCtx = new ClassPathXmlApplicationContext(
          new String[]{"java63/servlets/test04/application-context.xml"});
    } catch (Exception e) {
      e.printStackTrace();
    }
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}
}
