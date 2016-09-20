package service;

import java.util.Map;

import command.Member;
import command.MemberInfo;
import command.ModifyForm;
import dao.MemberDao;
import dao.MemberInfoDao;

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
}