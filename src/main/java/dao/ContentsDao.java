package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.JdbcTemplate;

import command.Contents;

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

	public Map<String, Object> getPicture() {
		List<Map<String, Object>> result = query.selectList("query.getPicture");
		return result.get(0);
	}

	public Map<String, Object> getVideo() {
		List<Map<String, Object>> result = query.selectList("query.getVideo");
		return result.get(0);
	}
}