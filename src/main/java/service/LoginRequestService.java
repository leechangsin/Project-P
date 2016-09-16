package service;

import command.MemberInfo;
import dao.MemberInfoDao;
import exceptions.NotFindEmailException;
import exceptions.NotMatchPasswdException;

public class LoginRequestService {
	MemberInfoDao memberInfoDao;
	
	public LoginRequestService(MemberInfoDao memberInfoDao){
		this.memberInfoDao = memberInfoDao;
	}
	
	public void authenticate(String email, String passwd){
		MemberInfo memberInfo = memberInfoDao.selectByEmail(email);
		
		if(memberInfo == null)
			throw new NotFindEmailException();
		else if(!memberInfo.getPasswd().equals(passwd))
			throw new NotMatchPasswdException();
	}//end authenticate(MemberInfoDao memberInfoDao, String email, String password)

}//end class LoginRequestService