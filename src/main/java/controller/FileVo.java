package controller;

import org.springframework.web.multipart.MultipartFile;

public class FileVo {
	private MultipartFile pictureFile;
	private MultipartFile videoFile;

	public void setPictureFile(MultipartFile pictureFile) {
		this.pictureFile = pictureFile;
	}

	public MultipartFile getPictureFile() {
		return pictureFile;
	}

	public MultipartFile getVideoFile() {
		return videoFile;
	}

	public void setVideoFile(MultipartFile videoFile) {
		this.videoFile = videoFile;
	}

}