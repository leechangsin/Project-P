package service;

import java.util.List;

import command.Member;
import command.MemberInfo;
import command.RequestType;
import dao.MemberDao;
import dao.MemberInfoDao;
import exceptions.AlreadyExistAccountException;
import exceptions.AlreadyExistNicknameException;

public class SignUpEmailService {
	private MemberInfoDao memberInfoDao;
	private MemberDao memberDao;
	
	public SignUpEmailService(MemberInfoDao memberInfoDao, MemberDao memberDao){
		this.memberInfoDao = memberInfoDao;
		this.memberDao = memberDao;
	}
	
	//회원가입시 회원 개인정보 입력단계(step2)에서 입력한 이메일을 가지고 DB에서 검색한다.
	public void checkEmail(String email){
		MemberInfo existAccount = memberInfoDao.selectByEmail(email);
		if(existAccount != null)//이메일이 존재한다면 예외발생
			throw new AlreadyExistAccountException();
	}
	//회원가입시 회원 계정정보 입력단계(step3)에서 입력한 닉네임을 가지고 DB에서 검색한다.
	public void checkNickname(String nickname, RequestType requestType){
		List<Member> existNickname = memberDao.selectByNickName(nickname, requestType);
		if(!existNickname.isEmpty())//닉네임이 존재한다면 예외발생
			throw new AlreadyExistNicknameException();
	}
	
	//회원 개인정보를 DB에 등록
	public void signUpMemberInfo(MemberInfo memberInfo){
		memberInfoDao.insertMemberInfo(memberInfo);
	}
	
	//회원 계정정보를 DB에 등록
	public void signUpMember(Member member){
		memberDao.insertMember(member);
	}
}