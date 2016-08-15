package service;

import command.MemberInfo;
import dao.MemberInfoDao;
import exceptions.AlreadyExistAccountException;

public class SignUpEmailService {
	private MemberInfoDao memberInfoDao;
	
	public SignUpEmailService(MemberInfoDao memberInfoDao){
		this.memberInfoDao = memberInfoDao;
	}
	
	public void SignUp(MemberInfo memberInfo){
		//회원가입시 입력한 이메일을 가지고 DB에 검색한다.
		MemberInfo existAccount = memberInfoDao.selectByEmail(memberInfo.getEmail());
		if(existAccount != null){//회원가입시 입력한 이메일이 존재한다면 예외발생
			throw new AlreadyExistAccountException(memberInfo.getEmail() + "이 이미 존재합니다.");
		}
		
		
	}

}
