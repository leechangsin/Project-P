package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import command.Member;
import command.RequestType;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Member> selectAll() {
		String sql = "select * from member";

		List<Member> results = jdbcTemplate.query(sql, new MemberRowMapper());
		// 만약에query 로 받으면 List 로 받는것으로..
		return results;
	}

	/*
	 * DB에서 nickname을 검색
	 * requestType은 어느 컨트롤러의 리퀘스트매핑에서 요청을 했는지 구분하기 위한 열거형 매개변수
	 */
	/*반환유형이 List인 이유는 SearchUI_Member_Controller에서 List<Member>형이 필요하기 때문*/
	public List<Member> selectByNickName(String nickName, RequestType requestType) {
		String sql = null;
		//SearchUI_Member_Controller의 @RequestMapping("/search/members")에서 요청했다면
		if(requestType == RequestType.Search_Members)
			sql = "select * from member where nickname like concat('%', ? , '%')";
		//RegistUI_Controller의 @RequestMapping("SignUpEmail/step4")에서 요청했다면
		else if(requestType == RequestType.signUpMember)
			sql = "select nickname from member where nickname = ?";

		List<Member> results = jdbcTemplate.query(sql, new MemberRowMapper(), nickName);

		return results;
	}//end selectByNickName(String nickName, RequestType requestType)
	
	// 개인정보를 가지고 회원가입하는 쿼리문
	public Boolean insertMember(final Member member) {
		final String sql = "insert into member values(?, ?, ?, ?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pstmt = arg0.prepareStatement(sql);
				pstmt.setString(1, member.getNickname());
				pstmt.setString(2, member.getEmail());
				pstmt.setString(3, member.getIntro());
				pstmt.setObject(4, member.getPicture());
				return pstmt;
			}
		});

		return true;
	}// end insertMember(final Member member)
}