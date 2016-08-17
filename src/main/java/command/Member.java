package command;

public class Member {
	String email;
	String nickname;
	String intro;
	String picture;
	
	public Member(){
		
	}
	public Member(String email, String nickname, String intro, String picture) {
		super();
		this.email = email;
		this.nickname = nickname;
		this.intro = intro;
		this.picture = picture;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}
