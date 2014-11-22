package java63.assign01.servlets;

import java.io.IOException;
import java.io.InputStream;
import java63.assign01.dao.ProductDao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class LoadProductDao4rf {
	
	String resource;
	InputStream inputStream;
	ProductDao productDao;
	SqlSessionFactory sqlSessionFactory;
	
	public LoadProductDao4rf() {
		this.resource = "java63/assign01/dao/mybatis-config.xml"; 
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		productDao = new ProductDao(sqlSessionFactory);
		
	}
	
	
}
