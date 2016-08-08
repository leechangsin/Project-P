package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberDao;

@Controller
@RequestMapping("/contents")
public class ContentsUI_Controller {
	private MemberDao memberDao;

	public ContentsUI_Controller(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@RequestMapping("main")
	public String contenstsUI() {
		return "ContentsUI";
	}

	@RequestMapping("savePicture")
	public String savePicture(FileVo fileVo) {
		try {
			Map<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("picture", fileVo.getPictureFile().getBytes());
			memberDao.savePicture(hashMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:main";
	}
	
	@RequestMapping("getPicture")
	public ResponseEntity<byte[]> getPicture(){
		Map<String, Object> hashMap = memberDao.getPicture();
		byte[] picture = (byte[]) hashMap.get("picture");
		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<byte[]>(picture, header, HttpStatus.OK);
	}
	
	@RequestMapping("getVideo")
	public ResponseEntity<byte[]> getVideo(){
		Map<String, Object> hashMap = memberDao.getPicture();
		byte[] picture = (byte[]) hashMap.get("picture");
		final HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<byte[]>(picture, header, HttpStatus.OK);
	}
}