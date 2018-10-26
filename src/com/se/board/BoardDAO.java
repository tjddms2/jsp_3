package com.se.board;

import java.util.List;

import com.se.page.RowNumber;

public interface BoardDAO {

	//selcetList
	public List<BoardDTO> selectList(RowNumber rowNumber) throws Exception;
	
	//selectOne
	public BoardDTO selectOne(int num)throws Exception; //¼±¾ðºÎ
	
	//insert
	public int insert(BoardDTO boardDTO) throws Exception;
	
	//update
	public int update(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int delete(int num) throws Exception;
	
	//getCount
	public int getCount(String kind, String search) throws Exception;
	
	
}
