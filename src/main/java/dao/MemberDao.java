package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

import command.Member;
import command.RequestType;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	private SqlSession query;
	
	public MemberDao(DataSource dataSource, SqlSession query) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.query = query;
	}

	public void savePicture(Map<String, Object> hashMap) throws SQLException {
		query.insert("query.savePicture", hashMap);
	}

	public Map<String, Object> getPicture() {
		List<Map<String, Object>> result = query.selectList("query.getPicture");
		return result.get(0);
	}

	public Map<String, Object> getVideo() {
		List<Map<String, Object>> result = query.selectList("query.getVideo");
		return result.get(0);
	}

	/*
	 * 미구현 메서드 
	 * public String getText(){ 
	 * 		String result = query.selectOne("query.getText"); 
	 * 		return result;  
	 * }
	 */

	public List<Member> selectAll() {
		String sql = "select * from member";

		List<Member> results = jdbcTemplate.query(sql, new MemberRowMapper());
		// 만약에query 로 받으면 List 로 받는것으로..
		return results;
	}

	/*
	 * DB에서 nickname을 검색
	 * requestType은 어느 컨트롤러의 리퀘스트매핑에서 요청을 했는지 구분하기 위한 열거형 매개변수
	 */
	public List<Member> selectByNickName(String nickName, RequestType requestType) {
		String sql = null;
		//SearchUI_Member_Controller의 @RequestMapping("/search/members")에서 요청했다면
		if(requestType == RequestType.Search_Members)
			sql = "select * from member where nickname like concat('%', ? , '%')";
		//RegistUI_Controller의 @RequestMapping("SignUpEmail/step4")에서 요청했다면
		else if(requestType == RequestType.signUpMember)
			sql = "select email from member where nickname = ?";

		List<Member> results = jdbcTemplate.query(sql, new MemberRowMapper(), nickName);

		return results;
	}
}