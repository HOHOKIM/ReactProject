package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.UsersVO;

public class AdminDAO {

	SqlSession sqlSession;
	
	public AdminDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//사용자 보기
	public List<UsersVO> selectList() {
		List<UsersVO> list = sqlSession.selectList("ad.users_list");
		return list;
	}
	
	
	//사용자 디테일
	public List<UsersVO> selecDetailtList() {
		List<UsersVO> list = sqlSession.selectList("ad.users_detail_list");
		return list;
	}
	
	//검색 결과를 포함한 사용자 디테일 오버로드
	public List<UsersVO> selecDetailtList(Map<String, Object> map) {
		List<UsersVO> list = sqlSession.selectList("ad.users_detail_list_search", map);
		return list;
	}
	
	//사용자 삭제(업데이트로 is_deleted만 바꾸는 기능/ 실제 삭제는 아님)
	public int user_block(int u_idx) {
		int res = sqlSession.delete("ad.user_block",u_idx);
		return res;
	}
	
	//사용자 구분
	public List<UsersVO> user_status(int is_approved) {
		List<UsersVO> res = 
				sqlSession.selectList("ad.user_status", is_approved);
		return res;
	} 
	
	//사용자 검색
	public List<UsersVO> search_user(String search_user){
		Map<String, String> params = new HashMap<String, String>();
	    params.put("search", search_user);
	    return sqlSession.selectList("ad.search_user", params); 
	}
	
	//사용자 수 계산
	public int getRowTotal( Map<String, Object> map ) {
		int count = sqlSession.selectOne("ad.user_count", map);
		return count;
	}
} 