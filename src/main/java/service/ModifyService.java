package service;

import java.util.List;

import command.Member;
import command.MemberInfo;
import command.ModifyStoreForm;
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

	public ModifyStoreForm setModifyStoreForm(MemberInfo memberInfo, Member member) {
		// TODO Auto-generated method stub
		
		ModifyStoreForm modifyStoreForm = new ModifyStoreForm();
		modifyStoreForm.setEmail(memberInfo.getEmail());
		modifyStoreForm.setPasswd(memberInfo.getPasswd());
		modifyStoreForm.setReg_date(memberInfo.getReg_date());
		
		String[] birth_date = memberInfo.getBirth_date().split("-");
		modifyStoreForm.setYear(birth_date[0]);
		modifyStoreForm.setMonth(birth_date[1]);
		modifyStoreForm.setDay(birth_date[2]);
		
		modifyStoreForm.setBirth_date(memberInfo.getBirth_date());
		modifyStoreForm.setSex(memberInfo.getSex());
		modifyStoreForm.setNickname(member.getNickname());
		modifyStoreForm.setIntro(member.getIntro());
		
		return modifyStoreForm;
	}
	
	public boolean compareEmail(String originalEmail, String modifyFormPasswd){
		return originalEmail.equals(modifyFormPasswd) ? false : true;
	}

	public boolean comparePasswd(String originalPasswd, String modifyFormPasswd) {
		// TODO Auto-generated method stub
		return originalPasswd.equals(modifyFormPasswd) ? false : true;
	}
	
	public boolean compareNickname(String originalNickname, String modifyFormNickname){
		return originalNickname.equals(modifyFormNickname) ? false : true;
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

	public void updateAccount(ModifyStoreForm modifyForm, String originalEmail) {
		// TODO Auto-generated method stub
		MemberInfo memberInfo = setMemberInfo(modifyForm);
		Member member = setMember(modifyForm);
		
		memberInfoDao.updateMemberInfo(memberInfo, originalEmail);
		memberDao.updateMember(member);
	}
	
	public MemberInfo setMemberInfo(ModifyStoreForm modifyStoreForm){
		MemberInfo memberInfo = new MemberInfo();
		
		memberInfo.setEmail(modifyStoreForm.getEmail());
		memberInfo.setPasswd(modifyStoreForm.getPasswd());
		memberInfo.setReg_date(modifyStoreForm.getReg_date());
		String birth_date = modifyStoreForm.getYear() + "-" + modifyStoreForm.getMonth() + "-" + modifyStoreForm.getDay();
		memberInfo.setBirth_date(birth_date);
		memberInfo.setSex(modifyStoreForm.getSex());
		
		return memberInfo;
	}
	
	public Member setMember(ModifyStoreForm modifyStoreForm){
		Member member = new Member();
		
		member.setEmail(modifyStoreForm.getEmail());
		member.setNickname(modifyStoreForm.getNickname());
		member.setIntro(modifyStoreForm.getIntro());
		member.setPicture(modifyStoreForm.getPicture());
		
		return member;
	}

	public void deleteAccount(String email) {
		// TODO Auto-generated method stub
		//단 덧글 삭제하기
		//commentDao.deleteAllComment(email);
		//쓴 글 삭제하기
		//contentsDao.deleteAllContents(email);
		memberDao.deleteMember(email);
		memberInfoDao.deleteMemberInfo(email);
		
	}
}