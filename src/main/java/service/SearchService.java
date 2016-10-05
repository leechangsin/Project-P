package service;

import java.util.List;
import java.util.Map;

import command.Contents;
import command.Member;
import command.RequestType;
import dao.ContentsDao;
import dao.MemberDao;

public class SearchService {
	private MemberDao memberDao;
	private ContentsDao contentsDao;
	
	public SearchService(MemberDao memberDao, ContentsDao contentsDao){
		this.memberDao = memberDao;
		this.contentsDao = contentsDao;
	}

	public List<Member> selecyByNickname(String keyword) {
		// TODO Auto-generated method stub
		return memberDao.selectByNickName(keyword, RequestType.Search_Members);
	}

	public List<Contents> selecyByTitle(String keyword) {
		// TODO Auto-generated method stub
		return contentsDao.selectByTitle(keyword);
	}

	public Map<String, Object> getMemberImage(String nickname) {
		// TODO Auto-generated method stub
		return memberDao.getMemberImage(nickname);
	}
	
	

}
