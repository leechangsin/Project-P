package service;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;

import command.EmailForm;
import command.MemberInfo;
import dao.MemberInfoDao;
import dao.PWSearchDao;
import exceptions.NotFindEmailException;

public class PW_SearchService {
	private MemberInfoDao memberInfoDao;
	private PWSearchDao pwSearchDao;
	private JavaMailSender mailSender;
	
	public PW_SearchService(MemberInfoDao memberInfoDao, PWSearchDao pwSearchDao ,JavaMailSender mailSender){
		this.memberInfoDao = memberInfoDao;
		this.pwSearchDao = pwSearchDao;
		this.mailSender = mailSender;
	}
	
	public void selectByEmail(String email){
		MemberInfo result = memberInfoDao.selectByEmail(email);
		if(result == null)
			throw new NotFindEmailException();
	}
	
	public EmailForm setEmail(String email) throws MessagingException{
		EmailForm reciver = new EmailForm();
		reciver.setEmailAddress(email);
		reciver.setSubject("펫시 비밀번호 찾기");
		
		String code = createCode();
		reciver.setContent("암호 코드는 [" + code + "] 입니다.");
		pwSearchDao.insertCode(code, email);
		return reciver;
	}
	
	public MimeMessage setMimeMessage(EmailForm reciver) throws MessagingException{
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		mimeMessage.setRecipient(RecipientType.TO , new InternetAddress(reciver.getEmailAddress()));
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