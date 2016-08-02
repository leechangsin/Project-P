package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import javax.sql.DataSource;
import command.Contents;

public class ContentsDao {

	private JdbcTemplate jdbcTemplate;
	
	public ContentsDao(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Contents> selectAll(){
		String sql = "select * from contents";
		
		List<Contents> results = jdbcTemplate.query(sql, new ContentsRowMapper());
		return results;
	}
	
	public List<Contents> selectByTitle(String title){
		String sql = "select * from contents where title like concat('%', ? , '%')";
		
		List<Contents> results = jdbcTemplate.query(sql, new ContentsRowMapper(),title);
		return results;
	}
	
}
