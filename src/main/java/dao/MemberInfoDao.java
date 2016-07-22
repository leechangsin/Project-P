package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import table.MemberInfo;

public class MemberInfoDao {
	private JdbcTemplate jdbcTemplate;

	public MemberInfoDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}//end MemberInfoDao(DataSource dataSource)
	
	public MemberInfo selectByEmail(String email) {
		List<MemberInfo> results = jdbcTemplate.query("select * from memberInfo where email = ?",
				new RowMapper<MemberInfo>() {
					@Override
					public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						MemberInfo memberInfo = new MemberInfo();
						memberInfo.setEmail(rs.getString("email"));
						memberInfo.setPasswd(rs.getString("password"));
						memberInfo.setBirth_date(rs.getString("birth_date"));
						memberInfo.setReg_date(rs.getString("reg_date"));
						memberInfo.setSex(rs.getString("sex"));
						return memberInfo;
					}//end mapRow(ResultSet rs, int rowNum)
				}, email);
		return results.isEmpty() ? null : results.get(0);
	}//end selectByEmail(String email)
}//end class MemberInfoDao