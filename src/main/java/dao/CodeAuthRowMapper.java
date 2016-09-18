package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import command.CodeAuth;

public class CodeAuthRowMapper implements RowMapper<CodeAuth>{

	@Override
	public CodeAuth mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		CodeAuth codeAuth = new CodeAuth();
		codeAuth.setReciveCode(rs.getString("code"));
		codeAuth.setEmailAddress(rs.getString("email"));
		return codeAuth;
	}
}