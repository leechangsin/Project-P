package service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import command.Member;
import command.WriteForm;
import dao.ContentsDao;

public class WriteService {
	ContentsDao contentsDao;
	
	public WriteService(ContentsDao contentsDao){
		this.contentsDao = contentsDao;
	}
	
	public void insertContets(WriteForm writeForm){
		contentsDao.insertContets(writeForm);
	}
	
	public String generatCont_id(){
		Calendar calendar = Calendar.getInstance();
		int nowYear = calendar.get(Calendar.YEAR);
		int nowMonth = calendar.get(Calendar.MONTH);
		int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
		
		String recentUploadNum = contentsDao.selectMaxCon_id();
		String tmpString = recentUploadNum.substring(8, 4);
		int tmpInteger = Integer.parseInt(tmpString) + 1;
		int jarisu = tmpInteger / 10;
		String uploadNum = null;
		switch(jarisu){
			case 0 : uploadNum = String.valueOf(tmpInteger) + "000000";
			case 1 : uploadNum = String.valueOf(tmpInteger) + "00000";
			case 2 : uploadNum = String.valueOf(tmpInteger) + "0000";
			case 3 : uploadNum = String.valueOf(tmpInteger) + "000";
			case 4 : uploadNum = String.valueOf(tmpInteger) + "00";
			case 5 : uploadNum = String.valueOf(tmpInteger) + "0";
			case 6 : uploadNum = String.valueOf(tmpInteger);
		}
		
		return String.valueOf(nowYear) + String.valueOf(nowMonth) + String.valueOf(nowDay) + uploadNum;
	}

	public WriteForm setWriteForm(HttpServletRequest request, HttpSession session) {
		// TODO Auto-generated method stub
		String con_id = generatCont_id();
		Member member = (Member)session.getAttribute("member");
		String writer = member.getNickname();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Date toDay = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String reg_date = sdf.format(toDay);
		
		WriteForm writeForm = new WriteForm();
		writeForm.setCon_id(con_id);
		writeForm.setWriter(writer);
		writeForm.setTitle(title);
		writeForm.setContent(content);
		writeForm.setReg_date(reg_date);
		
		return writeForm;
	}

}
