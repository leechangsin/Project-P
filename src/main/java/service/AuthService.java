package service;

import command.AuthInfo;
import command.Member;
import dao.MemberDao;
import exceptions.NotMatchPasswdException;

public class AuthService {

	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public AuthInfo authenticate(String email,String password){
		Member member = memberDao.searchByEmail(email);
		if(member == null){
			throw new NotMatchPasswdException("패스워드가 맞지않습니다.");
		}
		/*
		if(!member.matchPassword(password)){
			throw new NotMatchPasswdException("패스워드가 맞지않습니다.");
		}
		*/
		return new AuthInfo(member.getEmail(),member.getNickname());
	}
	
}
