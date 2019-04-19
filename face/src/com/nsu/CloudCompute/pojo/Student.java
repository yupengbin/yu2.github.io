package com.nsu.CloudCompute.pojo;

public class Student {
	private String phoneNum;
	private int major;
	private String studentId;
	private String studentName;
	private String password;
	private String image;
	private int labId;
	
	
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getMajor() {
		return major;
	}
	public void setMajor(int major) {
		this.major = major;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getLabId() {
		return labId;
	}
	public void setLabId(int labId) {
		this.labId = labId;
	}
	@Override
	public String toString() {
		return "Student [phoneNum=" + phoneNum + ", major=" + major + ", studentId=" + studentId + ", studentName="
				+ studentName + ", password=" + password + ", image=" + image + ", labId=" + labId + "]";
	}
	
	
	
	

}
