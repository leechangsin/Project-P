package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import command.Contents;

public class ContentsRowMapper implements RowMapper<Contents> {
	@Override
	public Contents mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Contents contents = new Contents(rs.getString("writer"), rs.getString("identification"),
									rs.getString("title"), rs.getString("content"),
									rs.getString("vidio"), rs.getString("picture"),
									rs.getString("hit_number"), rs.getString("like_number"),
									rs.getString("comment_number"), rs.getString("share_number"),
									rs.getString("reg_date"), rs.getString("summary"));
		return contents;
	}	
}