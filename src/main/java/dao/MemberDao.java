package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import command.Member;
import command.MemberInfo;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
		
	}
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}// end MemberDao(DataSource dataSource)
	

	
	public List<Member> selectAll() {
		String sql = "select * from member";

		List<Member> results = jdbcTemplate.query(sql, new MemberRowMapper());
		// 만약에query 로 받으면 List 로 받는것으로.. 
		return results;
		
	}
	
	public List<Member> searchByName(String name) {
		String sql = "select * from member where nickname like '%?%'";

		List<Member> result = jdbcTemplate.query(sql, new MemberRowMapper(), name);

		return result;
		
	}// end searchByName(String name)
	
	
}