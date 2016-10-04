package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.ContentsDao;

@Controller
@RequestMapping("/contents")
public class ContentsUI_Controller {
	private ContentsDao contentsDao;

	public ContentsUI_Controller(ContentsDao contentsDao) {
			this.contentsDao = contentsDao;
	}

	@RequestMapping("main")
	public String contenstsUI() {
		return "ContentsUI";
	}

	/* 템플릿 메서드들
	 * 웹프로그래밍 기술이 향상된다음에 다음과같은 구조로
	 * 코딩할것
	@RequestMapping("saveContents")
	public String saveContents(){
		savePicture(new FileVo());
		saveVideo();
		saveText();
		return "redirect:main";
	}
	
	@RequestMapping("getContents")
	public String getContents(){
		getPicture();
		getVideo();
		getText();
		return "redirect:main";
	}
	*/
/* 컨텐츠 개발할때 주석 풀기...
	@RequestMapping("savePicture")
	public String savePicture(FileVo fileVo) {
		try {
			Map<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("picture", fileVo.getPictureFile().getBytes());
			contentsDao.savePicture(hashMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:main";
	}
*/
	/*미구현 메서드들
	public String saveVideo(){
		
		return "redirect:main";
	}
	public String saveText(){
		
		return "redirect:main";
	}
	*/
/*
	@RequestMapping("getPicture")
	public ResponseEntity<byte[]> getPicture(){
		Map<String, Object> hashMap = contentsDao.getPicture();
		byte[] picture = (byte[]) hashMap.get("picture");
		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<byte[]>(picture, header, HttpStatus.OK);
	}
	
	@RequestMapping("getVideo")
	public ResponseEntity<byte[]> getVideo(){
		Map<String, Object> hashMap = contentsDao.getVideo();
		byte[] video = (byte[]) hashMap.get("picture");
		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<byte[]>(video, header, HttpStatus.OK);
	}
*/
	/*미구현 메서드
	@RequestMapping("getText")
	public String getText(){
		String text = memberDao.getText();
		return text;
	}
	*/
}