package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ProductsVO;

public class ProductsDAO {
	

	SqlSession sqlSession;
	
	public ProductsDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//제품 전체 보기
	public List<ProductsVO> selectList() {
		List<ProductsVO> list2 = sqlSession.selectList("pd.products_list");
		return list2;
	}
	
}
