package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

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
	
	//회원가입
	public Boolean insertMemberInfo(final MemberInfo memberInfo){
		final String sql = "insert into memberInfo values(?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pstmt = arg0.prepareStatement(sql);
				pstmt.setString(1, memberInfo.getEmail());
				pstmt.setString(2, memberInfo.getPasswd());
				pstmt.setString(3, memberInfo.getReg_date());
				pstmt.setString(4, memberInfo.getBirth_date());
				pstmt.setString(5, memberInfo.getSex());
				return pstmt;
			}
		});

		return true;
		
	}
	
}// end class MemberInfoDao