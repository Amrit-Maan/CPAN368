package com.ak.week2;

//This class acts as a MODEL or JavaBean to hold registration data
public class RegistrationClass {
	// Variables to store user input
	private String userName;
	private String password;
	private String retypePassword;
	private String mobileNumber;
	private String emailID;
	private String enterCaptchaImage;

	// Getter and Setter methods for each variable
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getEnterCaptchaImage() {
		return enterCaptchaImage;
	}

	public void setEnterCaptchaImage(String enterCaptchaImage) {
		this.enterCaptchaImage = enterCaptchaImage;
	}

}
