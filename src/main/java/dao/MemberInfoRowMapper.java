package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import command.MemberInfo;

public class MemberInfoRowMapper implements RowMapper<MemberInfo> {
	@Override
	public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setEmail(rs.getString("email"));
		memberInfo.setPasswd(rs.getString("passwd"));
		memberInfo.setBirth_date(rs.getString("birth_date"));
		memberInfo.setReg_date(rs.getString("reg_date"));
		memberInfo.setSex(rs.getString("sex"));
		return memberInfo;
	}
}