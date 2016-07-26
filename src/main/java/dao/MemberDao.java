package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import command.Member;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;

	public MemberDao() {
		// TODO Auto-generated constructor stub
	}
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}// end MemberDao(DataSource dataSource)
	
	public Member searchByName(String name) {
		String sql = "select * from member where nickname = ?";

		List<Member> result = jdbcTemplate.query(sql, new MemberDaoRowMapper(), name);

		return result.isEmpty() ? null : result.get(0);
		
	}// end searchByName(String name)

	public Member searchByEmail(String email) {
		String sql = "select * from member where email = ?";

		List<Member> result = jdbcTemplate.query(sql, new MemberDaoRowMapper(), email);

		return result.isEmpty() ? null : result.get(0);
		
	}// end searchByEmail(String name)
	
}