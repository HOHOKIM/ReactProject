package dao;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.ProductDAO;
import vo.ProductVO;

@Repository

public class ProductDAO {
	
	@Autowired
	SqlSession sqlSession;

	public ProductDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<ProductVO> s_selectList() {
		List<ProductVO> list = sqlSession.selectList("p.product_list");
//		System.out.println(list);
		return list;
	}

	public int insert(ProductVO vo) {
		System.out.println(vo.getP_idx());
		System.out.println(vo.getName());
		System.out.println(vo.getDescription());
		System.out.println(vo.getPrice());
		System.out.println(vo.getStock());
		System.out.println(vo.getCategory());
		System.out.println(vo.getIs_sellable());
		System.out.println(vo.getRegistered_at());
		System.out.println(vo.getFilename());
		System.out.println(vo.getPhoto());	
		int res = sqlSession.insert("p.product_insert", vo);
		return res;
	}

	public int delete(int P_IDX) {
		int res = sqlSession.delete("p.product_delete", P_IDX);
		return res;
	}

	public ProductVO selectone(int P_IDX) {
		ProductVO vo = sqlSession.selectOne("p.product_selectone", P_IDX);
		return vo;
	}

	public int update(Map<String, Object> map) {
		int res = sqlSession.update("p.product_update", map);
		return res;
	}

}
