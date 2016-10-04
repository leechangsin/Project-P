package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import command.Contents;
import command.WriteForm;

public class ContentsDao {
	private JdbcTemplate jdbcTemplate;
	private SqlSession query;

	public ContentsDao(DataSource dataSource, SqlSession query) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.query = query;
	}
	
	public List<Contents> selectByTitle(String title) {
		String sql = "select * from contents where title like concat('%', ? , '%')";

		List<Contents> results = jdbcTemplate.query(sql, new ContentsRowMapper(), title);
		return results;
	}

	public void savePicture(Map<String, Object> hashMap) throws SQLException {
		query.insert("query.savePicture", hashMap);
	}

	public String selectMaxCon_id() {
		// TODO Auto-generated method stub
		String sql = "select max(con_id) from contents";
		String result = jdbcTemplate.queryForObject(sql, String.class);
		return result;
	}

	public void insertContets(WriteForm writeForm) {
		// TODO Auto-generated method stub
		String sql = "insert into contents(con_id, writer, title, text, video, image, type) values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, writeForm.getCon_id(), writeForm.getWriter(), writeForm.getTitle(), 
				writeForm.getContent(), writeForm.getVideo(), writeForm.getImage(),writeForm.getType());
	}
	
	public Map<String, Object> getContentsImage(String con_id){
		List<Map<String, Object>> result = query.selectList("query.getContentsImage", con_id);
		return result.get(0);
	}
	
	public Map<String, Object> getContentsVideo(String con_id){
		List<Map<String, Object>> result = query.selectList("query.getContentsVideo", con_id);
		return result.get(0);
	}

	public List<String> getCon_ids(String nickname) {
		// TODO Auto-generated method stub
		String sql = "select con_id from contents where writer=?";
		List<String> result = jdbcTemplate.query(sql, new RowMapper<String>(){
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getString("con_id");
			}
			
		}, nickname);
		
		return result;
	}

	public List<String> getTypes(String nickname) {
		// TODO Auto-generated method stub
		String sql = "select type from contents where writer=?";
		List<String> result = jdbcTemplate.query(sql, new RowMapper<String>(){
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getString("type");
			}
		}, nickname);
		
		return result;
	}

	public List<String> getTitles(String nickname) {
		// TODO Auto-generated method stub
		String sql = "select title from contents where writer=?";
		List<String> result = jdbcTemplate.query(sql, new RowMapper<String>(){
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getString("title");
			}
		}, nickname);
		
		return result;
	}

	public List<String> getTexts(String nickname) {
		// TODO Auto-generated method stub
		String sql = "select text from contents where writer=?";
		List<String> result = jdbcTemplate.query(sql, new RowMapper<String>(){
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getString("text");
			}
		}, nickname);

		return result;
	}

	public List<String> getAllCon_id() {
		// TODO Auto-generated method stub
		String sql = "select con_id from contents";
		List<String> result = jdbcTemplate.query(sql, new RowMapper<String>(){
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getString("con_id");
			}
			
		});
		
		return result;
	}

	public List<String> getAllTitle() {
		// TODO Auto-generated method stub
		String sql = "select title from contents";
		List<String> result = jdbcTemplate.query(sql, new RowMapper<String>(){
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getString("title");
			}
		});
		
		return result;
	}

	public List<String> getAllText() {
		// TODO Auto-generated method stub
		String sql = "select text from contents";
		List<String> result = jdbcTemplate.query(sql, new RowMapper<String>(){
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getString("text");
			}
			
		});
		
		return result;
	}
}