/* Value Object
 * => Class 문법을 사용하여 사용자 정의 데이터 타입 만들기
 * 
 * 1) Serializable 인터페이스 구현
 *    => SerialVersionUID 스태틱 변수 선언
 * 
 * 2) 인스턴스 변수 선언
 * 
 * 3) setter/getter 생성
 * 
 * 4) 기본 생성자와 파라미터 값을 받는 생성자 선언
 * 
 * 5) equals()/hashCode() 메서드 오버라이딩
 * 
 * 6) toString() 오버라이딩
 */
package java63.assign01.domain;

import java.io.Serializable;

public class Product implements Serializable, Cloneable {
  private static final long serialVersionUID = 1L;
  
  protected int       no;
  protected String    name;
  protected int       quantity;
  protected int       makerNo;
  
  public Product() {}
  
  public Product(int no, String name, int quantity, int makerNo) {
    this.no = no;
    this.name = name;
    this.quantity = quantity;
    this.makerNo = makerNo;
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getQuantity() {
    return quantity;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  public int getMakerNo() {
    return makerNo;
  }
  public void setMakerNo(int makerNo) {
    this.makerNo = makerNo;
  }
  
  
}













