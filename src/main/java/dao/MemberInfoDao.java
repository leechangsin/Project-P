package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import command.MemberInfo;

public class MemberInfoDao {
	private JdbcTemplate jdbcTemplate;

	public MemberInfoDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}// end MemberInfoDao(DataSource dataSource)

	public MemberInfo selectByEmail(String email) {
		String sql = "select * from memberInfo where email = ?";

		List<MemberInfo> result = jdbcTemplate.query(sql, new MemberInfoRowMapper(), email);

		return result.isEmpty() ? null : result.get(0);
	}// end selectByEmail(String email)
	
	public Boolean insert(MemberInfo memberInfo){
		String sql = "insert into memberInfo valuse()";
		return null;
		
	}
	
}// end class MemberInfoDao