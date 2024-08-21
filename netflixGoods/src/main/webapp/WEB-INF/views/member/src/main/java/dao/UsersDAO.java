package dao;

import org.apache.ibatis.session.SqlSession;

public class UsersDAO {
	

	SqlSession sqlSession;
	
	public UsersDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
}
