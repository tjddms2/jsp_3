package com.se.page;



public class MakePager {

	private int curPage;
	private int perPage;
	private RowNumber rowNumber;
	private Search search;
	
	public MakePager(int curPage, String search, String kind) {
		this(curPage, 10, search, kind);
	}
	
	public MakePager(int curPage, int perPage, String search, String kind) {
		this.curPage = curPage;
		this.search =  new Search();
		this.search.setKind(kind);
		this.search.setSearch(search);
		this.perPage=perPage;
	}
	
	public RowNumber makeRow() { 				
		rowNumber = new RowNumber();
		rowNumber.setStartRow((this.curPage-1)*this.perPage+1);   				//startRow
		rowNumber.setLastRow(this.curPage*this.perPage);						//lastRow
		rowNumber.setSearch(this.search); 										//search 
		return rowNumber;
	}
	
	public Pager makePage(int totalCount) {
		//1.totalPage 전체페이지구하기
		int totalPage=totalCount/this.perPage;
		if(totalCount%this.perPage !=0) {
			totalPage++;
		}
		//2.totalBlock  전체블럭 구하기
		int perBlock = 5;
		int totalBlock = totalPage/perBlock;									//perBlock 
		if(totalPage%perBlock !=0) {
			totalBlock++;
		}
		//3.curBlock
		int curBlock =  this.curPage/perBlock;
		if(this.curPage%perBlock !=0) {
			curBlock++;
		}
		//4.startNum, lastNum 구하기
		int startNum = (curBlock-1)*perBlock+1;
		int lastNum = curBlock*perBlock;
		
		//5. curBlock 마지막 Block
		if(curBlock == totalBlock) {
			lastNum = totalPage;
		}
		
		Pager pager = new Pager();
		pager.setCurBlock(curBlock);
		pager.setTotalBlock(totalBlock);
		pager.setStartNum(startNum);
		pager.setLastNum(lastNum);
		pager.setSearch(this.search);
		pager.setTotalPage(totalPage);
		return pager;
	}
	
}
