package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import command.MemberInfo;

public class MemberInfoDao {
	private JdbcTemplate jdbcTemplate;

	public MemberInfoDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public MemberInfo selectByEmail(String email) {
		String sql = "select * from memberInfo where email = ?";

		List<MemberInfo> result = jdbcTemplate.query(sql, new MemberInfoRowMapper(), email);

		return result.isEmpty() ? null : result.get(0);
	}// end selectByEmail(String email)
	
	//개인정보를 가지고 회원가입하는 쿼리문
	public void insertMemberInfo(MemberInfo memberInfo){
		String sql = "insert into memberInfo values(?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, memberInfo.getEmail(), memberInfo.getPasswd(), memberInfo.getReg_date(), memberInfo.getBirth_date(), memberInfo.getSex());
	}//end insertMemberInfo(final MemberInfo memberInfo)
	
	public void updatePasswd(String email, String passwd){
		String sql = "update memberInfo set passwd=? where email=?";
		//update는 변경된 행의 개수를 리턴
		jdbcTemplate.update(sql, passwd, email);
	}

	public void updateMemberInfo(MemberInfo memberInfo, String originalEmail) {
		// TODO Auto-generated method stub
		String sql = "update memberInfo set email=?, passwd=?, birth_date=?, sex=? where email=?";
		jdbcTemplate.update(sql, memberInfo.getEmail(), memberInfo.getPasswd(), memberInfo.getBirth_date(), memberInfo.getSex(), originalEmail);
	}

	public void deleteMemberInfo(String email) {
		// TODO Auto-generated method stub
		String sql = "delete from memberInfo where email=?";
		jdbcTemplate.update(sql, email);
	}
}// end class MemberInfoDao