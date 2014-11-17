package java02.test21.spring.exam13;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class MyAppPropertyEditorRegistrar 
  implements PropertyEditorRegistrar{
  CustomDateEditor customDateEditor;
  
  public void setCustomDateEditor(CustomDateEditor customDateEditor) {
    this.customDateEditor = customDateEditor;
  }

  /* 문자열을 특정 타입의 프로퍼티 값으로 변환해줄 커스텀 에디터를 등록하기 위해
   * 스프링 프레임워크가 호출하는 메서드
   */
  @Override
  public void registerCustomEditors(PropertyEditorRegistry registry) {
    // 만약 문자열을 java.util.Date 타입의 값으로 변환한다면,
    // customDateEidtor를 사용하라!
    registry.registerCustomEditor(java.util.Date.class, 
        customDateEditor);
  }
}




















