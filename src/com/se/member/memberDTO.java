package com.se.member;

public class memberDTO {
	private int num;
	private String Id;
	private String pw;
	private String name;
	private String email;
	private String kind;
	private String classMate;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getClassMate() {
		return classMate;
	}
	public void setClassMate(String classMate) {
		this.classMate = classMate;
	}
	
	
}
