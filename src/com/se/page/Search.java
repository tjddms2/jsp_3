package com.se.page;

public class Search {
	
	private String kind;
	private String search;
	
	public String getKind() {			//가지고 나올때, 체크할수있음
		if(this.kind ==null || this.kind.equals("")) {
			this.kind="title";
		}
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;		//혹시 null 일때 위에다가
		if(kind == null || kind.equals("")) {
			this.kind="title";
		}
	}
	public String getSearch() {
		if(this.search == null) {
			this.search="";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
		if(search ==null) {
			this.search="";
		}
	}
	
	
	
	
}
