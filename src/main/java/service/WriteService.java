package service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import command.Member;
import command.WriteForm;
import controller.FileVo;
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
		String uploadNum = null;
		
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String nowYear = String.valueOf(year);
		String nowMonth = String.valueOf(month);
		if(nowMonth.length() == 1)
			nowMonth = "0" + nowMonth;
		String nowDay = String.valueOf(day);
		if(nowDay.length() == 1)
			nowDay = "0" + nowDay;
		//현재날짜의 완전한 값
		String complateNowDate = nowYear + nowMonth + nowDay;
		//Contents테이블에 저장된 가장 최근에 업로드된 컨텐츠의 id를 얻어온다.
		String maxCon_id = contentsDao.selectMaxCon_id();
		//가장 최근에 업로드된 컨텐츠의 날짜값을 얻어온다.
		String maxCon_id_date = maxCon_id.substring(0,8);
		String maxCon_id_year = maxCon_id_date.substring(0, 4);
		String maxCon_id_month = maxCon_id_date.substring(4,6);
		String maxCon_id_day = maxCon_id_date.substring(6, 8);
		//가장 최근에 업로드된 컨텐츠의 완전한 날짜값
		String complateMaxCon_id_date = maxCon_id_year + maxCon_id_month + maxCon_id_day;
		//현재 날짜와 가장 최근에 업로드된 컨텐츠의 날짜값을 비교
		if(complateNowDate.equals(complateMaxCon_id_date)){
			String tmpString = maxCon_id.substring(8, 15);
			int tmpInteger = Integer.parseInt(tmpString) + 1;
			int jarisu = tmpInteger / 10;
			switch (jarisu) {
			case 0: uploadNum = "000000" + String.valueOf(tmpInteger); break;
			case 1: uploadNum = "00000" + String.valueOf(tmpInteger); break;
			case 2: uploadNum = "0000" + String.valueOf(tmpInteger); break;
			case 3: uploadNum = "000" + String.valueOf(tmpInteger); break;
			case 4: uploadNum = "00" + String.valueOf(tmpInteger); break;
			case 5: uploadNum = "0" + String.valueOf(tmpInteger); break;
			case 6: uploadNum = String.valueOf(tmpInteger);
			}//end switch (jarisu)
		} else{
			uploadNum = "0000001";
		}
		
		return complateNowDate + uploadNum;
	}

	public void setWriteForm(WriteForm writeForm, HttpServletRequest request, HttpSession session, FileVo filevo) {
		// TODO Auto-generated method stub
		String con_id = generatCont_id();
		
		Member member = (Member)session.getAttribute("member");
		String writer = member.getNickname();
		
		Date toDay = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String reg_date = sdf.format(toDay);
		
		writeForm.setCon_id(con_id);
		writeForm.setWriter(writer);
		writeForm.setReg_date(reg_date);
		
	}
}