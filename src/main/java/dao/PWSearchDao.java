package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import command.CodeAuth;

public class PWSearchDao {
	private JdbcTemplate jdbcTemplate;

	public PWSearchDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insertCode(String code, String email) {
		String sql = "insert into PWSearch values(?, ?)";
		jdbcTemplate.update(sql, code, email);
	}
	
	public CodeAuth selectByCode(String code){
		String sql = "select * from PWSearch where code=?";
		return jdbcTemplate.queryForObject(sql, new CodeAuthRowMapper(), code);
	}
	
	public void deleteCode(String email){
		String sql = "delete from PWSearch where email=?";
		jdbcTemplate.update(sql, email);
	}
}