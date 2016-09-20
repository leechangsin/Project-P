package service;

import java.util.List;

import command.Member;
import command.MemberInfo;
import command.ModifyForm;
import command.RequestType;
import dao.MemberDao;
import dao.MemberInfoDao;
import exceptions.AlreadyExistAccountException;
import exceptions.AlreadyExistNicknameException;

public class ModifyService {
	MemberInfoDao memberInfoDao;
	MemberDao memberDao;
	
	public ModifyService(MemberInfoDao memberInfoDao, MemberDao memberDao){
		this.memberInfoDao = memberInfoDao;
		this.memberDao = memberDao;
	}
	
	public MemberInfo selecyByEmail(String email){
		return memberInfoDao.selectByEmail(email);
	}

	public ModifyForm setModifyForm(MemberInfo memberInfo, Member member) {
		// TODO Auto-generated method stub
		
		ModifyForm modifyForm = new ModifyForm();
		modifyForm.setEmail(memberInfo.getEmail());
		modifyForm.setPasswd(memberInfo.getPasswd());
		modifyForm.setReg_date(memberInfo.getReg_date());
		modifyForm.setBirth_date(memberInfo.getBirth_date());
		modifyForm.setSex(memberInfo.getSex());
		modifyForm.setNickname(member.getNickname());
		modifyForm.setIntro(member.getIntro());
		modifyForm.setPicture(member.getPicture());
		
		return modifyForm;
	}

	public boolean comparePasswd(String originalPasswd, String modifyFormPasswd) {
		// TODO Auto-generated method stub
		return originalPasswd.equals(modifyFormPasswd) ? false : true;
	}
	
	public void checkEmail(String email){
		MemberInfo memberInfo = memberInfoDao.selectByEmail(email);
		if(memberInfo != null)
			throw new AlreadyExistAccountException();
	}
	
	public void checkNickName(String nickName){
		List<Member> result = memberDao.selectByNickName(nickName, RequestType.ModifyService);
		Member member =  result.get(0);
		if(member != null)
			throw new AlreadyExistNicknameException();
	}

	public void updateAccount(ModifyForm modifyForm) {
		// TODO Auto-generated method stub
		MemberInfo memberInfo = setMemberInfo(modifyForm);
		Member member = setMember(modifyForm);
		
		memberInfoDao.updateMemberInfo(memberInfo);
		memberDao.updateMember(member);
	}
	
	public MemberInfo setMemberInfo(ModifyForm modifyForm){
		MemberInfo memberInfo = new MemberInfo();
		
		memberInfo.setEmail(modifyForm.getEmail());
		memberInfo.setPasswd(modifyForm.getPasswd());
		memberInfo.setReg_date(modifyForm.getReg_date());
		memberInfo.setBirth_date(modifyForm.getBirth_date());
		memberInfo.setSex(modifyForm.getSex());
		
		return memberInfo;
	}
	
	public Member setMember(ModifyForm modifyForm){
		Member member = new Member();
		
		member.setEmail(modifyForm.getEmail());
		member.setNickname(modifyForm.getNickname());
		member.setIntro(modifyForm.getIntro());
		member.setPicture(modifyForm.getPicture());
		
		return member;
	}
}