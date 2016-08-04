package dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao{
	
	private SqlSession query;
	
	public MemberDao(SqlSession query){
		this.query = query;
	}
	
	public void testQuery() throws SQLException{
		query.selectOne("query.test");
	}
	
}