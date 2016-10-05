package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import command.Contents;

public class ContentsRowMapper implements RowMapper<Contents> {
	@Override
	public Contents mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Contents contents = new Contents();
		contents.setCon_id(rs.getString("con_id"));
		contents.setWriter(rs.getString("writer"));
		contents.setTitle(rs.getString("title"));
		contents.setContent(rs.getString("content"));
		contents.setVidio(rs.getString("vidio"));
		contents.setImage(rs.getString("image"));
		contents.setHit_number(rs.getString("hit_number"));
		contents.setLike_number(rs.getString("like_number"));
		contents.setComment_number(rs.getString("comment_number"));
		contents.setShare_number(rs.getString("share_number"));
		
		return contents;
	}
}