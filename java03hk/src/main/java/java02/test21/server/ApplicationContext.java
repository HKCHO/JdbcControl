package java02.test21.server;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import java02.test21.server.annotation.Component;

import org.apache.log4j.Logger;
import org.reflections.Reflections;

/* Bean Container
 * 1)빈 생성 관리
 * 2)의존 객체 자동 주입
 * 
 * Log4j
 * =>로그 레벨에 따라 출력을 제어할 수 있다.
 * =>로그 레벨
 * 		1) Trace
 * 		2) Debug
 * 		3) Info
 *    4) Warn
 *    5) Error & Fatal
 *    
 * =>로그 출력 레벨 설정
 * 		1) Trace로 설정하면 Trace 이하 모든 로그들을 출력한다.
 *    2) 만약 Warn 레벨로 설정하면 Warn이하, Error, Fatal 레벨까지도 출력한다.
 *    
 *    
 * => 로그 설정
 * log4j.properties 파일을 참조하라!
 */

public class ApplicationContext {
	
	static Logger log = Logger.getLogger(ApplicationContext.class);
	HashMap<String,Object> objPool = new HashMap<>();

	public ApplicationContext(String packageName) throws Exception{
		prepareObjects(packageName);
	}

	private void prepareObjects(String packageName) throws Exception {
		Reflections reflections = 
				new Reflections(packageName);
		Set<Class<?>> clazzList = 
				reflections.getTypesAnnotatedWith(Component.class);

		Object instance = null;
		Component compAnno = null;

		for(Class<?> clazz : clazzList) {
			instance = clazz.newInstance();

			//클래스 관리자에게서 Component Annotation 정보 얻기.
			compAnno = (Component) clazz.getAnnotation(Component.class);
			if (compAnno.value().equals("")){
				objPool.put(clazz.getName(), instance);
			} else {
				objPool.put(compAnno.value(), instance);
			}

		}
	}
	public void addBean(String key, Object instance) {
		objPool.put(key, instance);
	}
	public void injectDependency() throws Exception {
		Method[] methods = null;
		Parameter parameter = null;
		Object dependency = null;

		//objPool에서 객체를 하나 꺼낸다. 
	  for (Object obj : objPool.values()) {
      log.debug(obj.getClass().getName());
      
      // 그 객체에서 setter 메서드를 꺼낸다.
      methods = obj.getClass().getMethods();
      for (Method m : methods) {
        if (m.getName().startsWith("set")) {
          log.debug("   " + m.getName());
          
          // setter 메서드의 파라미터 타입 알아내기
          //parameter = m.getParameters()[0]; //JDK 1.8 이상
          //System.out.println("      " + parameter.getType().getName());
          
          // setter 메서드의 파라미터 타입과 일치하는 객체를 찾는다.
          //dependency = findDependency(parameter.getType());
          dependency = findDependency(m.getParameterTypes()[0]);
          log.debug("      " + m.getParameterTypes()[0].getName());
          
					if(dependency != null) {
						//setter method를 호출하여 찾은 객체를 주입한다.
						m.invoke(obj, dependency);
					}
				}
			}
		}
	}

	private Object findDependency(Class<?> type) {
		for (Object obj : objPool.values()){
			if (type.isInstance(obj)){
				return obj;
			}
		}
		return null;
	}

	public Collection<Object> getAllBeans(){
		return objPool.values();
	}
}













