package service;

import command.MemberInfo;
import dao.MemberInfoDao;
import exceptions.NotFindEmailException;
import exceptions.NotMatchPasswdException;

public class LoginRequestService {
	
	public static void authenticate(MemberInfoDao memberInfoDao, String email, String passwd){
		MemberInfo memberInfo = memberInfoDao.selectByEmail(email);
		
		if(memberInfo == null)
			throw new NotFindEmailException();
		else if(!memberInfo.getPasswd().equals(passwd))
			throw new NotMatchPasswdException();
	}//end authenticate(MemberInfoDao memberInfoDao, String email, String password)

}//end class LoginRequestService