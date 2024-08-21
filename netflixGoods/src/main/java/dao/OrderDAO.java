package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.OrderVO;

public class OrderDAO {
	

	SqlSession sqlSession;
	
	public OrderDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	//주문 전체 보기
	public List<OrderVO> selectList() {
		List<OrderVO> list4 = sqlSession.selectList("o.order_list");
		return list4; 
	}
		
}
