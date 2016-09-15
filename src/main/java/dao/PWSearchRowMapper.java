package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import command.PWSearch;

public class PWSearchRowMapper implements RowMapper<PWSearch>{

	@Override
	public PWSearch mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		PWSearch pwSearch = new PWSearch();
		pwSearch.setCode(rs.getString("code"));
		pwSearch.setEmail(rs.getString("email"));
		return pwSearch;
	}
}