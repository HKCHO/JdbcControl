package java02.test20.server;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MemberDao {
	SqlSessionFactory sqlSessionFactory;  //MyBatis용 sqlSession을 만들어줄 Factory

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public MemberDao() {}

	public Member selectOne(String uid) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectOne(
					//네임스페이스 + SQL문 아이디 , SQL문을 실행할 때 필요한 값.
					"java02.test20.server.MemberDao.selectOne", uid);
		} finally {
			sqlSession.close();
		}
	}

	//hard coding되어있어 유지,보수가 불편하다.
	public void update(Member member) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.update(
					"java02.test20.server.MemberDao.update",member
					);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void delete(String uid) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.delete(
					"java02.test20.server.MemberDao.delete", uid
					);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public List<Member> selectList(int pageNo, int pageSize) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		HashMap<String,Object> paramMap = new HashMap<>();

		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);

		try {
			return sqlSession.selectList(
					"java02.test20.server.MemberDao.selectList", paramMap);
		} finally {
			sqlSession.close();
		}
	}


	public void insert(Member member) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.insert(
					"java02.test20.server.MemberDao.insert",member
					);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}


















