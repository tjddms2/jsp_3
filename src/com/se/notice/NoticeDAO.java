package com.se.notice;

import java.util.List;

import com.se.board.BoardDAO;
import com.se.board.BoardDTO;

public class NoticeDAO implements BoardDAO {

	@Override
	public List<BoardDTO> selectList(int startRow, int lastRow, String kind, String search) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCount(String kind, String search) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
	
	
}
