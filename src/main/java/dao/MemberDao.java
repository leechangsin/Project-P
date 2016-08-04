package dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import command.Member;

@Repository
public class MemberDao {
	private SqlSession query;

	public MemberDao(SqlSession query) {
		this.query = query;
	}
	
	public void savePicture(Map<String, Object> hashMap) throws SQLException{
		query.insert("query.savePicture", hashMap);
	}

}