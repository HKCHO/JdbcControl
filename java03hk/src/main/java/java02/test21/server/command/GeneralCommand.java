package java02.test21.server.command;

import java.io.PrintStream;
import java.util.Map;
import java02.test21.server.ProductDao;
import java02.test21.server.annotation.Command;
import java02.test21.server.annotation.Component;

@Component("common")
public class GeneralCommand {
	ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Command("help")
	public void help(Map<String, Object> params) throws Exception {
		PrintStream out = (PrintStream)params.get("out");
		out.println("list");
		out.println("view 제품번호");
		out.println("add");
		out.println("delete 제품번호");
		out.println("update 제품번호");
		out.println();
	}


}









