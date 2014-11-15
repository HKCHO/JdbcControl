package java02.test20.server;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Collection;
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

		Object instance = null;
		Component compAnno = null;
		
		for(Class<?> clazz : clazzList) {
			instance = clazz.newInstance();
			
			compAnno = clazz.getAnnotation(Component.class);
			if (compAnno.value().equals("")){
				objPool.put(clazz.getName(), instance);
			} else {
				objPool.put(compAnno.value(), instance);
			}
			
		}
	}
	
	public void addBean(String key, Object instance){
		objPool.put(key, instance);
	}
	
	public void injectDependency() {
		Method[] methods = null;
		Parameter parameter = null;
		Object dependency = null;
		
		for (Object obj : objPool.values()) {
			methods = obj.getClass().getMethods();
				for (Method m : methods){
					if(m.getName().startsWith("set")) {
						dependency = findDependency(m.getParameterTypes()[0]);
						
					}
				}
		}
	}
	
	private Object findDependency(Class<?> type){
		for(Object obj : objPool.values()){
			if (type.isInstance(obj)){
				return obj;
			}
		}
		return null;
	}
	
	public Collection<Object> gettAllBeans(){
		return objPool.values();
	}
}














