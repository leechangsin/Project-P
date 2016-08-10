
package command;

public class Contents {

	String writer;
	String Identification;
	String title;
	String content;
	String vidio;
	String picture;
	String hit_number;
	String like_number;
	String comment_number;
	String share_number;
	String reg_date;
	String summary;
	
	public Contents(){
		
	}
	
	public Contents(String writer, String identification, String title, String content, String vidio, String picture,
			String hit_number, String like_number, String comment_number, String share_number, String reg_date,
			String summary) {
		super();
		this.writer = writer;
		Identification = identification;
		this.title = title;
		this.content = content;
		this.vidio = vidio;
		this.picture = picture;
		this.hit_number = hit_number;
		this.like_number = like_number;
		this.comment_number = comment_number;
		this.share_number = share_number;
		this.reg_date = reg_date;
		this.summary = summary;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setIdentification(String identification) {
		Identification = identification;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setVidio(String vidio) {
		this.vidio = vidio;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public void setHit_number(String hit_number) {
		this.hit_number = hit_number;
	}
	public void setLike_number(String like_number) {
		this.like_number = like_number;
	}
	public void setComment_number(String comment_number) {
		this.comment_number = comment_number;
	}
	public void setShare_number(String share_number) {
		this.share_number = share_number;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getWriter() {
		return writer;
	}
	public String getIdentification() {
		return Identification;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getVidio() {
		return vidio;
	}
	public String getPicture() {
		return picture;
	}
	public String getHit_number() {
		return hit_number;
	}
	public String getLike_number() {
		return like_number;
	}
	public String getComment_number() {
		return comment_number;
	}
	public String getShare_number() {
		return share_number;
	}
	public String getReg_date() {
		return reg_date;
	}
	public String getSummary() {
		return summary;
	}
	
	
}
