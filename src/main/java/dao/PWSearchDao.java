package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class PWSearchDao {
	private JdbcTemplate jdbcTemplate;

	public PWSearchDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insertCode(String code, String email) {
		String sql = "insert into PWSearch values(?, ?)";
		jdbcTemplate.update(sql, code, email);
	}
}