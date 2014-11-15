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
package java02.test20.server;

import java.io.Serializable;

public class Member implements Serializable, Cloneable {
  private static final long serialVersionUID = 1L;
  
  protected String uid;
  protected String pwd;
  protected String email;
  protected String name;
  protected String tel;
  protected String fax;
  protected String addr;
  protected String phot;
  protected int ano;
  
  public Member() {}

	public Member(String uid, String pwd, String email, String name, String tel,
			String fax, String addr, String phot, int ano) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.email = email;
		this.name = name;
		this.tel = tel;
		this.fax = fax;
		this.addr = addr;
		this.phot = phot;
		this.ano = ano;
	}

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhot() {
		return phot;
	}
	public void setPhot(String phot) {
		this.phot = phot;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
  public Member clone() throws CloneNotSupportedException {
    return (Member) super.clone();
  }
}













