package java63.servlets.test05.domain;

public class ProductPhoto {
	protected int 		no;
	protected int		 	productNo;
	protected String 	url;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "ProductPhoto [no=" + no + ", productNo=" + productNo + ", url="
				+ url + "]";
	}
}
