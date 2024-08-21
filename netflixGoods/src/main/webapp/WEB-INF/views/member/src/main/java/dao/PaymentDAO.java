package dao;

import org.apache.ibatis.session.SqlSession;

public class PaymentDAO {
	

	SqlSession sqlSession;
	
	public PaymentDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
