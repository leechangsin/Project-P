package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	private SqlSession query;

	public MemberDao(SqlSession query) {
		this.query = query;
	}

	public void savePicture(Map<String, Object> hashMap) throws SQLException {
		query.insert("query.savePicture", hashMap);
	}

	public Map<String, Object> getPicture() {
		List<Map<String, Object>> result = query.selectList("query.getPicture");
		return result.get(0);
	}

}