package service;

import command.Member;
import command.MemberInfo;
import command.RequestType;
import dao.MemberInfoDao;
import exceptions.AlreadyExistAccountException;

public class SignUpEmailService {
	private MemberInfoDao memberInfoDao;
	
	public SignUpEmailService(MemberInfoDao memberInfoDao){
		this.memberInfoDao = memberInfoDao;
	}
	
	//회원 개인정보를 DB에 등록
	public void signUpMemberInfo(MemberInfo memberInfo){
		//회원가입시 입력한 이메일을 가지고 DB에 검색한다.
		MemberInfo existAccount = memberInfoDao.selectByEmail(memberInfo.getEmail());
		if(existAccount != null){//회원가입시 입력한 이메일이 존재한다면 예외발생
			throw new AlreadyExistAccountException(memberInfo.getEmail() + "이 이미 존재합니다.");
		}
	}
	
	//회원 계정정보를 DB에 등록
	public void signUpMember(Member meber, RequestType requestType){
		Member existNickname = null;
	}
}