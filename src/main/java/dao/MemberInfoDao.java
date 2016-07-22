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

	}
	
	public MemberInfo selectByEmail(String email) {
		List<MemberInfo> results = jdbcTemplate.query("select * from memberInfo where email = ?",
				new RowMapper<MemberInfo>(){
					@Override
					public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						
						return null;
					}
			
		});
		return null;
	}
}