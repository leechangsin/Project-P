package service;

import dao.MemberDao;

public class AuthService {
	
	private MemberDao member;
	
	public void setMember(MemberDao member){
		this.member = member;
	}
	
	public boolean authenticate(String email, String Password){
		return false;
	}
	
}
