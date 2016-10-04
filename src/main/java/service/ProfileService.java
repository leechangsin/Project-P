package service;

import java.util.Map;

import command.MemberInfo;
import dao.MemberDao;
import dao.MemberInfoDao;

public class ProfileService {

	MemberDao memberDao;
	MemberInfoDao memberInfoDao;
	public ProfileService(MemberDao memberDao, MemberInfoDao memberInfoDao){
		this.memberDao = memberDao;
		this.memberInfoDao = memberInfoDao;
	}
	
	public MemberInfo selectByEmail(String email){
		return memberInfoDao.selectByEmail(email);
	}
	
	public Map<String, Object> getProfileImage(String nickname) {
		// TODO Auto-generated method stub
		return memberDao.getMemberImage(nickname);
	}
}