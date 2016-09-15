package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import command.PWSearch;

public class PWSearchDao {
	private JdbcTemplate jdbcTemplate;

	public PWSearchDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insertCode(String code, String email) {
		String sql = "insert into PWSearch values(?, ?)";
		jdbcTemplate.update(sql, code, email);
	}
	
	public PWSearch selectByCode(String code){
		String sql = "select * from PWSearch where code=?";
		return jdbcTemplate.queryForObject(sql, new PWSearchRowMapper(), code);
	}
}