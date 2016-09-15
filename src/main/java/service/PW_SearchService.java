package service;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;

import command.Email;
import command.MemberInfo;
import dao.MemberInfoDao;
import exceptions.NotFindEmailException;

public class PW_SearchService {
	MemberInfoDao memberInfoDao;
	JavaMailSender mailSender;
	
	public PW_SearchService(MemberInfoDao memberInfoDao, JavaMailSender mailSender){
		this.memberInfoDao = memberInfoDao;
		this.mailSender = mailSender;
	}
	
	public void selectByEmail(String email){
		MemberInfo result = memberInfoDao.selectByEmail(email);
		if(result == null)
			throw new NotFindEmailException();
	}
	
	public Email setEmail(String email) throws MessagingException{
		Email reciver = new Email();
		reciver.setEmail(email);
		reciver.setSubject("펫시 비밀번호 찾기");
		reciver.setContent("암호 코드는 [" + createCode() + "] 입니다.");
		
		return reciver;
	}
	
	public MimeMessage setMimeMessage(Email reciver) throws MessagingException{
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		mimeMessage.setRecipient(RecipientType.TO , new InternetAddress(reciver.getEmail()));
		mimeMessage.setSubject(reciver.getSubject());
		mimeMessage.setText(reciver.getContent());
		
		return mimeMessage;
	}
	
	public void sendEmail(MimeMessage mimeMessage){
		mailSender.send(mimeMessage);
	}
	
	public String createCode(){
		Random randomCode = new Random();
		String code = String.valueOf(randomCode.nextInt(9));
		
		for(int i=0; i<9; i++)
			code += String.valueOf(randomCode.nextInt(9));
		
		return code; 
	}
}