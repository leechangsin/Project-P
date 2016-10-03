package service;

import java.util.List;
import java.util.Map;

import dao.ContentsDao;

public class DrawerService {
	ContentsDao contentsDao;
	public DrawerService(ContentsDao contentsDao){
		this.contentsDao = contentsDao;
	}
	
	public  Map<String, Object> getContentsImage(String con_id){
		return contentsDao.getContentsImage(con_id);
	}
	
	public Map<String, Object> getContentsVideo(String con_id){
		return contentsDao.getContentsVideo(con_id);
	}

	public List<String> getCon_ids(String nickname) {
		// TODO Auto-generated method stub
		return contentsDao.getCon_ids(nickname);
	}

	public List<String> getTypes(String nickname) {
		// TODO Auto-generated method stub
		return contentsDao.getTypes(nickname);
	}

}
