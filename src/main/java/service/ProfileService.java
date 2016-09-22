package service;

import java.sql.Blob;
import java.util.Map;

import dao.MemberDao;

public class ProfileService {

	MemberDao memberDao;
	public ProfileService(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	
	public Map<String, Object> getProfileImage(String nickname) {
		// TODO Auto-generated method stub
		return memberDao.getMemberImage(nickname);
	}
}