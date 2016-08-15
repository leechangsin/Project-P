package controller;

import org.springframework.web.multipart.MultipartFile;

public class FileVo {
	private MultipartFile pictureFile;

	public void setPictureFile(MultipartFile pictureFile) {
		this.pictureFile = pictureFile;
	}

	public MultipartFile getPictureFile() {
		return pictureFile;
	}
}