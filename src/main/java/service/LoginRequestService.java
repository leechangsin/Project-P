package service;

import dao.MemberInfoDao;
import exceptions.NotFindEmailException;
import exceptions.NotMatchPasswordException;
import table.MemberInfo;

public class LoginRequestService {
	
	public static void authenticate(MemberInfoDao memberInfoDao, String email, String password){
		MemberInfo memberInfo = memberInfoDao.selectByEmail(email);
		
		if(memberInfo == null)
			throw new NotFindEmailException("존재하지 않는 email입니다.");
		else if(memberInfo.getPasswd().equals(password))
			throw new NotMatchPasswordException("아이디 또는 비밀번호가 일치하지 않습니다.");
	}//end authenticate(MemberInfoDao memberInfoDao, String email, String password)

}//end class LoginRequestService