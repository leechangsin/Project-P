package service;

import command.Member;
import command.MemberInfo;
import dao.MemberDao;
import dao.MemberInfoDao;
import exceptions.NotFindEmailException;
import exceptions.NotMatchPasswdException;

public class LoginRequestService {
	private MemberInfoDao memberInfoDao;
	private MemberDao memberDao;
	
	public LoginRequestService(MemberInfoDao memberInfoDao, MemberDao memberDao){
		this.memberInfoDao = memberInfoDao;
		this.memberDao = memberDao;
	}
	
	public void emailAuthenticate(String email, String passwd){
		MemberInfo memberInfo = memberInfoDao.selectByEmail(email);
		
		if(memberInfo == null)
			throw new NotFindEmailException("존재하지 않는 email입니다.");
		else if(!memberInfo.getPasswd().equals(passwd))
			throw new NotMatchPasswdException("아이디 또는 비밀번호가 일치하지 않습니다.");
	}//end authenticate(MemberInfoDao memberInfoDao, String email, String password)

	public Member selectByEmail(String email) {
		// TODO Auto-generated method stub
		return memberDao.selectByEmail(email);
	}

}//end class LoginRequestService