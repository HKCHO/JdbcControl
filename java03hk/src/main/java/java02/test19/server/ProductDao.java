package java02.test19.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java02.test19.server.util.DBConnectionPool;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ProductDao {
	SqlSessionFactory sqlSessionFactory;  //MyBatis용 sqlSession을 만들어줄 Factory
	DBConnectionPool dbConnectionPool;

	public void setDbConnectionPool(DBConnectionPool dbConnectionPool) {
		this.dbConnectionPool = dbConnectionPool;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public ProductDao() {}ß

	public Product selectOne(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();



		try {
			return sqlSession.selectOne(
					"java02.test19.server.ProductDao.selectOne", //네임스페이스 + SQL문 아이디
					no/*SQL문을 실행할 때 필요한 값 전달.*/);
		} finally {
			sqlSession.close();
		}
	}


	//hard coding되어있어 유지.보수가 불편하다.
	public void update(Product product) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = dbConnectionPool.getConnection();
			stmt = con.prepareStatement(
					"UPDATE PRODUCTS SET PNAME=?,QTY=?,MKNO=? WHERE PNO=?");
			stmt.setString(1, product.getName());
			stmt.setInt(2, product.getQuantity());
			stmt.setInt(3, product.getMakerNo());
			stmt.setInt(4, product.getNo());

			stmt.executeUpdate();

		} catch (Exception ex) {
			throw new RuntimeException(ex);

		} finally {
			try {stmt.close();} catch (Exception ex) {}
			dbConnectionPool.returnConnection(con);
		}
	}

	public void delete(int no) {
		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = dbConnectionPool.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM PRODUCTS"
					+ " WHERE PNO=" + no);

		} catch (Exception ex) {
			throw new RuntimeException(ex);

		} finally {
			try {stmt.close();} catch (Exception ex) {}
			dbConnectionPool.returnConnection(con);
		}
	}

	public List<Product> selectList(int pageNo, int pageSize) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		HashMap<String,Object> paramMap = new HashMap<>();

		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);

		try {
			return sqlSession.selectList(
					"java02.test19.server.ProductDao.selectList", //네임스페이스 + SQL문 아이디
					paramMap/*SQL문을 실행할 때 필요한 값 전달.*/);
		} finally {
			sqlSession.close();
		}
	}


	public void insert(Product product) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.insert(
					"java02.test19.server.ProductDao.insert",product
					);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}


















