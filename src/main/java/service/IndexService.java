package service;

import java.util.List;

import dao.ContentsDao;

public class IndexService {
	private ContentsDao contentsDao;
	
	public IndexService(ContentsDao contentsDao){
		this.contentsDao = contentsDao;
	}

	public List<String> getAllCon_id() {
		// TODO Auto-generated method stub
		return contentsDao.getAllCon_id();
	}

	public List<String> getAllTitle() {
		// TODO Auto-generated method stub
		return contentsDao.getAllTitle();
	}

	public List<String> getAllText() {
		// TODO Auto-generated method stub
		return contentsDao.getAllText();
	}
	
}