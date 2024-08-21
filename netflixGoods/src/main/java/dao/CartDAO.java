package dao;

import org.apache.ibatis.session.SqlSession;

public class CartDAO {
	

	SqlSession sqlSession;
	
	public CartDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
}
