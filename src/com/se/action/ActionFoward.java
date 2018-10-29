package com.se.action;

public class ActionFoward {

	private boolean check;			//true : foward false: redirect	
	private String path; 			//이동해야할 주소 : 요청경로
	
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
