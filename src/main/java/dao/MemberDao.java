package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import command.Member;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	private SqlSession query;
	
	public MemberDao(DataSource dataSource, SqlSession query) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.query = query;
	}// end MemberDao(DataSource dataSource)

	public void savePicture(Map<String, Object> hashMap) throws SQLException {
		query.insert("query.savePicture", hashMap);
	}//end savePicture

	public Map<String, Object> getPicture() {
		List<Map<String, Object>> result = query.selectList("query.getPicture");
		return result.get(0);
	}//end getPicture()

	public Map<String, Object> getVideo() {
		List<Map<String, Object>> result = query.selectList("query.getVideo");
		return result.get(0);
	}//end getVideo()

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
	}//end selectAll();

	public List<Member> searchByName(String name) {
		String sql = "select * from member where nickname like concat('%', ? , '%')";

		List<Member> result = jdbcTemplate.query(sql, new MemberRowMapper(), name);

		return result;

	}// end searchByName(String name)
}