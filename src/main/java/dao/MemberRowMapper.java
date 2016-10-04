package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import command.Member;

public class MemberRowMapper implements RowMapper<Member> {
	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Member member = new Member();
		member.setNickname(rs.getString("nickname"));
		member.setEmail(rs.getString("email"));
		member.setIntro(rs.getString("intro"));
		member.setPicture(rs.getString("picture"));
		
		return member;
	}
}