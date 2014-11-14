package java02.test20.server;

import java.util.HashMap;
import java.util.Set;
import java02.test20.server.annotation.Component;

import org.reflections.Reflections;

public class ApplicationContext {
	HashMap<String,Object> objPool = new HashMap<>();
	
	public ApplicationContext(String packageName) throws Exception{
		prepareObjects(packageName);
	}
	private void prepareObjects(String packageName) throws Exception{
		Reflections reflections = new Reflections(packageName);
		Set<Class<?>> clazzList = reflections.getTypesAnnotatedWith(Component.class);
		
	}
}
