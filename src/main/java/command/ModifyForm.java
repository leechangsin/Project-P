package command;

public class ModifyForm {

	private String email;
	private Boolean emailChanged;
	private String passwd;
	private String confirmPasswd;
	private Boolean passwdChanged;
	private String reg_date;
	private String birth_date;
	private String sex;
	private String nickname;
	private Boolean nicknameChanged;
	private String intro;
	private Object picture;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEmailChanged() {
		return emailChanged;
	}

	public void setEmailChanged(Boolean emailChanged) {
		this.emailChanged = emailChanged;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getConfirmPasswd() {
		return confirmPasswd;
	}

	public void setConfirmPasswd(String confirmPasswd) {
		this.confirmPasswd = confirmPasswd;
	}

	public Boolean getPasswdChanged() {
		return passwdChanged;
	}

	public void setPasswdChanged(Boolean passwdChanged) {
		this.passwdChanged = passwdChanged;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Boolean getNicknameChanged() {
		return nicknameChanged;
	}

	public void setNicknameChanged(Boolean nicknameChanged) {
		this.nicknameChanged = nicknameChanged;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Object getPicture() {
		return picture;
	}

	public void setPicture(Object picture) {
		this.picture = picture;
	}

}