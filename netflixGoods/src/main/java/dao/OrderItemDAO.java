package dao;

import org.apache.ibatis.session.SqlSession;

public class OrderItemDAO {
	

	SqlSession sqlSession;
	
	public OrderItemDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
}
