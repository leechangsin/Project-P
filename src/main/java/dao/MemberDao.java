package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import command.Member;
import command.MemberInfo;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;

	public MemberDao() {
		// TODO Auto-generated constructor stub
	}
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}// end MemberDao(DataSource dataSource)
	
	public List<Member> selectAll() {
		String sql = "select * from member";

		List<Member> results = jdbcTemplate.query(sql, new MemberRowMapper());

		return results;
		
	}
	
	public Member searchByName(String name) {
		String sql = "select * from member where nickname = ?";

		List<Member> result = jdbcTemplate.query(sql, new MemberRowMapper(), name);

		return result.isEmpty() ? null : result.get(0);
		
	}// end searchByName(String name)

	public Member searchByEmail(String email) {
		String sql = "select * from member where email = ?";

		List<Member> result = jdbcTemplate.query(sql, new MemberRowMapper(), email);

		return result.isEmpty() ? null : result.get(0);
		
	}// end searchByEmail(String email)
	
}